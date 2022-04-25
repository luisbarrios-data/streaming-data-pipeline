package com.labs1904.hwe

//Challenge 4 Implement Word Count in the WorldCountStreamingApp Structured Streaming App

import com.labs1904.hwe.WordCountBatchApp.splitSentenceIntoWords
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.{OutputMode, Trigger}
import org.apache.spark.sql.SparkSession

/**
 * Spark Structured Streaming app
 */
object WordCountStreamingApp {
  lazy val logger: Logger = Logger.getLogger(this.getClass)
  val jobName = "WordCountStreamingApp"
  // TODO: define the schema for parsing data from Kafka

  val bootstrapServers = "localhost:9092"
  val Topic: String = "word-count"
  //val username: String = "changeMe"
  //val password: String = "changeMe"

  //Use this for Windows
  val trustStore: String = "C:\\Users\\luisa\\Desktop\\AppDE\\streaming-data-pipeline\\kafka-hello-world\\src\\main\\resources\\kafka.client.truststore.jks"

  //Use this for Mac
  //val trustStore: String = "src/main/resources/kafka.client.truststore.jks"






  def main(args: Array[String]): Unit = {
    logger.info(s"$jobName starting...")

    try {
      val spark = SparkSession.builder()
        .appName(jobName)
        .config("spark.sql.shuffle.partitions", "3")
        .master("local[*]")
        .getOrCreate()

      import spark.implicits._

      val sentences = spark
        .readStream
        .format("kafka")
        .option("kafka.bootstrap.servers", bootstrapServers)
        .option("subscribe", "word-count")
        .load()
        .selectExpr("CAST(value AS STRING)").as[String]

      sentences.printSchema

      // TODO: implement me
      val splitSentence = sentences.flatMap(row => splitSentenceIntoWords(row))

      val words = splitSentence.map(row => WordCount(row,1))
      val wordCount = words.groupBy(col("word")).count().orderBy(col("count").desc).limit(10)

      val query = wordCount.writeStream // Updated sentences.writeStream to wordCount.writeStream
        .outputMode(OutputMode.Complete()) // Updating from Append() to Complete() since existing rows are bound to change and entire result table will need to be re-written
        .format("console")
        .trigger(Trigger.ProcessingTime("5 seconds"))
        .option("truncate", false) // Disabling row truncation
        .start()

      query.awaitTermination()


      /*val counts = ???

      val query = counts.writeStream
        .outputMode(OutputMode.Complete())
        .format("console")
        .trigger(Trigger.ProcessingTime("30 seconds"))
        .start()

      query.awaitTermination()*/




    } catch {
      case e: Exception => logger.error(s"$jobName error in main", e)
    }
  }

//  def getScramAuthString(username: String, password: String) = {
//    s"""org.apache.kafka.common.security.scram.ScramLoginModule required
//   username=\"$username\"
//   password=\"$password\";"""
//  }


}

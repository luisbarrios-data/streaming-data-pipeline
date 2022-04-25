package com.labs1904.hwe.homework

import org.apache.log4j.Logger
import org.apache.spark.sql.{Dataset, SparkSession}


// Challenge 1 - Run the Batch App
object HelloWorldBatchApp {
  lazy val logger: Logger = Logger.getLogger(this.getClass)
  val jobName = "HelloWorldBatchApp"

  def main(args: Array[String]): Unit = {
    try {
      logger.info(s"$jobName starting...")
      //TODO: What is a spark session - Why do we need this line?
      //creates a new spark session object
      val spark = SparkSession.builder()
        .appName(jobName)
        .config("spark.sql.shuffle.partitions", "3")
        //TODO- What is local[*] doing here?
        // [*]  means for all, as many threads as there are in your machine. Local  keyword is used to run spark locally.
        .master("local[*]")
        //TODO- What does Get or Create do?
        //Gets an existing SparkSession or, if there is no existing one, creates a new one based on the options set in this builder.
        .getOrCreate()

      import spark.implicits._
      val sentences: Dataset[String] = spark.read.csv("src/main/resources/sentences.txt").as[String]
      // print out the names and types of each column in the dataset
      sentences.printSchema
      // display some data in the console, useful for debugging
      //TODO- Make sure this runs successfully
      sentences.show(truncate = false)
    } catch {
      case e: Exception => logger.error(s"$jobName error in main", e)
    }
  }
}

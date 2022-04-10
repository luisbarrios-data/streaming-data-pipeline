package com.labs1904.hwe.homework

import org.apache.log4j.Logger
import org.apache.spark.sql.{Dataset, SparkSession}

object HelloWorldBatchApp {
  lazy val logger: Logger = Logger.getLogger(this.getClass)
  val jobName = "HelloWorldBatchApp"

  def main(args: Array[String]): Unit = {
    try {
      logger.info(s"$jobName starting...")
      //TODO: What is a spark session - Why do we need this line?
      // It is an entry point to underlying Spark functionality in order to programmatically use Spark RDD, DataFrame and Dataset.
      // Creating a SparkSession instance would be the first statement you would write to program with RDD, DataFrame and Dataset.
      val spark = SparkSession.builder()
        .appName(jobName)
        .config("spark.sql.shuffle.partitions", "3")
        //TODO- What is local[*] doing here?
        // Use local[x] when running in Standalone mode. x should be an integer value and should be greater than 0;
        // this represents how many partitions it should create when using RDD, DataFrame, and Dataset.
        // Ideally, x value should be the number of CPU cores you have.
        .master("local[*]")
        //TODO- What does Get or Create do?
        // getOrCreate() – This returns a SparkSession object if already exists, creates new one if not exists.
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

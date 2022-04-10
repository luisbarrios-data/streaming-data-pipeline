# Overview

Similar to the work you did for Kafka, this is your crash course into Spark through different questions. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like
* Spark By Examples is a great resources to start with - [Spark By Examples](https://sparkbyexamples.com/)

### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Spark help solve? Use a specific use case in your answer 
* Helpful resource: [Apache Spark Use Cases](https://www.toptal.com/spark/introduction-to-apache-spark)
* [Overivew of Apache Spark](https://www.youtube.com/watch?v=znBa13Earms&t=42s)

Spark provides a faster and more general data processing platform. Spark lets you run programs up to 100x faster in memory, or 10x faster on disk, than other tools for big data processing.
- In the game industry, processing and discovering patterns from the potential firehose of real-time in-game events.
- In the e-commerce industry, real-time transaction information could be passed to a streaming clustering algorithms.
- In the finance or security industry, the Spark stack could be applied to a fraud or intrusion detection system or risk-based authentication.

#### What is Apache Spark?
* Helpful resource: [Spark Overview](https://www.youtube.com/watch?v=ymtq8yjmD9I) 
Apache Spark is an Open source analytical processing engine for large scale powerful distributed data processing and machine learning applications. It is advertised as “lightning fast cluster computing”.

#### What is distributed data processing? How does it relate to Apache Spark?  
[Apache Spark for Beginners](https://medium.com/@aristo_alex/apache-spark-for-beginners-d3b3791e259e)
Data processing is ingesting massive amounts of data in the system from several different sources such as IoT devices, social platforms, satellites, wireless networks, software logs etc. & running the business logic/algorithms on it to extract meaningful information from it. It is advertised as “lightning fast cluster computing” which means is the best opensource tool for data processing as today. 

#### On the physical side of a spark cluster, you have a driver and executors. Define each and give an example of how they work together to process data
RDD are done via drivers and executors. When a program executes it starts with a driver which creates a Spark contexts to orchestrate the code and determines the possible task to perform.
It generates a physical plan and then uses the cluster manager to coordinate all of the executors to schedule and run the task and returned to the driver.
#### Define each and explain how they are different from each other 
* RDD (Resilient Distributed Dataset): is programming abstraction that represents a collection of read-only objects split across a computing cluster. 
* DataFrame: is an integrated data structure with an easy-to-use API for simplifying distributed big data processing. It is an extension of the Spark RDD API optimized for writing code more efficiently while remaining powerful. DataFrames resemble relational database tables or excel spreadsheets with headers: the data resides in rows and columns of different datatypes. 
* DataSet: is a data structure in SparkSQL which is strongly typed and is a map to a relational schema. It represents structured queries with encoders. It is an extension to data frame API. Spark Dataset provides both type safety and object-oriented programming interface.

#### What is a spark transformation?
[Spark By Examples-Transformations](https://sparkbyexamples.com/apache-spark-rdd/spark-rdd-transformations/)
RDD Transformations are Spark operations when executed on RDD, it results in a single or multiple new RDD’s. Since RDD are immutable in nature, transformations always create new RDD without updating an existing one hence, this creates an RDD lineage.

#### What is a spark action? How do actions differ from transformations? 
Transitions are operations (such as map, filter, join, union) that are performed on an RDD that yields a new RDD containing the result.
On the other hand, actions (such as reduce, first, count) that return a value after running a computation on an RDD.

#### What is a partition in spark? Why would you ever need to repartition? 
[Spark Partitioning](https://sparkbyexamples.com/spark/spark-repartition-vs-coalesce/)
- By default, Spark/PySpark creates partitions that are equal to the number of CPU cores in the machine.
- Data of each partition resides in a single machine.
- While working with partition data we often need to increase or decrease the partitions based on data distribution. Methods repartition() and coalesce() helps us to repartition.

#### What was the most fascinating aspect of Spark to you while learning? 
- Active and expanding community
  Developers from over 300 companies have contributed to design and build Apache Spark. Ever since 2009, more than 1200 developers have actively contributed to making Spark what it is today! Naturally, Spark is backed by an active community of developers who work to improve its features and performance continually.
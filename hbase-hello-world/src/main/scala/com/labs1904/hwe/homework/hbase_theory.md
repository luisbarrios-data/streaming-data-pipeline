# Overview

By now you've seen some different Big Data frameworks such as Kafka and Spark. Now we'll be focusing in on HBase. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like


### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What is a NoSQL database? 
The term ‘NoSQL’ refers to nonrelational types of databases, and these databases store data in a format that’s different from relational tables.
However, NoSQL databases can be queried using idiomatic language APIs, declarative structured query languages, and query-by example languages, which is why they are also referred to as “not only SQL” databases.
NoSQL databases, data can be stored without defining the schema upfront—which means you have the ability to get moving and iterate quickly, defining the data model as you go. 
This can be suitable for specific business requirements, whether it’s graph-based, column-oriented, document-oriented, or as a key-value store.
#### In your own words, what is Apache HBase? 
HBase is a distributed column-oriented database built on top of the Hadoop file system. It is an open-source project and is horizontally scalable.
It enables random, strictly consistent, real-time access to petabytes of data. HBase is very effective for handling large, sparse datasets.

#### What are some strengths and limitations of HBase? 
* [HBase By Examples](https://sparkbyexamples.com/apache-hbase-tutorial/)

* Strengths:
- HBase can handle as well as stores large datasets on top of HDFS file storage. Moreover, it aggregates and analyzes billions of rows present in the HBase tables.
- There is a time when relational databases break down, then HBase shines in the picture.
- Operations such as data reading and processing will take small amount of time as compared to traditional relational models.
- HBase splits data stored in tables across multiple hosts in the cluster and is built to withstand individual host failures.
 
- Limitations:
- It is not possible to implement any cross data operations and joining operations, in HBase.
- When we want to migrate data from RDBMS external sources to HBase servers, HBase would require a new design.
- HBase is really tough for querying.
- HBase is CPU and Memory intensive with large sequential input or output access while as Map Reduce jobs are primarily input or output bound with fixed memory. 
  HBase integrated with Map-reduce jobs will result in unpredictable latencies

#### Explain the following concepts: 
* Rowkey: This part of the HBase key (represented by a byte [ ] ) comes first and labels/identifies a composite data point in a multi-dimensional data space. 
          This can also be looked as a row identifier (row id) to a data row in traditional databases.
* Column Qualifier: This part (represented by a byte [ ] ) comes next to rowkey part and labels a multi-dimensional data space of which a composite data point is part of. Dimensions in this data space are logically related and each of this dimension is termed as column qualifier. 
                    HBase table allow existence of one or more column families comprising of one or more column qualifiers.
* Column Family: This part (represented by a byte [ ] ) comes next to the column qualifier part and labels a single data dimension in a multi-dimensional data space represented by a column family. 
                 Column Family along with a Column Qualifier can be looked as an identifier (column name) to a data column in a traditional database.


#### What are the differences between Get and Put commands in HBase? 
* [HBase commands](https://www.tutorialspoint.com/hbase/hbase_create_data.htm)
  The get command and the get() method of HTable class are used to read data from a table in HBase. Using put command, you can create, and insert rows into a table.


#### What is the HBase Scan command for? 
* [HBase Scan](https://www.tutorialspoint.com/hbase/hbase_scan.htm)
  The scan command is used to view the data in HTable. Using the scan command, you can get the table data.

#### What was the most interesting aspect of HBase when went through all the questions? 
The performance and data model for Hbase are very interesting. For example, HBase is used to store billions of rows of detailed call records. 
If 20TB of data is added per month to the existing RDBMS database, performance will deteriorate.
To handle a large amount of data in this use case, HBase is the best solution. HBase performs fast querying and displays records.
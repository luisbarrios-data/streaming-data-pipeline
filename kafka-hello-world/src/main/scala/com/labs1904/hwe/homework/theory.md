# Overview

Kafka has many moving pieces, but also has a ton of helpful resources to learn available online. In this homework, your
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
#### What problem does Kafka help solve? Use a specific use case in your answer 

* Helpful resource: [Confluent Motivations and Use Cases](https://youtu.be/BsojaA1XnpM)

- The main problem of kafka is aiming to solve is the real-time stream of event or logs. In other words, faster and more efficient.
- the infrastructure allows distributed parallel processing that is scalable and replicable.

#### What is Kafka?
* Helpful resource: [Kafka in 6 minutes](https://youtu.be/Ch5VhJzaoaI)

- Kafka is tool to add computing power by distributing the workload in several partitions
- It is a platform where different consumers could connect
- all events stored for historical view

#### Describe each of the following with an example of how they all fit together: 
 * Topic: is the category/feed name to which records are stored and published. Logs are also fundamentally durable things. Traditional enterprise messaging systems have topics and queues, which store messages temporarily to buffer them between source and destination. They are similar to a table in a database(without all the constraints)
 * Producer: is the input or source of data that must be stored
 * Consumer: user requesting data and updates
 * Broker: these may not be separate physical servers but containers running on pods running on virtualized servers running on actual processors in a physical datacenter somewhere. However they are deployed, they are independent machines each running the Kafka broker process. Each broker hosts some set of partitions and handles incoming requests to write new events to those partitions or read events from them.
 * Partition: Partitioning takes the single topic log and breaks it into multiple logs, each of which can live on a separate node in the Kafka cluster.

#### Describe Kafka Producers and Consumers
Consumer can bee seen as user who read data from topics. They are divided into groups in order to improve parallelism but there cannot be more consumer than partitions.
#### How are consumers and consumer groups different in Kafka? 

* Helpful resource: [Consumers](https://youtu.be/lAdG16KaHLs)
* Helpful resource: [Confluent Consumer Overview](https://youtu.be/Z9g4jMQwog0)


#### How are Kafka offsets different than partitions? 
The offsets could be seen as the unique sequence that messages have to follow within a partition (Every partition is in order). On the other hand, partitions could be seen as the container for the data or messages.


#### How is data assigned to a specific partition in Kafka? 
Producers write data into topics that may contain one or more partitions. Then, Kafka Brokers take a part of the partitions in a loaded balance cluster to realize operations.

#### Describe immutability - Is data on a Kafka topic immutable? 
Each such partition contains messages in an immutable ordered sequence. which means it does not change its order. It also means that when the dat is written in a partition it cannot be changed. 

#### How is data replicated across brokers in kafka? If you have a replication factor of 3 and 3 brokers, explain how data is spread across brokers
* Helpful resource [Brokers and Replication factors](https://youtu.be/ZOU7PJWZU9w)
- The purpose of a replication factor is avoid failure in case one of the brokers goes down. The replication factor is individual for each broker since only one of the brokers is the leader for each topic partitions.

#### What was the most fascinating aspect of Kafka to you while learning? 
The performance is incredible with less than 10ms of latency. It is a relatively new technology, but it is becoming the common tool for stream processing. 

*helpful resource [Complete Guide](https://www.tutorialspoint.com/apache_kafka/index.htm)


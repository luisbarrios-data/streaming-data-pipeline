package com.labs1904.hwe

import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, Delete, Get, Put, Scan}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.logging.log4j.{LogManager, Logger}

object MyApp {
  lazy val logger: Logger = LogManager.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    logger.info("MyApp starting...")
    var connection: Connection = null
    try {
      val conf = HBaseConfiguration.create()
      conf.set("hbase.zookeeper.quorum", "ChangeMe")
      connection = ConnectionFactory.createConnection(conf)
      // Example code... change me
      val table = connection.getTable(TableName.valueOf("lbarrios:users"))



      //Challenge 1
      val challenge1 = {
        val get = new Get(Bytes.toBytes("10000001"))
        val result = table.get(get)

        val message = Bytes.toString(result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("mail")))
        logger.debug(message)
      }


      //Challenge 2
      val challenge2 = {
        val put = new Put(Bytes.toBytes("99"))


        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("username"), Bytes.toBytes("DE-HWE"))
        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("name"), Bytes.toBytes("The panther"))
        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("sex"), Bytes.toBytes("F"))
        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("favorite_color"), Bytes.toBytes("Pink"))


        table.put(put)

        val get = new Get(Bytes.toBytes("99"))
        val newTable = table.get(get)
        logger.debug(newTable)
      }

      //Challenge 3
      val challenge3 = {

        val scan = new Scan().withStartRow(Bytes.toBytes("10000001")).withStopRow(Bytes.toBytes("10006001"))
        val count = table.getScanner(scan).iterator()

        var rows = 0
        while(count.hasNext){
          count.next()
          rows += 1
        }

        logger.debug(rows)
      }

      //Challenge 4
      val challenge4 ={
        val delete = new Delete(Bytes.toBytes("99"))
        table.delete(delete)

        val get = new Get(Bytes.toBytes("99"))
        val deleteOutput = table.get(get)
        logger.debug(deleteOutput)
      }

      //Challenge 5
      val challenge5 = {

        List(Bytes.toBytes("9005729"), Bytes.toBytes("500600"), Bytes.toBytes("30059640"), Bytes.toBytes("6005263"), Bytes.toBytes("800182")).foreach(s => {
          val get = new Get(s)
          val result = table.get(get)

          val message = Bytes.toString(result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("mail")))
          logger.debug(message)
        })

        }




    } catch {
      case e: Exception => logger.error("Error in main", e)
    } finally {
      if (connection != null) connection.close()
    }
  }
}

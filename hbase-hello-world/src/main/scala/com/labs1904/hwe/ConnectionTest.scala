package com.labs1904.hwe

import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, Get, Put}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.logging.log4j.{LogManager, Logger}

object ConnectionTest {
  lazy val logger: Logger = LogManager.getLogger(this.getClass)


  def main(args: Array[String]) = {

    var connection: Connection = null
    try {
      logger.debug("Starting app")
      val conf = HBaseConfiguration.create()
      conf.set("hbase.zookeeper.quorum", "hbase02.hourswith.expert:2181")
      connection = ConnectionFactory.createConnection(conf)
      val table = connection.getTable(TableName.valueOf("lbarrios:users"))
      val get = new Get(Bytes.toBytes("10000001"))
      val result = table.get(get)
      val message = Bytes.toString(result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("mail")))


      val put = new Put(Bytes.toBytes("99"))


      put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("username"), Bytes.toBytes("DE-HWE"))
      put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("name"), Bytes.toBytes("The panther"))
      put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("sex"), Bytes.toBytes("F"))
      put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("favorite_color"), Bytes.toBytes("Pink"))

      //val writeUser = new Put (Bytes.toBytes("99"))
      //writeUser.addColumn(Bytes.toBytes("f1"), Bytes.toBytes(


      //table.put(message)
      logger.debug(message)
      //logger.debug(put)


    } catch {
      case e: Exception => logger.error("Error in main", e)
    } finally {
      if (connection != null) connection.close()
    }


  }
}

package com.datastax.spark.example

import com.datastax.spark.connector._
import com.datastax.spark.connector.cql.CassandraConnector
import com.typesafe.config.{Config, ConfigFactory}
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.sql.cassandra._
import org.apache.spark.sql.SparkSession
import spark.jobserver.{SparkJob, SparkJobInvalid, SparkJobValid, SparkJobValidation}

import scala.slick.direct.AnnotationMapper.table
import scala.util.Try

/**
  * A super-simple Spark job example that implements the SparkJob trait and can be submitted to the job server.
  *
  * Set the config with the sentence to split or count:
  * input.string = "adsfasdf asdkf  safksf a sdfa"
  *
  * validate() returns SparkJobInvalid if there is no input.string
  */
object WriteRead extends SparkJob {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("Datastax Scala example")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    // Create keyspace and table
    CassandraConnector(spark.sparkContext).withSessionDo { session =>
      session.execute(
        """CREATE KEYSPACE IF NOT EXISTS ks WITH
          | replication = {'class': 'SimpleStrategy', 'replication_factor': 1 }""".stripMargin)
      session.execute("""CREATE TABLE IF NOT EXISTS ks.kv (k int, v int, PRIMARY KEY (k))""")
    }

    // Write some data
    spark.range(1, 10)
      .map(x => (x, x))
      .rdd
      .saveToCassandra("ks", "kv")

    // Read data as RDD
    val rdd = spark.sparkContext
      .cassandraTable(keyspace = "ks", table = "kv")

    // Read data as DataSet (DataFrame)
    val dataset = spark.read
      .cassandraFormat(keyspace = "ks", table = "kv")
      .load()

    println("Data read as RDD")
    rdd.collect()
      .foreach(println)

    println("Data read as DataSet (DataFrame)")
    dataset.collect()
      .foreach(println)

    spark.stop()
    sys.exit(0)
  }

  override def validate(sc: SparkContext, config: Config): SparkJobValidation = {
    Try(config.getString("input.string"))
      .map(x => SparkJobValid)
      .getOrElse(SparkJobInvalid("No input.string config param"))
  }

  override def runJob(sc: SparkContext, config: Config): Any = {
    sc.parallelize(config.getString("input.string").split(" ").toSeq).countByValue
  }
}


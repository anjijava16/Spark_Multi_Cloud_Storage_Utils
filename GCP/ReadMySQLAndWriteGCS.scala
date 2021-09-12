package com.mts.analytics.utils

import org.apache.spark.sql.{SaveMode, SparkSession}

object ReadMySQLAndWriteGCS {


  def main4(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder
      .appName("GCS")
      .master("local[*]")
      .getOrCreate()

    val jsonKeyFile = "C:/Tech_Learn_welcome/Cloud_Tech_Learn/Google_Cloud/iwinner-data-6dd48df16d54.json"
    spark.sparkContext.hadoopConfiguration.set("google.cloud.auth.service.account.json.keyfile", jsonKeyFile)



    print(" CSV Read Data ")
    // Read CSV File
    val csvDF = spark.read.format("csv").option("header", "true").load("gs://iwinner-gcs-data/csv-data/categories")
    csvDF.printSchema()
    csvDF.show(10, false)

    print(" ORC Read Data ")
    // Read ORC File
    val orcDF = spark.read.format("orc").load("gs://iwinner-gcs-data/orc-data/categories")
    orcDF.printSchema()
    orcDF.show(10, false)

    print(" Parquet Read Data ")
    // Read Parquet File
    val parquetDF = spark.read.format("parquet").load("gs://iwinner-gcs-data/parquet-data/categories")
    parquetDF.printSchema()
    parquetDF.show(10, false)

  }
  def main(args: Array[String]): Unit = {


    var names = Array("categories", "customers", "departments", "ingest_config_tabs", "ingest_history", "orders", "order_items", "products");


    for (tableName <- names) {

      val spark = SparkSession
        .builder
        .appName("GCS")
        .master("local[*]")
        .getOrCreate()

      val jsonKeyFile = "C:/Tech_Learn_welcome/Cloud_Tech_Learn/Google_Cloud/iwinner-data-6dd48df16d54.json"

      spark.sparkContext.hadoopConfiguration.set("google.cloud.auth.service.account.json.keyfile", jsonKeyFile)


      val readDF = spark.read.format("jdbc")
        .option("url", "jdbc:mysql://localhost:3306/ingestion_db?useSSL=false")
        .option("dbtable", tableName)
        .option("user", "root")
        .option("password", "root").load()

      readDF.printSchema()
      readDF.show(10, false)

      val process_date="/process_date="+new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/"
      //iwinner-gcs-data
      readDF.write.format("csv").option("header","true").mode(SaveMode.Overwrite).save("gs://iwinner-gcs-data/csv-data"+"/"+tableName+process_date)


      //iwinner-gcs-data
      readDF.write.format("orc").mode(SaveMode.Overwrite).save("gs://iwinner-gcs-data/orc-data"+"/"+tableName+process_date)


      //iwinner-gcs-data
      readDF.write.format("parquet").mode(SaveMode.Overwrite).save("gs://iwinner-gcs-data/parquet-data"+"/"+tableName+process_date)
    }


  }
}

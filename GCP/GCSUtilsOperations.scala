package com.mts.analytics.clouddwh.google

import org.apache.spark.sql.{SaveMode, SparkSession}

object GCSUtilsOperations {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder
      .appName("GCS")
      .master("local[*]")
      .getOrCreate()

    val jsonKeyFile = "C:/Tech_Learn_welcome/Cloud_Tech_Learn/Google_Cloud/iwinner-data-6dd48df16d54.json"

    spark.sparkContext.hadoopConfiguration.set("google.cloud.auth.service.account.json.keyfile", jsonKeyFile)

    // Read File
    val df = spark.read.format("csv").option("header", "true").load("gs://iwinner-gcs-data/50_Startups.csv")
    df.printSchema()
    df.show(10, false)


    // Write File
    df.write.format("csv").mode(SaveMode.Append).save("gs://iwinner-gcs-op-data/startup/")
  }
}

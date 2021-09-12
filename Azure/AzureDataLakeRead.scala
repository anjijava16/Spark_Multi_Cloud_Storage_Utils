package com.mts.analytics.clouddwh.azure

import org.apache.spark.sql.SparkSession

object AzureParquetFileReads {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("read azure storage").master("local[*]").getOrCreate()

    spark.conf.set("fs.defaultFS", "abfs://data@gen2iwinnerdb.dfs.core.windows.net/")
    spark.conf.set("fs.azure.account.key.gen2iwinnerdb.dfs.core.windows.net", "xxxxxxxxxxxxxxxxxxxxxx")

 
    val df = spark.read.csv("abfs://data@gen2iwinnerdb.dfs.core.windows.net/inputdata/InputData.csv")
    df.show(10)
    
    
    // Write data
    df.write.format("parquet").save("abfs://data@gen2iwinnerdb.dfs.core.windows.net/outputdata/parquet/")
  }

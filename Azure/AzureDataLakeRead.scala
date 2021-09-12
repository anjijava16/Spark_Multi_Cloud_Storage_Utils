package com.mts.analytics.clouddwh.azure

import org.apache.spark.sql.SparkSession

object AzureParquetFileReads {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("read azure storage").master("local[*]").getOrCreate()

    spark.conf.set("fs.defaultFS", "abfs://data@gen2iwinnerdb.dfs.core.windows.net/")
    spark.conf.set("fs.azure.account.key.gen2iwinnerdb.dfs.core.windows.net", "xxxxxxxxxxxxxxxxxxxxxx")

    //yHJgKMzLNC7E+Q3YK3z8TlDLNME6rNRyUCHGoMKPwEmvaojagKogap3pIzOvj5s95YslUAevoEzfBOTHXMMiWQ==
    val df = spark.read.csv("abfs://data@gen2iwinnerdb.dfs.core.windows.net/inputdata/InputData.csv")
    df.show(10)
    
  }

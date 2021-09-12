object SparkUtils {

  def getSparkSession(parms: Map[String, String]): SparkSession = {
    val spark = SparkSession
      .builder
      .appName(parms("JOB_NAME"))
      .master("local[*]")
      .getOrCreate()

    val isS3Enable = parms("S3_OPERATION_ENABLE").toBoolean;
    if (isS3Enable) {
      spark.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", parms("S3_ACCESS_KEY"))
      spark.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", parms("S3_SECRET_KEY"))
      spark.sparkContext.hadoopConfiguration.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
      spark.sparkContext.hadoopConfiguration.set("spark.speculation", "false")
    }
    return spark;
  }
}

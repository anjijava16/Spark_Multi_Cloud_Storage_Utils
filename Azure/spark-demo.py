## Spark pool

df = spark.read.load('abfss://data@datagen2winner.dfs.core.windows.net/NYCTripSmall.parquet', format='parquet') #Please don't forget to replace your storage and file system name
df.printSchema()
display(df.limit(10))



spark.sql("CREATE DATABASE IF NOT EXISTS nyctaxi")
df.repartition(1)
df.write.mode("overwrite").saveAsTable("nyctaxi.trip")
spark.sql("Select count(*) from nyctaxi.trip")

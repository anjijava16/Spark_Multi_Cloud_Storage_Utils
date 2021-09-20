import org.joda.time._
import org.joda.time.format._
import com.microsoft.azure.cosmosdb.spark.schema._
import com.microsoft.azure.cosmosdb.spark.streaming.CosmosDBSinkProvider
import com.microsoft.azure.cosmosdb.spark.config.Config


val ConfigMap = Map(
"Endpoint" -> "YOUR.COSMOSDB.ENDPOINT",
"Masterkey" -> "YOUR.COSMOSDB.MASTERKEY",
"Database" -> "YOUR.COSMOSDB.DATABSE",
"Collection" -> "YOUR.COSMOSDB.COLLECTION",
"Upsert" -> "true"
)

streamdata.select("id","temperature","enqueuedTime")
  .writeStream
  .format(classOf[CosmosDBSinkProvider].getName)
  .outputMode("append")
  .options(ConfigMap)
  .option("checkpointLocation", "/tmp/streamingTelemetry")
  .start
====================================

import org.joda.time._
import org.joda.time.format._
 
import com.microsoft.azure.cosmosdb.spark.schema._
import com.microsoft.azure.cosmosdb.spark.CosmosDBSpark
import com.microsoft.azure.cosmosdb.spark.config.Config
 
import org.apache.spark.sql.functions._
import org.joda.time._
import org.joda.time.format._
import com.microsoft.azure.cosmosdb.spark.schema._
import com.microsoft.azure.cosmosdb.spark.CosmosDBSpark
import com.microsoft.azure.cosmosdb.spark.config.Config
import org.apache.spark.sql.functions._


// Configure the connection to your collection in Cosmos DB.
// Please refer to https://github.com/Azure/azure-cosmosdb-spark/wiki/Configuration-references
// for the description of the available configurations.
val configMap = Map(
  "Endpoint" -> {URI of the Azure Cosmos DB account},
  "Masterkey" -> {Key used to access the account},
  "Database" -> {Database name},
  "Collection" -> {Collection name},
  "preferredRegions" -> {Preferred regions})

val config = Config(configMap)
// Generate a simple dataset containing five values and
// write the dataset to Cosmos DB.


val df = spark.range(5).select(col("id").cast("string").as("value"))
CosmosDBSpark.save(df, config)

df: org.apache.spark.sql.DataFrame = [value: string]
// Read the data written by the previous cell back.

val dataInCosmosDb = spark.read.cosmosDB(config)
display(dataInCosmosDb.orderBy(col("value")))

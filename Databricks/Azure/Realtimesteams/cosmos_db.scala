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

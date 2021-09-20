# Set up the Blob storage account access key in the notebook session conf.
spark.conf.set(
  "fs.azure.account.key.<your-storage-account-name>.blob.core.windows.net",
  "<your-storage-account-access-key>")

# Prepare streaming source; this could be Kafka or a simple rate stream.
df = spark.readStream \
  .format("rate") \
  .option("rowsPerSecond", "100000") \
  .option("numPartitions", "16") \
  .load()

# Apply some transformations to the data then use
# Structured Streaming API to continuously write the data to a table in Azure Synapse.

df.writeStream \
  .format("com.databricks.spark.sqldw") \
  .option("url", "jdbc:sqlserver://<the-rest-of-the-connection-string>") \
  .option("tempDir", "wasbs://<your-container-name>@<your-storage-account-name>.blob.core.windows.net/<your-directory-name>") \
  .option("forwardSparkAzureStorageCredentials", "true") \
  .option("dbTable", "<your-table-name>") \
  .option("checkpointLocation", "/tmp_checkpoint_location") \
  .start()

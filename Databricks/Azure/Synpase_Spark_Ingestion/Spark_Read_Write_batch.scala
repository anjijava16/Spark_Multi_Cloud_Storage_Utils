# Defining the service principal credentials for the Azure storage account
spark.conf.set("fs.azure.account.auth.type", "OAuth")
spark.conf.set("fs.azure.account.oauth.provider.type",  "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider")
spark.conf.set("fs.azure.account.oauth2.client.id", "<application-id>")
spark.conf.set("fs.azure.account.oauth2.client.secret", "<service-credential>")
spark.conf.set("fs.azure.account.oauth2.client.endpoint", "https://login.microsoftonline.com/<directory-id>/oauth2/token")

# Defining a separate set of service principal credentials for Azure Synapse Analytics (If not defined, the connector will use the Azure storage account credentials)
spark.conf.set("spark.databricks.sqldw.jdbc.service.principal.client.id", "<application-id>")
spark.conf.set("spark.databricks.sqldw.jdbc.service.principal.client.secret", "<service-credential>")



# Otherwise, set up the Blob storage account access key in the notebook session conf.
spark.conf.set(
  "fs.azure.account.key.<your-storage-account-name>.blob.core.windows.net",
  "<your-storage-account-access-key>")

# Get some data from an Azure Synapse table.
df = spark.read \
  .format("com.databricks.spark.sqldw") \
  .option("url", "jdbc:sqlserver://<the-rest-of-the-connection-string>") \
  .option("tempDir", "wasbs://<your-container-name>@<your-storage-account-name>.blob.core.windows.net/<your-directory-name>") \
  .option("forwardSparkAzureStorageCredentials", "true") \
  .option("dbTable", "<your-table-name>") \
  .load()

# Load data from an Azure Synapse query.
df = spark.read \
  .format("com.databricks.spark.sqldw") \
  .option("url", "jdbc:sqlserver://<the-rest-of-the-connection-string>") \
  .option("tempDir", "wasbs://<your-container-name>@<your-storage-account-name>.blob.core.windows.net/<your-directory-name>") \
  .option("forwardSparkAzureStorageCredentials", "true") \
  .option("query", "select x, count(*) as cnt from table group by x") \
  .load()

# Apply some transformations to the data, then use the
# Data Source API to write the data back to another table in Azure Synapse.

df.write \
  .format("com.databricks.spark.sqldw") \
  .option("url", "jdbc:sqlserver://<the-rest-of-the-connection-string>") \
  .option("forwardSparkAzureStorageCredentials", "true") \
  .option("dbTable", "<your-table-name>") \
  .option("tempDir", "wasbs://<your-container-name>@<your-storage-account-name>.blob.core.windows.net/<your-directory-name>") \
  .save()

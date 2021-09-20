# Real time Streams Ingestion 
* In this Package read and write Spark Structured Streaming utils using Azure Cloud 

# PreRequests
1. Azure Account
2. Azure Databricks setup
3. Azure Cosmos DB
4. Azure Storage account (Gen2 Data Lake)
5. Azure SQL Databases
6. MYSQL Database
7. Azure Key Valut
8. Azure Active Directory (App Registration)
9. Azure Event Hubs 
10. Python Code (Mockup data generations)


# Real time Streams Ingestion into Azure Data Lake Gen2 ,Azure SQL Database, Cosmos DB(Core SQL API,cassandra API ) and MYSQL DB Sink Connector
1. Read Event Hub Data
2. Create databricks Cluster add Maven as (com.microsoft.azure:azure-eventhubs-spark_2.12:2.3.18)
3. Read Event Hub Data write into Azure Gen2 Data Lake
4. Read Event Hub Data write into Azure SQL Database 
5. Read Event Hub Data write into Azure Gen2 Data Lake (parquet,ORC,Delta Files)
6. Read Event Hub Data write into Azure Cosmos DB's
7. Read Event Hub Data write into MYSQL Database


# Reference Links
1. https://docs.microsoft.com/en-us/azure/databricks/scenarios/databricks-stream-from-eventhubs?WT.mc_id=eventhubs-blog-alehall
2. Java  Producer Example: https://docs.microsoft.com/en-us/azure/event-hubs/event-hubs-java-get-started-send
3. Python Producer Example: https://docs.microsoft.com/en-us/azure/event-hubs/event-hubs-python-get-started-send
4. Cosmos DB : https://sqlwithmanoj.com/2021/04/07/connect-to-cosmos-db-from-databricks-and-read-data-by-apache-spark-to-azure-cosmos-db-connector/
5. Spring Microservices: https://github.com/discospiff/SpringBootMicroservicesWithIntelliJIDEA

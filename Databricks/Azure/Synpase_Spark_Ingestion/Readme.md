# Azure Synapse Analytics (formerly SQL Data Warehouse)

*. Azure Synapse Analytics (formerly SQL Data Warehouse) is a cloud-based enterprise data warehouse that leverages massively parallel processing (MPP) to quickly run complex queries across petabytes of data. Use Azure as a key component of a big data solution. Import big data into Azure with simple PolyBase T-SQL queries, or COPY statement and then use the power of MPP to run high-performance analytics. As you integrate and analyze, the data warehouse will become the single version of truth your business can count on for insights.

*. You can access Azure Synapse from Databricks using the Azure Synapse connector, a data source implementation for Apache Spark that uses Azure Blob storage, and PolyBase or the COPY statement in Azure Synapse to transfer large volumes of data efficiently between a Databricks cluster and an Azure Synapse instance.

*. Both the Databricks cluster and the Azure Synapse instance access a common Blob storage container to exchange data between these two systems. In Databricks, Apache Spark jobs are triggered by the Azure Synapse connector to read data from and write data to the Blob storage container. On the Azure Synapse side, data loading and unloading operations performed by PolyBase are triggered by the Azure Synapse connector through JDBC. In Databricks Runtime 7.0 and above, COPY is used by default to load data into Azure Synapse by the Azure Synapse connector through JDBC.

* Note: COPY is available only on Azure Synapse Gen2 instances, which provide better performance. If your database still uses Gen1 instances, we recommend that you migrate the database to Gen2.

* The Azure Synapse connector is more suited to ETL than to interactive queries, because each query execution can extract large amounts of data to Blob storage. If you plan to perform several queries against the same Azure Synapse table, we recommend that you save the extracted data in a format such as Parquet.

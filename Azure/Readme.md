# Pre-Request :
1. Hadoop 3.2
2. Azure Storage Account with Gen2 
3. Input Files
4. Spark 2.4
5. Hadoop Azure Data Lake Jars
6. pom.xml


# Azure Storage Account Details:

1. Storage Account Name: gen2iwinnerdb
2. Container Name: data
3. Path: inputdata/Input.csv

# Spark Setup for ADFS (Azure Data Lake File System) 
1. spark.conf.set("fs.defaultFS", "abfs://data@gen2iwinnerdb.dfs.core.windows.net/")
2. spark.conf.set("fs.azure.account.key.gen2iwinnerdb.dfs.core.windows.net", "yHJgKMzLNC7E+Q3YK3z8TlDLNME6rNRyUCHGoMKPwEmvaojagKogap3pIzOvj5s95YslUAevoEzfBOTHXMMiWQ==")


# Important Jars Files:

### . hadoop-client.3.2.0 Jars


                    <dependency>
                            <groupId>org.apache.hadoop</groupId>
                            <artifactId>hadoop-client</artifactId>
                            <version>3.2.0</version>
                        </dependency>
                        <dependency>
        
        ``

### . wildfly-openssl.1.0.7.Final


                            <dependency>
                                <groupId>org.wildfly.openssl</groupId>
                                <artifactId>wildfly-openssl</artifactId>
                                <version>1.0.7.Final</version>
                            </dependency>



### . hadoop-azure-datalake and hadoop-azure jar files 

                     <dependency>
                                <groupId>org.apache.hadoop</groupId>
                                <artifactId>hadoop-azure-datalake</artifactId>
                                <version>3.2.0</version>
                            </dependency>



                            <dependency>
                                <groupId>org.apache.hadoop</groupId>
                                <artifactId>hadoop-azure</artifactId>
                                <version>3.2.0</version>
                            </dependency>

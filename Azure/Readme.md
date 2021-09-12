# Pre-Request :
1. Hadoop 3.2
2. Azure Storage Account with Gen2 
3. Input Files
4. Spark 2.4
5. Hadoop Azure Data Lake Jars
6. pom.xml

# Important Jars Files:
1. hadoop-client.3.2.0 Jars
``
    <dependency>
            <groupId>org.apache.hadoop</groupId>
            <artifactId>hadoop-client</artifactId>
            <version>3.2.0</version>
        </dependency>
        <dependency>
``

2. wildfly-openssl.1.0.7.Final
 ``
        <dependency>
            <groupId>org.wildfly.openssl</groupId>
            <artifactId>wildfly-openssl</artifactId>
            <version>1.0.7.Final</version>
        </dependency>

``
3. hadoop-azure-datalake and hadoop-azure jar files 
``
 <dependency>
            <groupId>org.apache.hadoop</groupId>
            <artifactId>hadoop-azure-datalake</artifactId>
            <version>3.2.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-azure -->

        <dependency>
            <groupId>org.apache.hadoop</groupId>
            <artifactId>hadoop-azure</artifactId>
            <version>3.2.0</version>
        </dependency>
``

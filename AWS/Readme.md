# Pre-Request :
1. Hadoop 2.7 or above
2. S3 Storage Bucket 
3. Input Files
4. Spark 2.4
5. Input Files
6. pom.xml


# AWS S3 Storage Bucket 
1. Bucket Name (AWS  Example: s3://$BUCKET_NAME
2. S3_ACCESS_KEY: fs.s3a.access.key
3. S3_SECRET_KEY: fs.s3a.secret.key
4. S3AFileSystem: fs.s3a.impl (org.apache.hadoop.fs.s3a.S3AFileSystem)

# Import Jar files:
                1.  <aws.java.sdk.version>1.11.145</aws.java.sdk.version>

                      <dependencyManagement>
                              <dependencies>
                                  <dependency>
                                      <groupId>com.amazonaws</groupId>
                                      <artifactId>aws-java-sdk-bom</artifactId>
                                      <version>1.11.145</version>
                                      <type>pom</type>
                                      <scope>import</scope>
                                  </dependency>
                              </dependencies>
                          </dependencyManagement>

                          <dependencies>

                              <dependency>
                                  <groupId>com.amazonaws</groupId>
                                  <artifactId>aws-java-sdk-s3</artifactId>
                              </dependency>
                              <dependency>
                                  <groupId>com.amazonaws</groupId>
                                  <artifactId>aws-java-sdk-sts</artifactId>
                              </dependency>
                              <dependency>
                                  <groupId>com.amazonaws</groupId>
                                  <artifactId>aws-java-sdk-s3</artifactId>
                              </dependency>

                        <dependency>
                                  <groupId>org.apache.hadoop</groupId>
                                  <artifactId>hadoop-client</artifactId>
                                  <version>2.8.1</version>
                              </dependency>
                              <dependency>
                                  <groupId>org.apache.hadoop</groupId>
                                  <artifactId>hadoop-aws</artifactId>
                                  <version>2.8.0</version>
                              </dependency>



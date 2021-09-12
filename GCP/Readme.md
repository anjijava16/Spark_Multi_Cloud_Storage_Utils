# Pre-Request :
1. Hadoop 2.7 or above
2. GCS Bucket 
3. Input Files
4. Spark 2.4
5. GCP Data files 
6. pom.xml


# GCP Storage Bucket 
1. Bucket Name (GCS  Example: gs://$BUCKET_NAME
2. ESA (Exeternal Service Account Here .json file)

# Important Jar file's

                      <dependency>
                                  <groupId>com.google.cloud</groupId>
                                  <artifactId>google-cloud-storage</artifactId>
                                  <version>1.92.0</version>
                              </dependency>
                              <dependency>
                                  <groupId>com.google.cloud.bigdataoss</groupId>
                                  <artifactId>gcs-connector</artifactId>
                                  <version>hadoop3-2.0.0</version>
                              </dependency>
                              <dependency>
                                  <groupId>com.google.cloud.bigdataoss</groupId>
                                  <artifactId>bigquery-connector</artifactId>
                                  <version>hadoop3-1.0.0-RC2</version>
                              </dependency>
                              <dependency>
                                  <groupId>com.google.guava</groupId>
                                  <artifactId>guava</artifactId>
                                  <version>27.1-jre</version>
                              </dependency>
                              <dependency>
                                  <groupId>com.google.api-client</groupId>
                                  <artifactId>google-api-client</artifactId>
                                  <version>1.30.4</version>
                              </dependency>

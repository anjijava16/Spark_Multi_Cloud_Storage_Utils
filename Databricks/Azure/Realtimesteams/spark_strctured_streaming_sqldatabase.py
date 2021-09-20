# Custom function to output streaming dataframe to Azure SQL DB
def output_sqldb(batch_df, batch_id):
#   Set Azure DW Properties and Conn String
  sql_pwd = dbutils.secrets.get(scope = "myscope", key = "sqlpwd")
  sql_user = dbutils.secrets.get(scope = "myscope", key = "sqluser")
  dbtable = "staging"
  jdbc_url = "jdbc:sqlserver://sqlserver09.database.windows.net:1433;database=demodb;user="+ sql_user +";password="+ sql_pwd +";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
  # write the pyspark dataframe to Azure DW
  batch_df.write.format("jdbc").mode("append").option("url", jdbc_url).option("dbtable", dbtable).save()


# Output Dataframe to Azure SQL DB
df_sqldb = df_transform.writeStream\
  .trigger(once=True)\
  .foreachBatch(output_sqldb)\
  .outputMode("append")\
  .option("checkpointLocation", "abfss://checkpointcontainer@dstore.dfs.core.windows.net/checkpointdb")\
  .start()

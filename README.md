# database-connection

Simple SQL client for connecting to AWS-Redshift. 

It prompts the user for the following inputs:
1. creds
2. connection string
3. query (if the user omits a LIMIT, this is automatically added to prevent RAM overflow)

- upload data csv/xls and send to kafka 
========== run application  =============
- open terminal and go to root directori
- run docker-compose up -d
- run mvn clean install
- run java -jar target/upload-0.0.1-SNAPSHOT.jar --server.port=7071
- connect db with sql browser like dbeaver 
    - database =  login
    - username =  admin
    - password =  admin
    - port = 3311
- execute query seed table roles in directori db_seed (file seed_roles.sql)    


====== flow application ===================================================
- sign up   =[POST] http://localhost:7071/api/auth/signup
- sign in   =[POST] http://localhost:7071/api/auth/signin
- upload    =[POST] http://localhost:7071/api/access/upload
- sign out  =[POST] http://localhost:7071/api/auth/signout
- public    =[GET]  http://localhost:7071/api/access/public

- streaming upload file in another application
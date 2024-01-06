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

- postman : https://api.postman.com/collections/4131954-beb093c1-3266-434b-8c1c-31f9cbe7b687?access_key=PMAT-01HKF6DKNNPZEHQ9JQM0PF42T7

====== flow application ===================================================
- sign up   =[POST] http://localhost:7071/api/auth/signup
- sign in   =[POST] http://localhost:7071/api/auth/signin
- upload    =[POST] http://localhost:7071/api/access/upload
- sign out  =[POST] http://localhost:7071/api/auth/signout
- public    =[GET]  http://localhost:7071/api/access/public

- streaming upload file in another application
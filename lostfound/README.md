## Running the application locally

There are several ways to run a Spring Boot application on your local machine.
One way is to execute the `main` method in the 'com.aky.lostfound.LostfoundApplication' class from your IDE.
Application will be running o default port http://localhost:8080

## H2 in memory db used


db is available on url http://localhost:8080/h2-db
user - sa
pwd is left blank

db name is application and APP_USER table is auto populated on application start.


## Rest urls

Tested with postman

1) http://localhost:8080/lostItem/uploadRecord  (Post Method , body as form type with key as file an choose type as file and attach pdf. Sample pdf attached in project resources folder to test)
2) http://localhost:8080/lostItem/viewAll (Get Method, shows all the pdf loaded lost items)
3) http://localhost:8080/claimItem/claim/{userId} (Post Method to claim items with existing userId for eg. 1001 or 1002, user must exist in AppUser table)
4) http://localhost:8080/claimItem/viewAllClaim (Get Method to view all the claims)

Quarkus REST Example
==================

This example shows a simple REST-API with intern H2 Database access running with Quarkus.

Technologies
------------

- Quarkus
- Hibernate
- H2 Database

Build
----------

Run `./mvnw clean package` or `mvnw.cmd clean package`

Run
----------

`java -jar target/quarkus-rest-example-1.0-runner.jar`

REST call examples
----------

*_Get all contacts_*
```
curl -X GET http://localhost:8080/api/contacts
```

*_Get single contact_*
```
curl -X GET http://localhost:8080/api/contacts/-1
```

*_Add contact_*
```
curl -X POST -H "Content-Type: application/json" -d '{"companyName":"Knoldus","firstName":"Mohd","lastName":"Uzair"}' http://localhost:8080/api/contacts
```

*_Update contact_*
```
curl -X PUT -H "Content-Type: application/json" -d '{"companyName":"Knoldus","firstName":"Mohd.","lastName":"Uzair"}' http://localhost:8080/api/contacts/1
```

*_Delete contact_*
```
curl -X DELETE http://localhost:8080/api/contacts/-1
```



# Tutorial

This project follows the tutorial from [FreeCodeCamp.org on Youtube](https://www.youtube.com/watch?v=31KTdfRH6nY&t=288s), where we'll be able to note our running sessions.

Other projects ideas can be found on the official [Spring.io](https://spring.io/projects/spring-boot) website.

## Start server

Can run the project with VsCode (icon "play") or in terminal with Maven by typing
`./mvnw spring-boot:run`

Can change the server port in `/ressources/application.properties`

Can also use `http :8080 /api/runs` or any other URL we have in our API to check the results.

### Layers vs Feature

We can order our workspace the way we want.  
We can use the layer system (MVC), but files need to communicate throughout folders.  
We can use a feature system so files that need to communicate are close to each other.

### Defining a class

Instead of defining a class with all its getters and setter, we can simply use a `record`, which does all the work for us.

### Database

After getting the dependencies `H2 Database` (Database) & `JDBC API` (connection to database), we can access the database with the url `http://localhost:8080/h2-console`, and login with default fields.  
If the database doesn't exists, might be wrong. Replace `JDBC URL` with the one written on the terminal at `com.zaxxer.hikari.pool.HikariPool`.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/#build-image)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web)
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#using.devtools)

### Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

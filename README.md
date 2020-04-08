# Event_Assistant_-_Suitable_for_Everyone
Event Assistant Application

Before building and running the application from pom.xml level with mvn spring-boot:run 
make sure to create an application.properties file with the following content.

spring.datasource.url= jdbc:postgresql://localhost:***/ease
spring.datasource.username=***
spring.datasource.password=***
spring.datasource.platform=***
spring.datasource.initialization-mode=always
spring.jpa.hibernate.ddl-auto=none
spring.jpa.generate-ddl=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

spring.security.user.name=***
spring.security.user.password=***

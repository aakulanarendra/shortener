# Shortener App

Application is used to generate the shortend url for long urls

### Approach
Application is built on [spring boot](https://spring.io/projects/spring-boot) which is used to create stand alone application. 
Used [Thymeleaf](https://www.thymeleaf.org/) which is a Java template engine for processing and creating HTML, XML, JavaScript, CSS, and text.

Please refer below app tree:

```bash
├───main
│   ├───java
│   │   └───com
│   │       └───narendra
│   │           └───shortener
│   │               ├───contorller       #Used for web apis and html view controlling
│   │               ├───entity           #Databse table
│   │               ├───model            #Request Models/ Pojos    
│   │               ├───repository       #Spring repository to connect databse
│   │               └───service          #Service layer 
│   └───resources
│       ├───static                      
│       │   ├───css                      #Styles
│       │   └───js                       #Java Script functions used
│       └───templates                    #Html Views   
└───test
    └───java
```

1. When User navigates to [localhost:8088](http://www.localhost:8088), we will render index.html page using spring mvc
2. When user enters input value we will validate and submit to web service to generate shortend url
3. Web service will check whether url is shortened already or not by checking in database ( Used [H2 database](https://www.h2database.com/html/main.html) which is in-memory database), if shortened will serve the already shortened url or it will generate new shortend url in sequential
4. Shortend url can be generated in many ways, currently used in sequential matter.

### Technologies Used
* Java, SpringBoot and Spring MVC
* Thymeleaf
* HTML
   1. Rendering views
* Javascript & JQuery
   1. Used for validations and invoking web services.
   2. Can be used for generating Shortends with multiple approaches.
* Build Tool: Gradle
* Server: Tomcat - Embedded in SpringBoot

### How To Run App in Local
* Navigate to root directory of application
* Run `gradlew clean bootRun`
* Navigate to [localhost:8088](http://www.localhost:8088)
* Database can be browsed at [http://localhost:8088/h2-console](http://localhost:8088/h2-console) (jdbcurl - **jdbc:h2:mem:testdb**, username: **sa**, password: leave blank)

### TestCases
* Navigate to root directory of application
* Run `gradlew clean test`
 Used Junit tests for all use cases (controller,service,repository layer)


### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/gradle-plugin/reference/html/)
* [Thymeleaf](https://www.thymeleaf.org/) is a Java template engine for processing and creating HTML, XML, JavaScript, CSS, and text.

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


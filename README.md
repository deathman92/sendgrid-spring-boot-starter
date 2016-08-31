[![Build Status](https://travis-ci.org/deathman92/sendgrid-spring-boot-starter.svg?branch=master)](https://travis-ci.org/deathman92/sendgrid-spring-boot-starter)
[ ![Download](https://api.bintray.com/packages/deathman92/maven-release/sendgrid-spring-boot-starter/images/download.svg) ](https://bintray.com/deathman92/maven-release/sendgrid-spring-boot-starter/_latestVersion)
  
# Spring Boot SendGrid starter
A Spring Boot starter that will help you configure [SendGrid](https://github.com/sendgrid/sendgrid-java) within the application context.

## Features
In order to add SendGrid to your project simply add this dependency to your classpath:
### Gradle
```groovy
repositories {
 jcenter()
}

dependencies {
 compile("com.github.deathman92:sendgrid-spring-boot-starter:1.0.0")
}
```
### Maven
```xml
<dependency>
  <groupId>com.github.deathman92</groupId>
  <artifactId>sendgrid-spring-boot-starter</artifactId>
  <version>1.0.0</version>
</dependency>
```

# Spring Boot properties configuration
```properties
sendgrid.api-key= // your apiKey (https://app.sendgrid.com/settings/api_keys) 
sendgrid.test= // is used in test mode
sendgrid.host= // host of endpoint [default: api.sendgrid.com]
sendgrid.version= // version of endpoint [default: v3]
```

# Licence
[MIT](/LICENSE.md)
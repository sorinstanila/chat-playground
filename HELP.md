# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.5/maven-plugin/reference/html/#build-image)
* [WebSocket](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-websockets)

### Guides
The following guides illustrate how to use some features concretely:

* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)

### Start of the application
* Please instart locally `docker`, `docker-compose` and `make`
* Run `make up` to start the containers for ActiveMQ, RabbitMQ so you can play with different broker engines
* Start the application from your IDE, by default will try to connect to `ActiveMQ`
* Open the browser on the http://localhost:8080/ and type a user name
* Open a second tab/browser on the http://localhost:8080/ and type a user name to join the same channel with a different user.
* Enjoy chatting ! :smirk:



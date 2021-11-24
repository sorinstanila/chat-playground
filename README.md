# chat-playground
A simple chat using a broker relay, and docker. Used for cross development with StreamNative for a POC


### Start of the application
* Please instart locally `docker`, `docker-compose` and `make`
* Run `make up` to start the containers for ActiveMQ, RabbitMQ so you can play with different broker engines
* Start the application from your IDE, by default will try to connect to `ActiveMQ`
* Open the browser on the http://localhost:8080/ and type a user name
* Open a second tab/browser on the http://localhost:8080/ and type a user name to join the same channel with a different user.
* Enjoy chatting ! :smirk:

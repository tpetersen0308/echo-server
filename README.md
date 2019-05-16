# echo-server
A simple Java server that echos client messages.

## Requirements

[Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

## Installation

Clone or download the repository.

## Basic Usage

Run tests: 
`mvn test`

Create the project:
`mvn package`

Start the Server:
`./bin/echo_server` (Defaults to running on port 5000)

or

`java -cp target/echo-server-1.0-SNAPSHOT.jar server.Server <PORT>`
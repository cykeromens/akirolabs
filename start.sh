#!/bin/bash
 kill -9 $(lsof -ti:8080,3000,8081,8082)

 cd generator && mvn clean install && java -jar target/generator-0.0.1-SNAPSHOT.jar & cd validator && mvn clean install && java -jar target/validator-0.0.1-SNAPSHOT.jar & npm install -g serve
 /n & sleep 10 && cd frontend && npm install && npm run openapi:gen && npm run build && serve -s ../build/webapp -p 8080

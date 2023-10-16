# Akirolabs technical test

A web-based application that allows you to generate tokens and validate them.

Token has a format of XXXX-XXXX-XXXX-XXXX, and consists of the 0-9 digits.

User is able to choose which digits are available for token generation in the UI, e.g. available digits are: 2,4,7,9,0 - it means that token can consist only of them, e.g. 2249-4472-0279-9420

User is able to initiate token creation via UI, in this case available digits are being passed to the GeneratorService and created token is displayed on UI. Generator creates a token randomly based on available digits provided.

## Introduction
This application has two microservice springboot application that uses a common parent-pom. This application starts on different ports 8081 and 8082.
The Frontend is running on react and starts on 8080.

## How to run

###  `sh start.sh`

Runs the app in the development mode.\
Open [http://localhost:8080](http://localhost:3000) to view it in your browser.

## Something to improve
* Could have resolved the CVV checks
* Use a common model instead of recreating them
* Have more unit and integration tests especially for the UI

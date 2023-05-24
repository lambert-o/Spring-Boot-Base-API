# Spring-Boot-Base-API

A Maven project to use as a base upon which to build an API in Java using SpringBoot

## Requirements
Java 17 or later

Maven 3.x.x or later

## Installation

Clone the repository: git clone https://github.com/lambert-o/Spring-Boot-Base-API.git

Navigate to the project directory: cd Spring-Boot-Base-API

Build the project: make clean compile

## Usage

Pull and run an image of postgres: make local-services-up

Start the API server: make run

Use Postman (or any other preferred method of making API requests) to **GET** http://localhost:8080/v3/api-docs for API documentation

A Postman collection can be found in [/assets](assets)

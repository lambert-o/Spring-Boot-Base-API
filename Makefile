# Define the default target
.DEFAULT_GOAL := run

# Define required variables
CONTAINER_NAME := mypostgres
DB_NAME := mydatabase
DB_USER := postgres
DB_PASSWORD := postgres

# Define the commands for each target
compile:
	mvn compile

test:
	mvn test

run:
	mvn exec:java -Dexec.mainClass="com.base.Main"

clean:
	mvn clean

local-services-up:
	docker pull postgres:latest
	docker run -d --rm \
            --name $(CONTAINER_NAME) \
            -p 5432:5432 \
            -e POSTGRES_DB=$(DB_NAME) \
            -e POSTGRES_USER=$(DB_USER) \
            -e POSTGRES_PASSWORD=$(DB_PASSWORD) \
            postgres:latest

local-services-down:
	docker stop $(CONTAINER_NAME)

.PHONY: compile test run clean
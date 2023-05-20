# Define the default target
.DEFAULT_GOAL := run

# Define the commands for each target
compile:
	mvn compile

test:
	mvn test

run:
	mvn exec:java -Dexec.mainClass="com.base.Main"

clean:
	mvn clean

.PHONY: compile test run clean
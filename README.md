# Build & Run

To build this project, run the following command at project root folder:
>mvn clean install

To run this program, in the build output folder:
>java -jar CodeTest.jar

# Assumption

1. The format should be **CurrencyCode Amount ExchangeRate**, where **CurrencyCode** is uppercase English character with 
   maximum length 3 and **Amount** is an integer. For **ExchangeRate**, it should be a non-negative double value 
   representing `1 USD to currency`. Example data is present at src/main/resources folder.
2. This program should have access to open the file if file path is given, if the file does not exist or there is 
   malformed data in the file, this program will exit.
   
# Project Description

Correct behavior of synchronization is guaranteed on update of object state, but not the query of the state.

Unit test does not test synchronization.
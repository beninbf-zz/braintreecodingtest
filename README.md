# Braintree Credit Card Processing Challenge

This is a Java SpringBoot application meant to be executed from the command line. As java is the language
I am most comfortable with that is the reason for the language choice.

To run the test, execute the following command

```bash
mvn test;
```
To build the project, execute

```bash
mvn package;
```
After executing "mvn package", I recommend then executing the jar, which can be found in the "target" directory

```bash
java -jar target/braintree-coding-test-1.0-SNAPSHOT.jar <fully_qualified_path_to_text_file>
```

The command above will start the SpringBoot application, ingest the supplied text file and output a summary to STDOUT.

## DESIGN

This project is follows the Gang of Four Structural Design Pattern known as the Facade pattern. The Facade pattern
is meant to provide a simplified interface to clients, where the complexities of implementation can be
hidden.

As the CreditFacade is an interface which is hiding the complexities of the implementation from the CreditCardProcessor
this pattern could also be used when designing a REST API. A resource could simply be laid over the given
CreditFacade.
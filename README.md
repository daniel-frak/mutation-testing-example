# Mutation testing example

![Code Soapbox logo](readme-images/logo.png)

This project is an example of mutation testing using Maven, Junit5 and Pitest.

Note that parts of the code, especially the tests, are intentionally badly written, to better highlight the benefits
of mutation testing.

![Mutation coverage report](readme-images/mutation_coverage_report.png)

To learn more about mutation testing and learn how to perform it 
using Junit 5, Maven and Pitest, read the post:

[Code Soapbox - Mutation testing by example – Junit 5, Maven and Pitest](https://codesoapbox.dev/mutation-testing-by-example---junit-5-maven-and-pitest/)

## Getting Started

1. Clone the repository

```bash
$ git clone https://github.com/daniel-frak/mutation-testing-example
```

2. Generate a mutation coverage report

```bash
mvn clean test-compile org.pitest:pitest-maven:mutationCoverage
```

3. Navigate to `./target/pit-reports/{reportDate}` and open `index.html` to view the report.

## Built With

* Java 17
* [Spring Boot 2.7.0](https://start.spring.io/)
* [Maven](https://maven.apache.org/)
* [Junit 5](https://junit.org/junit5/)
* [Pitest](https://pitest.org/)
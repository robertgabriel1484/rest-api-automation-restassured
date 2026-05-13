# REST API Automation with REST-Assured

A QA/SDET portfolio project demonstrating API test automation using Java, REST-Assured, TestNG, JSON validation, reusable request/response specifications, positive and negative test coverage, and GitHub Actions CI.

## Project Purpose

This project demonstrates:

- REST API testing
- Java-based API automation
- REST-Assured
- TestNG assertions
- JSON response validation
- JSON schema validation
- Positive and negative API scenarios
- Reusable request and response specifications
- CI-friendly execution

## Demo API

The tests use the public JSONPlaceholder API:

https://jsonplaceholder.typicode.com

## Tech Stack

- Java 17
- Maven
- REST-Assured
- TestNG
- JSON Schema Validator
- GitHub Actions

## Test Coverage

Current tests include:

- Get all posts
- Get a post by valid ID
- Validate post JSON schema
- Create a new post payload
- Verify missing resource returns 404
- Validate users endpoint data
- Validate nested JSON fields
- Validate response time threshold

## Project Structure

```text
rest-api-automation-restassured/
  docs/
    api_test_strategy.md
    sample_api_bug_report.md
  src/
    test/
      java/
        com/
          robertgabriel/
            api/
              core/
                ApiConfig.java
                SpecFactory.java
              models/
                PostPayload.java
              tests/
                PostsApiTests.java
                UsersApiTests.java
      resources/
        schemas/
          post-schema.json
        testdata/
          post-payload.json
  pom.xml
  README.md
  portfolio_project_log.md
```

## How to Run Locally

Prerequisites:

- Java 17+
- Maven

Run all API tests:

```bash
mvn clean test
```

Run one test class:

```bash
mvn clean test -Dtest=PostsApiTests
```

## CI/CD

This project is designed to run through GitHub Actions using a workflow file at:

```text
.github/workflows/api-tests.yml
```

## QA Documentation

Supporting documentation is included in the `docs` folder:

```text
docs/api_test_strategy.md
docs/sample_api_bug_report.md
```

## Portfolio Notes

My production QA background includes API testing, REST API validation, SQL-backed data verification, CI/CD regression execution, defect lifecycle management, and enterprise workflow validation.

This repo demonstrates API automation fundamentals in a clean, public, recruiter-friendly project.

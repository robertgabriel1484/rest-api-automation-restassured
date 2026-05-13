# API Test Strategy

## Objective

Demonstrate REST API automation skills using Java, REST-Assured, TestNG, JSON validation, positive and negative coverage, and CI execution.

## API Under Test

https://jsonplaceholder.typicode.com

## In Scope

- GET collection validation
- GET resource-by-ID validation
- POST payload validation
- Negative 404 validation
- JSON schema validation
- Nested JSON field validation
- Response time checks
- GitHub Actions execution

## Out of Scope

- Real authentication
- Production data validation
- Database validation
- Load/performance testing

## Quality Signals

- Tests pass locally and in CI
- Negative tests validate expected error handling
- Response structure is validated through JSON schema
- Tests use reusable request and response specifications

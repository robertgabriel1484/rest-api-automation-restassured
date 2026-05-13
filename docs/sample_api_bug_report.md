# Sample API Bug Report

## Title

GET /posts/{postId} returns unexpected response for missing post

## Environment

- API: JSONPlaceholder demo API
- Endpoint: `/posts/{postId}`
- Test type: Negative API regression
- Automation: Java, REST-Assured, TestNG

## Steps to Reproduce

1. Send a GET request to `/posts/999999`.
2. Review the HTTP status code.
3. Review the response body.

## Expected Result

```text
HTTP 404 Not Found
```

## Actual Result

```text
Unexpected response returned.
```

## Severity

Medium

## Priority

High

## Impact

Consumers may treat missing records as valid resources, which could cause incorrect downstream behavior.

## Evidence

- Automated negative test: `missingPostReturnsNotFound`
- Test report under `target/surefire-reports/`

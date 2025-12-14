# ✅ SonarQube Interview Questions & Answers

---

## ✅ 1. What is a SonarQube Dashboard?
A SonarQube dashboard is a centralized view that shows the overall code quality of a project.  
It displays metrics such as bugs, vulnerabilities, code smells, coverage, duplications, and maintainability.  
Teams use it to continuously monitor and improve code quality.

---

## ✅ 2. Why do we use SonarQube?
- Detects code quality issues early
- Improves maintainability
- Reduces bugs and vulnerabilities
- Enforces coding standards
- Increases test coverage
- Automates static code analysis in CI/CD pipelines

---


## ✅ 3. What metrics are shown on a Sonar Dashboard?

| Metric | Description                                                                                               |
|--------|-----------------------------------------------------------------------------------------------------------|
| **Bugs** | Defects causing incorrect behavior  ,null issues                                                          |
| **Vulnerabilities** | Security threats exploitable by attackers  sql injection                                                  |
| **Code Smells** | Maintainability issues  (design issues)                                                                   |
| **Coverage** | % of code covered by tests                                                                                |
| **Duplications** | Repeated code blocks                                                                                      |
| **Cyclomatic Complexity** | Complexity of logic based on conditions lot of if else will lead to different path for coding and testing |
| **Technical Debt** | Time required to fix issues                                                                               |

---

## ✅ 4. What is a Quality Gate?
A Quality Gate is a set of predefined rules that code must satisfy before being accepted.

**Examples:**
- No new critical bugs or vulnerabilities
- Test coverage above 80%
- Code duplication < 3%
- Technical debt ratio < 5%

If any condition fails → Quality Gate fails → build/merge may be blocked.

---

## ✅ 5. What types of issues does Sonar identify?

| Issue Type | Meaning |
|------------|---------|
| ✅ **Bugs** | Problems causing incorrect functionality |
| ✅ **Vulnerabilities** | Security issues in code |
| ✅ **Code Smells** | Bad coding practices (hard to maintain) |
| ✅ **Security Hotspots** | Code requiring security review |
| ✅ **Duplicated Code** | Same logic repeated |


| Category       | Meaning                                      | Risk Type                   | Example Problem                     | Fix Example                               |
|----------------|----------------------------------------------|------------------------------|-------------------------------------|-------------------------------------------|
| **Bug**         | Functional error that breaks runtime behavior | Logical/runtime failure       | Null dereference, incorrect condition | Null check, logic correction              |
| **Code Smell**  | Poor design or maintainability issue          | Long-term maintainability risk | Large method, duplicate code        | Refactor, simplify, modularize            |
| **Vulnerability** | Security weakness exploitable by attackers    | Security breach risk           | SQL injection, hardcoded password   | Use prepared statements, encrypt secrets  |

---

## ✅ 6. What are common code smells found by SonarQube?
- Methods or classes too long
- Magic numbers
- Hard-coded credentials
- Dead/unused code
- Empty catch blocks
- Too many parameters in methods
- Public fields instead of private
- No default case in switch
- Duplicated business logic

---

## ✅ 7. What causes low code coverage and how do you fix it?

**Causes:**
- Missing unit tests
- Legacy code without tests
- Complex methods difficult to mock
- Unreachable exception blocks

**Fixes:**
- Add JUnit + Mockito tests
- Refactor large methods into smaller testable pieces
- Mock external calls
- Write tests for edge cases and exceptions

---

## ✅ 8. What is Technical Debt?
Technical debt is the estimated amount of time required to fix all issues in the codebase.  
Sonar calculates it based on severity and number of issues.  
High technical debt reduces maintainability and increases future cost.

---

## ✅ 9. What tools integrate with SonarQube?

**CI/CD:** Jenkins, GitLab CI, GitHub Actions, Azure DevOps, Bamboo  
**Build tools:** Maven, Gradle  
**Version control:** GitHub, GitLab, Bitbucket  
**IDEs:** IntelliJ, Eclipse, VS Code  
**Containers:** Docker, Kubernetes

---

## ✅ 10. What happens when the Quality Gate fails?
- CI/CD pipeline can fail
- Merge or Pull Request may be blocked
- Developer must fix issues before code reaches production

Ensures clean, secure code delivery.

---

## ✅ 11. Common issues identified by Sonar and how to fix them

| Issue | Cause | Fix |
|-------|-------|-----|
| **Duplicate Code** | Copy-pasted logic | Extract method or reuse function |
| **Long Methods / Classes** | Too many responsibilities | Refactor into smaller units |
| **Magic Numbers** | Hardcoded numeric values | Use constants or enums |
| **Unused Code** | Dead code | Remove |
| **Hardcoded passwords/URLs** | Security flaw | Move to config or secrets |
| **Empty Catch blocks** | Swallowed exceptions | Log or rethrow |
| **NullPointer risks** | Missing null checks | Use Optional or validations |
| **Not closing resources** | Memory leaks | try-with-resources |
| **SQL Injection risk** | String concatenated queries | Use PreparedStatement |
| **Low test coverage** | No tests | Write JUnit + Mockito tests |

---

## ✅ 12. What is Cyclomatic Complexity?
It measures how complex a method or class is based on branching (if/else, loops, switch).  
Higher complexity → harder to maintain and test.  
Solution: simplify logic or split into smaller methods.

---

## ✅ 13. How does SonarQube enforce code quality in CI/CD?
- Code is scanned on each commit or pull request
- Sonar publishes report
- Quality Gate checks pass/fail
- If rules fail, the pipeline can block deployment or merging

---

## ✅ 14. What is a Security Hotspot vs Vulnerability?

| Type | Meaning |
|------|---------|
| **Vulnerability** | Confirmed security issue that must be fixed |
| **Security Hotspot** | Potentially sensitive code requiring manual review |

---

## ✅ 15. What preventive actions help avoid Sonar issues?
- Follow clean code practices
- Write unit tests
- Reduce method complexity
- Avoid duplication
- Handle exceptions properly
- Follow coding standards & code reviews

---

## ✅ Short Summary (for interviews)

> *"SonarQube ensures clean, maintainable, and secure code.  
> It tracks Bugs, Vulnerabilities, Code Smells, Coverage, and Duplications.  
> We use Quality Gates to block bad code from reaching production.  
> Common fixes include refactoring long methods, removing duplicates, improving coverage, and cleaning dead code."*
> 
>
# 🛡️ OWASP Top 10 Vulnerabilities (with Java Examples)

---

## **1. Broken Access Control (A01:2021)**
**Meaning:**  
Unauthorized users can access or perform actions beyond their privileges (e.g., accessing another user’s data).

**Example:**
```java
// ❌ Vulnerable: User ID taken directly from request
@GetMapping("/user/{id}")
public User getUser(@PathVariable Long id) {
    return userRepository.findById(id).get(); // Anyone can fetch any user's data
}
Fix:

java
Copy code
// ✅ Check ownership or role before access
@GetMapping("/user/{id}")
public User getUser(@AuthenticationPrincipal UserDetails user, @PathVariable Long id) {
    User current = userRepository.findByUsername(user.getUsername());
    if (!current.getId().equals(id)) {
        throw new AccessDeniedException("Unauthorized");
    }
    return current;
}
2. Cryptographic Failures (A02:2021)
Meaning:
Sensitive data is not properly encrypted or transmitted securely.

Example:

java
Copy code
// ❌ Vulnerable: storing password in plain text
user.setPassword(password);
Fix:

java
Copy code
// ✅ Hash password securely
user.setPassword(passwordEncoder.encode(password));
3. Injection (A03:2021)
Meaning:
Untrusted input is used in queries or commands (e.g., SQL injection, LDAP injection).

Example:

java
Copy code
// ❌ Vulnerable SQL query
String query = "SELECT * FROM users WHERE username = '" + username + "'";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(query);
Fix:

java
Copy code
// ✅ Use prepared statements
PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
ps.setString(1, username);
ResultSet rs = ps.executeQuery();
4. Insecure Design (A04:2021)
Meaning:
Application lacks security considerations in its architecture (e.g., no rate limiting, missing validation layers).

Example:

java
Copy code
// ❌ API with no rate limiting — can be brute-forced
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) { ... }
Fix:

java
Copy code
// ✅ Apply rate limiting and lockout policy
// Example: Use Spring Bucket4j or Redis rate limiter middleware
5. Security Misconfiguration (A05:2021)
Meaning:
Improperly configured security settings (e.g., default credentials, open admin consoles).

Example:

properties
Copy code
# ❌ application.properties
spring.datasource.username=admin
spring.datasource.password=admin
management.endpoints.web.exposure.include=*
Fix:

properties
Copy code
# ✅ Use environment variables and restrict access
management.endpoints.web.exposure.include=health,info
spring.datasource.password=${DB_PASSWORD}
6. Vulnerable and Outdated Components (A06:2021)
Meaning:
Using libraries or frameworks with known security flaws.

Example:

xml
Copy code
<!-- ❌ pom.xml -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>2.2.0.RELEASE</version> <!-- Old, contains CVEs -->
</dependency>
Fix:

xml
Copy code
<!-- ✅ Update dependencies regularly -->
<version>2.7.18</version>
7. Identification and Authentication Failures (A07:2021)
Meaning:
Weak authentication systems — like predictable tokens or no session expiration.

Example:

java
Copy code
// ❌ Weak token generation
String token = user.getUsername() + System.currentTimeMillis();
Fix:

java
Copy code
// ✅ Use JWT or secure token generators
String token = UUID.randomUUID().toString();
8. Software and Data Integrity Failures (A08:2021)
Meaning:
Code or data integrity is not verified (e.g., unverified plugins, insecure CI/CD pipelines).

Example:

bash
Copy code
# ❌ Downloading dependency from untrusted source
curl -O http://example.com/plugin.jar
Fix:

bash
Copy code
# ✅ Use trusted repositories and signature verification
mvn verify -Dgpg.verify=true
9. Security Logging and Monitoring Failures (A09:2021)
Meaning:
Security events are not logged or monitored, making breaches harder to detect.

Example:

java
Copy code
// ❌ No logging on failed login
if (!authSuccess) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
}
Fix:

java
Copy code
// ✅ Log important security events
if (!authSuccess) {
    logger.warn("Failed login attempt for user: {}", username);
}
10. Server-Side Request Forgery (SSRF) (A10:2021)
Meaning:
The server fetches URLs from untrusted input, allowing attackers to make internal network calls.

Example:

java
Copy code
// ❌ Vulnerable SSRF endpoint
@GetMapping("/fetch")
public String fetch(@RequestParam String url) {
    return restTemplate.getForObject(url, String.class);
}
Fix:

java
Copy code
// ✅ Validate or restrict allowed URLs
if (!url.startsWith("https://trusted-api.com")) {
    throw new IllegalArgumentException("Untrusted URL");
}
return restTemplate.getForObject(url, String.class);
✅ Summary Table
#	OWASP Category	Description	Java Example Problem	Fix
1	Broken Access Control	Users can access unauthorized data	/user/{id} without access check	Validate ownership or roles
2	Cryptographic Failures	Unencrypted sensitive data	Store plain-text passwords	Hash using bcrypt
3	Injection	Malicious input in SQL/commands	Concatenated SQL	Use PreparedStatement
4	Insecure Design	Lack of security in design	No rate limiting	Add validation, rate limiting
5	Security Misconfiguration	Weak or default settings	Exposed Actuator endpoints	Restrict configs
6	Outdated Components	Libraries with known CVEs	Old dependencies	Update dependencies
7	Auth Failures	Weak authentication/session	Predictable tokens	Use secure tokens, JWT
8	Integrity Failures	Unverified code/data	Download untrusted JARs	Use signature verification
9	Logging Failures	Missing security logs	No login audit	Add structured logging
10	SSRF	Unvalidated remote calls	Accept any URL input	Whitelist or validate URLs

javascript
Copy code

You can save this as `OWASP-Top10.md` in your project’s `docs/` folder for clean developer documentation.


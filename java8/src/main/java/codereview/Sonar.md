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

| Metric | Description |
|--------|------------|
| **Bugs** | Defects causing incorrect behavior |
| **Vulnerabilities** | Security threats exploitable by attackers |
| **Code Smells** | Maintainability issues |
| **Coverage** | % of code covered by tests |
| **Duplications** | Repeated code blocks |
| **Cyclomatic Complexity** | Complexity of logic based on conditions |
| **Technical Debt** | Time required to fix issues |

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


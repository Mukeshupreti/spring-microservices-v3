# OWASP Top 10 (2021) -- Java Examples and Fixes

## 1. Broken Access Control (A01:2021)

### Vulnerable Example

``` java
@GetMapping("/user/{id}")
public User getUser(@PathVariable Long id) {
    return userRepository.findById(id).get();
}
```

### Fix

``` java
@GetMapping("/user/{id}")
public User getUser(@AuthenticationPrincipal UserDetails user, @PathVariable Long id) {
    User current = userRepository.findByUsername(user.getUsername());
    if (!current.getId().equals(id)) {
        throw new AccessDeniedException("Unauthorized");
    }
    return current;
}
```

## 2. Cryptographic Failures (A02:2021)

### Vulnerable Example

``` java
user.setPassword(password);
```

### Fix

``` java
user.setPassword(passwordEncoder.encode(password));
```

## 3. Injection (A03:2021)

### Vulnerable Example

``` java
String query = "SELECT * FROM users WHERE username = '" + username + "'";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(query);
```

### Fix

``` java
PreparedStatement ps = connection.prepareStatement(
    "SELECT * FROM users WHERE username = ?"
);
ps.setString(1, username);
ResultSet rs = ps.executeQuery();
```

## 4. Insecure Design (A04:2021)

### Vulnerable Example

``` java
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) { ... }
```

### Fix

``` java
// Apply rate limiting using Spring Bucket4j or Redis rate limiter
```

## 5. Security Misconfiguration (A05:2021)

### Vulnerable Example

``` properties
spring.datasource.username=admin
spring.datasource.password=admin
management.endpoints.web.exposure.include=*
```

### Fix

``` properties
management.endpoints.web.exposure.include=health,info
spring.datasource.password=${DB_PASSWORD}
```

## 6. Vulnerable and Outdated Components (A06:2021)

### Vulnerable Example

``` xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>2.2.0.RELEASE</version>
</dependency>
```

### Fix

``` xml
<version>2.7.18</version>
```

## 7. Identification and Authentication Failures (A07:2021)

### Vulnerable Example

``` java
String token = user.getUsername() + System.currentTimeMillis();
```

### Fix

``` java
String token = UUID.randomUUID().toString();
```

## 8. Software and Data Integrity Failures (A08:2021)

### Vulnerable Example

``` bash
curl -O http://example.com/plugin.jar
```

### Fix

``` bash
mvn verify -Dgpg.verify=true
```

## 9. Security Logging and Monitoring Failures (A09:2021)

### Vulnerable Example

``` java
if (!authSuccess) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
}
```

### Fix

``` java
if (!authSuccess) {
    logger.warn("Failed login attempt for user: {}", username);
}
```

## 10. Server-Side Request Forgery (SSRF) (A10:2021)

### Vulnerable Example

``` java
@GetMapping("/fetch")
public String fetch(@RequestParam String url) {
    return restTemplate.getForObject(url, String.class);
}
```

### Fix

``` java
if (!url.startsWith("https://trusted-api.com")) {
    throw new IllegalArgumentException("Untrusted URL");
}
return restTemplate.getForObject(url, String.class);
```

# Summary Table

  ------------------------------------------------------------------------------------------
  \#   Category           Description        Vulnerable Example          Fix
  ---- ------------------ ------------------ --------------------------- -------------------
  1    Broken Access      Unauthorized       Access user by ID without   Validate ownership
       Control            access             check                       or roles

  2    Cryptographic      Unencrypted data   Plain-text password         Hash password
       Failures                                                          

  3    Injection          Unsafe SQL         Concatenated SQL query      Use
                                                                         PreparedStatement

  4    Insecure Design    Missing controls   No rate limiting            Add rate limiting

  5    Security           Weak/default       Exposed endpoints           Secure
       Misconfiguration   settings                                       configurations

  6    Outdated           Vulnerable         Old dependency              Update versions
       Components         libraries                                      

  7    Auth Failures      Weak tokens        Predictable token           Use UUID or JWT

  8    Integrity Failures Unverified         Downloading JAR over HTTP   Signature
                          downloads                                      verification

  9    Logging Failures   Missing audit logs No log on failure           Add logging

  10   SSRF               Unvalidated URLs   Accepts any URL             Validate or
                                                                         restrict URLs
  ------------------------------------------------------------------------------------------

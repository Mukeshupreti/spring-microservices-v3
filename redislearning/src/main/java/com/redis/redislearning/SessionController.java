package com.redis.redislearning;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @PostMapping("/set")
    public String setAttribute(HttpSession session, @RequestParam String key, @RequestParam String value) {
        session.setAttribute(key, value);
        return "Stored in session: " + key + " = " + value;
    }

    @GetMapping("/get")
    public String getAttribute(HttpSession session, @RequestParam String key) {
        Object value = session.getAttribute(key);
        return value != null ? "Value: " + value : "No value found for key: " + key;
    }

    @PostMapping("/invalidate")
    public String invalidate(HttpSession session) {
        session.invalidate();
        return "Session invalidated.";
    }
}


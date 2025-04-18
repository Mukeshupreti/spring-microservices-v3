package com.in28minutes.microservices.currencyconversionservice.mdc;

import jakarta.servlet.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;


// This is filter to put properties to put in MDC logger it can put to retrieve in logger configuration
// eg logging.pattern.level=%5p [${spring.application.name:},%X{userID:-} %X{traceId:-},%X{spanId:-}]
@Component
public class MDCFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            String requestId = UUID.randomUUID().toString();

           /* MDC (Mapped Diagnostic Context)! Great topic — it’s super handy for logging contextual data like requestId,
                    userId, or sessionId so you can trace logs across threads or microservices.*/
            MDC.put("userID", "Mukesh Upreti");
            chain.doFilter(request, response);
        } finally {
            MDC.clear();  // Always clear to avoid memory leaks
        }
    }
}

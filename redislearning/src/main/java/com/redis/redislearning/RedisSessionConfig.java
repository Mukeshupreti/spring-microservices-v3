package com.redis.redislearning;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

// Optional - Not required in most cases
@Configuration
@EnableRedisHttpSession

public class RedisSessionConfig {
}


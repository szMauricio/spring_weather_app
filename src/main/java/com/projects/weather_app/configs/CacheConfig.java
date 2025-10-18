package com.projects.weather_app.configs;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching
@Configuration
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cm = new CaffeineCacheManager("weather");
        cm.setCaffeine(Caffeine.newBuilder().expireAfterWrite(Duration.ofMinutes(10)).maximumSize(500));
        return cm;
    }
}

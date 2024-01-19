package ru.consulting.sergei.charfrequencyapi.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

/**
 * Configuration class for setting up caching with Redis.
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Value("${redis.cache.minutes}")
    Integer lifetimeInMinutes;

    /**
     * Creates a RedisCacheManager bean with the provided RedisConnectionFactory.
     *
     * @param redisConnectionFactory The Redis connection factory.
     * @return The RedisCacheManager instance.
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(lifetimeInMinutes));

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration)
                .build();
    }
}
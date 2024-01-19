package ru.consulting.sergei.charfrequencyapi.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Configuration class for setting up the Redis connection.
 */
@Configuration
public class RedisConfig {

    @Value("${spring.data.redis.host}")
    String host;

    @Value("${spring.data.redis.port}")
    Integer port;

    /**
     * Creates a JedisConnectionFactory bean with the provided Redis connection details.
     *
     * @return The JedisConnectionFactory instance.
     */
    @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(
                host,
                port
        );
        return new JedisConnectionFactory(configuration);
    }
}
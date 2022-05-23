package org.francis.rate_limiter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * @author Franc1s
 * @date 2022/5/23
 * @apiNote
 */
@Configuration
public class RedisConfig {
    @Bean
    RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> keySerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setKeySerializer(keySerializer);
        template.setValueSerializer(keySerializer);
        template.setHashKeySerializer(keySerializer);
        template.setHashValueSerializer(keySerializer);
        return template;
    }

    @Bean
    DefaultRedisScript<Long> limitScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/limit.lua")));
        return redisScript;
    }
}

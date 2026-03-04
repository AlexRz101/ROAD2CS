package com.road2cs.services;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitService {

    private final Map<String, Bucket> cache = new ConcurrentHashMap<>();

    public Bucket resolveBucket(String key) {
        return cache.computeIfAbsent(key, k -> createNewBucket());
    }

    private Bucket createNewBucket() {
        //5 requests per hour
        Bandwidth limit = Bandwidth.builder()
                .capacity(10) //total amount of requests
                .refillIntervally(10, Duration.ofMinutes(1)) //refill all requests per minute
                .build(); //built bucket

        return Bucket.builder()
                .addLimit(limit)
                .build();
    }
}
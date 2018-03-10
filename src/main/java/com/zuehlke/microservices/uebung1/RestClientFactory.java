package com.zuehlke.microservices.uebung1;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.hystrix.FallbackFactory;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

// Feign RestClientFactory
public class RestClientFactory {

    public static <T> T createClient(String url, Class<T> clazz) {
        return createDefaultClient().target(clazz, url);
    }

    public static <T> T createClientWithFallback(String url, Class<T> clazz, T fallback) {
        return createDefaultClient().target(clazz, url, fallback);
    }

    private static HystrixFeign.Builder createDefaultClient() {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        return HystrixFeign.builder()
                .decoder(new JacksonDecoder(mapper))
                .logger(new Slf4jLogger(RestClientFactory.class))
                .logLevel(Logger.Level.FULL);
    }
}
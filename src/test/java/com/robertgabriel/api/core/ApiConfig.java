package com.robertgabriel.api.core;

public final class ApiConfig {
    private ApiConfig() {}

    public static String baseUrl() {
        String value = System.getProperty("base.url");
        return value == null || value.isBlank()
                ? "https://jsonplaceholder.typicode.com"
                : value;
    }

    public static long maxResponseTimeMs() {
        String value = System.getProperty("max.response.time.ms");
        return value == null || value.isBlank()
                ? 2000L
                : Long.parseLong(value);
    }
}

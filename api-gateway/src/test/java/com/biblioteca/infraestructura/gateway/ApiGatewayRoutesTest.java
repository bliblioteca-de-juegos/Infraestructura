package com.biblioteca.infraestructura.gateway;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiGatewayRoutesTest {

    @Test
    void configuraLasOnceRutasMedianteLoadBalancer() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getResourceAsStream("/application.properties")) {
            assertNotNull(input);
            properties.load(input);
        }

        for (int i = 0; i < 11; i++) {
            String base = "spring.cloud.gateway.server.webflux.routes[" + i + "]";
            assertTrue(properties.containsKey(base + ".id"));
            assertTrue(properties.getProperty(base + ".uri").startsWith("lb://"));
            assertTrue(properties.getProperty(base + ".predicates[0]").startsWith("Path="));
        }

        assertEquals("8080", properties.getProperty("server.port"));
    }
}

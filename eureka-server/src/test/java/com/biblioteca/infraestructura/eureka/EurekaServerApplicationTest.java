package com.biblioteca.infraestructura.eureka;

import org.junit.jupiter.api.Test;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EurekaServerApplicationTest {

    @Test
    void aplicacionTieneEurekaServerHabilitado() {
        assertTrue(EurekaServerApplication.class.isAnnotationPresent(EnableEurekaServer.class));
    }
}

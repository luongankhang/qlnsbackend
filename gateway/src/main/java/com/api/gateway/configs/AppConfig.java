package com.api.gateway.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("api1_route", r ->
                        r.path("/api/auth/**")
                                .uri("http://localhost:8081")
                )
                .route("api2_route", r ->
                        r.path("/api/nhanvien/**")
                                .uri("http://localhost:8082")
                )
                .route("api3_route", r ->
                        r.path("/api/lich/**")
                                .uri("http://localhost:8083")
                )
                .route("api4_route", r ->
                        r.path("/api/chamcong/**")
                                .uri("http://localhost:8084")
                )
                .route("api5_route", r ->
                        r.path("/api/phongban/**")
                                .uri("http://localhost:8082")
                )
                .route("api6_route", r ->
                        r.path("/api/of/**")
                                .uri("http://localhost:8082")
                )
                .build();
    }
}

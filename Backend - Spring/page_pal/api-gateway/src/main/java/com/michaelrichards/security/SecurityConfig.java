package com.michaelrichards.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
            return httpSecurity.csrf(
                            ServerHttpSecurity.CsrfSpec::disable
            )
                    .authorizeExchange( authorizeExchangeSpec ->
                            authorizeExchangeSpec
                                    .pathMatchers("(/eureka/**")
                                    .permitAll()
                                    .anyExchange()
                                    .permitAll()
                    )
                    .oauth2ResourceServer(
                            oAuth2ResourceServerSpec ->
                                    oAuth2ResourceServerSpec.jwt(Customizer.withDefaults())
                    ).build();
    }

}

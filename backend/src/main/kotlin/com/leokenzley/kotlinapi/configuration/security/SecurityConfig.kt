package com.leokenzley.kotlinapi.configuration.security

                    import org.springframework.context.annotation.Bean
                    import org.springframework.context.annotation.Configuration
                    import org.springframework.security.config.annotation.web.builders.HttpSecurity
                    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
                    import org.springframework.security.oauth2.jwt.JwtDecoder
                    import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
                    import org.springframework.security.web.SecurityFilterChain

                    @Configuration
                    @EnableWebSecurity
                    class SecurityConfig {

                        @Bean
                        fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
                            http
                                .authorizeHttpRequests { authz ->
                                    authz
                                        .requestMatchers("/", "/public**").permitAll()
                                        .requestMatchers("/h2-console/**").permitAll()
                                        .anyRequest().authenticated()
                                }
                                .csrf { csrf -> csrf.disable() } // Desabilitar CSRF para o console H2
                                .headers { headers -> headers.frameOptions { frameOptions -> frameOptions.disable() } } // Permitir que o console H2 seja exibido em um iframe
                                .oauth2ResourceServer { oauth2 ->
                                    oauth2.jwt { jwtConfigurer ->
                                        jwtConfigurer.decoder(jwtDecoder())
                                    }
                                }
                            return http.build()
                        }

                        @Bean
                        fun jwtDecoder(): JwtDecoder {
                            return NimbusJwtDecoder.withJwkSetUri("https://www.googleapis.com/oauth2/v3/certs").build()
                        }
                    }
package com.snapshoes.store.config.security

import com.snapshoes.store.persistense.entities.UserRole
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.http.HttpMethod
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.web.util.matcher.RequestMatcher

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(JwtProperties::class)
class SecurityConfiguration(
    private val authenticationProvider: AuthenticationProvider
) {
    @Bean
    fun securityFilterChain(
        http: HttpSecurity,
        jwtAuthFilter: JwtAuthenticationFilter
    ): DefaultSecurityFilterChain {
        return http
            .csrf { it.disable() }
            .authorizeHttpRequests {


                storePublicPaths.forEach { matcher ->
                    it.requestMatchers(matcher).permitAll()
                }

                hasAdminPaths.forEach { matcher ->
                    it.requestMatchers(matcher).hasAnyRole(UserRole.ADMIN.role, UserRole.STORE.role, UserRole.USER.role)

                }

                hasStorePaths.forEach { matcher ->
                    it.requestMatchers(matcher).hasRole(UserRole.STORE.role)
                }

                authPublicPaths.forEach { matcher ->
                    it.requestMatchers(matcher).permitAll()
                }

                it.requestMatchers("/api/auth/login", "/api/auth/create", "/api/auth/refresh", "/error")
                    .permitAll()
                    .anyRequest()
                    .fullyAuthenticated()



            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }

    private val storePublicPaths: List<RequestMatcher> =
        listOf(
            AntPathRequestMatcher("/products/**", HttpMethod.GET.name()),
            AntPathRequestMatcher("/stores/**", HttpMethod.GET.name()),
            AntPathRequestMatcher("/genres/**", HttpMethod.GET.name()),
            AntPathRequestMatcher("/brands/**", HttpMethod.GET.name()),
            AntPathRequestMatcher("/sizes/**", HttpMethod.GET.name())
        )

    private val authPublicPaths: List<RequestMatcher> =
        listOf(
            //AntPathRequestMatcher("/api/auth/login", HttpMethod.POST.name()),
            AntPathRequestMatcher("/api/auth/create", HttpMethod.POST.name()),
            AntPathRequestMatcher("/api/auth/refresh", HttpMethod.POST.name()),
            AntPathRequestMatcher("/error", HttpMethod.GET.name())
        )

    private val hasAdminPaths: List<RequestMatcher> =
        listOf(
            AntPathRequestMatcher("/stores/**", HttpMethod.POST.name()),
            AntPathRequestMatcher("/stores/**", HttpMethod.DELETE.name()),
            AntPathRequestMatcher("/stores/**", HttpMethod.PUT.name()),
            AntPathRequestMatcher("/stores/**", HttpMethod.PATCH.name()),
            AntPathRequestMatcher("/stores/update-address/**", HttpMethod.POST.name()),

            AntPathRequestMatcher("/products/**", HttpMethod.POST.name()),
            AntPathRequestMatcher("/products/**", HttpMethod.DELETE.name()),
            AntPathRequestMatcher("/products/**", HttpMethod.PUT.name()),
            AntPathRequestMatcher("/products/**", HttpMethod.PATCH.name()),

            AntPathRequestMatcher("/genres/**", HttpMethod.POST.name()),
            AntPathRequestMatcher("/genres/**", HttpMethod.DELETE.name()),
            AntPathRequestMatcher("/genres/**", HttpMethod.PUT.name()),
            AntPathRequestMatcher("/genres/**", HttpMethod.PATCH.name()),

            AntPathRequestMatcher("/brands/**", HttpMethod.POST.name()),
            AntPathRequestMatcher("/brands/**", HttpMethod.DELETE.name()),
            AntPathRequestMatcher("/brands/**", HttpMethod.PUT.name()),
            AntPathRequestMatcher("/brands/**", HttpMethod.PATCH.name()),

            AntPathRequestMatcher("/sizes/**", HttpMethod.POST.name()),
            AntPathRequestMatcher("/sizes/**", HttpMethod.DELETE.name()),
            AntPathRequestMatcher("/sizes/**", HttpMethod.PUT.name()),
            AntPathRequestMatcher("/sizes/**", HttpMethod.PATCH.name())
        )

    private val hasStorePaths: List<RequestMatcher> =
        listOf(
            AntPathRequestMatcher("/stores/**", HttpMethod.PUT.name()),
            AntPathRequestMatcher("/stores/**", HttpMethod.PATCH.name()),
            AntPathRequestMatcher("/stores/update-address/**", HttpMethod.POST.name()),

            AntPathRequestMatcher("/products/**", HttpMethod.POST.name()),
            AntPathRequestMatcher("/products/**", HttpMethod.DELETE.name()),
            AntPathRequestMatcher("/products/**", HttpMethod.PUT.name()),
            AntPathRequestMatcher("/products/**", HttpMethod.PATCH.name())
        )
}
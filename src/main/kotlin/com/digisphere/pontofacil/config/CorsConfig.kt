package com.digisphere.pontofacil.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig : WebMvcConfigurer {

  override fun addCorsMappings(registry: CorsRegistry) {
    registry.addMapping("/**") // Apply to all endpoints
      .allowedOrigins("http://localhost:4200", "http://localhost:4200/**") // Target allowed domains
      .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // Allowed HTTP verbs
      .allowedHeaders("*") // Accept all incoming headers
      .allowCredentials(true) // Permit cookie transmission
      .maxAge(3600) // Cache pre-flight response for 1 hour
  }
}

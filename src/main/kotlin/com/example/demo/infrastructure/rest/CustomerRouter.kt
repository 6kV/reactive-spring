package com.example.demo.infrastructure.rest

import com.example.demo.infrastructure.rest.handler.CustomerHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*

@Configuration
class CustomerRouter {


    @Bean
    fun route(customerHandler: CustomerHandler) : RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.GET("all"),customerHandler::findAll)
    }

}
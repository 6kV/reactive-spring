package com.example.demo.infrastructure.rest.handler

import com.example.demo.domain.model.Customer
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class CustomerHandler {

    fun findAll(serverRequest: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .body(
                Flux
                    .fromStream(
                        listOf(
                            Customer("n", "k", 36),
                            Customer("e", "d", 35)
                        )
                            .stream()
                    ), Customer::class.java
            )
}
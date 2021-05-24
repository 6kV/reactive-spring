package com.example.demo.domain.port

import com.example.demo.domain.model.Customer
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerRepository {

    fun save(customer: Customer) : Mono<Customer>

    fun findAll(): Flux<Customer>
}
package com.example.demo.infrastructure.adapter

import com.example.demo.domain.model.Customer
import com.example.demo.domain.port.CustomerRepository
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface CustomerRepositoryAdapter : CustomerRepository, ReactiveCrudRepository<Customer, Long> {

    @Query("SELECT * FROM customer")
    override fun findAll(): Flux<Customer>
}
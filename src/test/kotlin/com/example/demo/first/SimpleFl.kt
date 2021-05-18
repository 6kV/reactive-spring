package com.example.demo.first

import org.junit.jupiter.api.Test
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.stream.Stream

class SimpleFluxFactoriesTest {

    @Test
    fun `should be the first test`() {

        val rangeOfIntegers: Publisher<Int> = Flux.range(0, 10)
        StepVerifier.create(rangeOfIntegers).expectNextCount(10).verifyComplete()

        val letters : Publisher<String> = Flux.just("A", "B", "C")
        StepVerifier.create(letters).expectNext("A","B","C").verifyComplete()

        val now = System.currentTimeMillis()
        val greetingMono: Mono<Date> = Mono.just(Date(now))
        StepVerifier.create(greetingMono).expectNext(Date(now)).verifyComplete()

        // Mono.empty
        // Flux.fromArray
        // Flux.fromIterables

        val integer = AtomicInteger()
        val supplier = integer::incrementAndGet
        Flux.fromStream(Stream.generate(supplier))
    }
}
package com.inflearn.spring.proxy.cglib

import com.inflearn.spring.proxy.cglib.code.TimeMethodInterceptor
import com.inflearn.spring.proxy.common.service.ConcreteService
import org.junit.jupiter.api.Test
import org.springframework.cglib.proxy.Enhancer

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class CglibTest {
    @Test
    fun cglib() {
        val target = ConcreteService()

        val enhancer =
            Enhancer().apply {
                setSuperclass(ConcreteService::class.java)
                setCallback(TimeMethodInterceptor(target))
            }

        val proxy = enhancer.create() as ConcreteService

        log.info { "target class ${target.javaClass}" }
        log.info { "proxy class ${proxy.javaClass}" }

        proxy.call()
    }
}
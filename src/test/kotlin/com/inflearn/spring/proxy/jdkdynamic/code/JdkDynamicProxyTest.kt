package com.inflearn.spring.proxy.jdkdynamic.code

import mu.KotlinLogging
import org.junit.jupiter.api.Test
import java.lang.reflect.Proxy

private val log = KotlinLogging.logger {}

class JdkDynamicProxyTest {

    @Test
    fun dynamicA() {
        val target = AImpl()
        val handler = TimeInvocationHandler(target)

        val proxy = Proxy.newProxyInstance(
            AInterface::class.java.classLoader,
            arrayOf(AInterface::class.java),
            handler,
        ) as AInterface

        proxy.call()

        log.info { "targetClass :: ${target.javaClass}" }
        log.info { "proxyClass :: ${proxy.javaClass}" }
    }

    @Test
    fun dynamicB() {
        val target = BImpl()
        val handler = TimeInvocationHandler(target)

        val proxy = Proxy.newProxyInstance(
            BInterface::class.java.classLoader,
            arrayOf(BInterface::class.java),
            handler,
        ) as BInterface

        proxy.call()

        log.info { "targetClass :: ${target.javaClass}" }
        log.info { "proxyClass :: ${proxy.javaClass}" }
    }
}
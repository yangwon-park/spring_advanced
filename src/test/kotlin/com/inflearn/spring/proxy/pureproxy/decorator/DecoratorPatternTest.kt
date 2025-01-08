package com.inflearn.spring.proxy.pureproxy.decorator

import com.inflearn.spring.proxy.pureproxy.decorator.code.DecoratorPatternClient
import com.inflearn.spring.proxy.pureproxy.decorator.code.MessageDecorator
import com.inflearn.spring.proxy.pureproxy.decorator.code.RealComponent
import com.inflearn.spring.proxy.pureproxy.decorator.code.TimeDecorator
import org.junit.jupiter.api.Test

class DecoratorPatternTest {
    @Test
    fun noDecorator() {
        val realComponent = RealComponent()
        val client = DecoratorPatternClient(realComponent)

        client.execute()
    }

    @Test
    fun decorator1() {
        val realComponent = RealComponent()
        val messageDecorator = MessageDecorator(realComponent)
        val client = DecoratorPatternClient(messageDecorator)

        client.execute()
    }

    @Test
    fun decorator2() {
        val realComponent = RealComponent()
        val messageDecorator = MessageDecorator(realComponent)
        val timeDecorator = TimeDecorator(messageDecorator)
        val client = DecoratorPatternClient(timeDecorator)

        client.execute()
    }
}
package com.inflearn.spring.app.proxy.config

import com.inflearn.spring.app.proxy.v2.OrderControllerV2
import com.inflearn.spring.app.proxy.v2.OrderRepositoryV2
import com.inflearn.spring.app.proxy.v2.OrderServiceV2
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration
class AppV2Config {
    @Bean
    fun orderControllerV2(): OrderControllerV2 {
        return OrderControllerV2(orderServiceV2())
    }

    @Bean
    fun orderServiceV2(): OrderServiceV2 {
        return OrderServiceV2(orderRepositoryV2())
    }

    @Bean
    fun orderRepositoryV2(): OrderRepositoryV2 {
        return OrderRepositoryV2()
    }
}
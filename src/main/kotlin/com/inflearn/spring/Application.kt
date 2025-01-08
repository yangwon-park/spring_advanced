package com.inflearn.spring

import com.inflearn.spring.app.proxy.v2_dynamicproxy.DynamicProxyConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

//@Import(AppV1Config::class)
@Import(DynamicProxyConfig::class)
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = ["com.inflearn.spring.app.proxy"])
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}

package com.inflearn.spring.app.proxy.v1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/proxy")
interface OrderControllerV1 {
    @GetMapping("/v1/request")
    fun request(@RequestParam itemId: String): String

    @GetMapping("/v1/no-log")
    fun noLog(): String
}
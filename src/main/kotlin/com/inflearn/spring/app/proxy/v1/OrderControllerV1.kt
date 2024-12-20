package com.inflearn.spring.app.proxy.v1

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/proxy")
@ResponseBody
//@RestController("/proxy")
interface OrderControllerV1 {
    @GetMapping("/v1/request")
    fun request(@RequestParam itemId: String): String

    @GetMapping("/v1/no-log")
    fun noLog(): String
}
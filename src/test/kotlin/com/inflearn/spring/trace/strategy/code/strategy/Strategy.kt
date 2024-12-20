package com.inflearn.spring.trace.strategy.code.strategy

/**
 * fun 키워드가 없으면 SAM Interface로 인식하지 않음
 */
fun interface Strategy {
    fun call()
}
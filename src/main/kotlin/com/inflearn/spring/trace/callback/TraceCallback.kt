package com.inflearn.spring.trace.callback

fun interface TraceCallback<T> {
    fun call(): T
}
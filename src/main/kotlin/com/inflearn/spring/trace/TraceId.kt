package com.inflearn.spring.trace

import java.util.*

class TraceId private constructor(
    private val id: String,
    private val level: Int,
) {
    constructor(): this(
        createId(),
        0
    )

     fun createNextId(): TraceId {
        return TraceId(id, level + 1)
    }

    fun createPreviousId(): TraceId {
        return TraceId(id, level - 1)
    }

    fun getId(): String {
        return id
    }

    fun getLevel(): Int {
        return level
    }

    fun isFirstLevel(): Boolean {
        return level == 0
    }

    companion object {
        private fun createId(): String {
            return UUID.randomUUID().toString().substring(0, 8)
        }
    }
}
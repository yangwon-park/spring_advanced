package com.inflearn.spring.trace.template

import com.inflearn.spring.trace.template.code.AbstractTemplate
import com.inflearn.spring.trace.template.code.SubClassLogic1
import com.inflearn.spring.trace.template.code.SubClassLogic2
import mu.KotlinLogging
import org.junit.jupiter.api.Test

private val log = KotlinLogging.logger {}

class TemplateMethodTest {

    @Test
    fun templateMethodV0() {
        logic1()
        logic2()
    }

    private fun logic1() {
        val startTime = System.currentTimeMillis()

        log.info { "비즈니스 로직1 실행" }

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime

        log.info { "resultTime=$resultTime" }
    }

    private fun logic2() {
        val startTime = System.currentTimeMillis()

        log.info { "비즈니스 로직2 실행" }

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime

        log.info { "resultTime=$resultTime" }
    }

    /**
     * Template Method Pattern
     */
    @Test
    fun templateMethodV1() {
        val template1 = SubClassLogic1()
        template1.execute()

        val template2 = SubClassLogic2()
        template2.execute()
    }

    @Test
    fun templateMethodV2() {
        val template1 = object : AbstractTemplate() {
            override fun call() {
                log.info { "비즈니스 로직1 실행" }
            }
        }

        log.info { "클래스 이름1 = ${template1.javaClass}" }

        template1.execute()

        val template2 = object : AbstractTemplate() {
            override fun call() {
                log.info { "비즈니스 로직2 실행" }
            }
        }

        log.info { "클래스 이름2 = ${template2.javaClass}" }

        template2.execute()
    }
}
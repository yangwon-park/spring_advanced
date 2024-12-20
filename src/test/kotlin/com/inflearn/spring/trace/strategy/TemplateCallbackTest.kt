package com.inflearn.spring.trace.strategy

import com.inflearn.spring.trace.strategy.code.template.TimeLogTemplate
import mu.KotlinLogging
import org.junit.jupiter.api.Test

private val log = KotlinLogging.logger {}

class TemplateCallbackTest {

    /**
     * 템플릿 콜백 패턴
     */
    @Test
    fun callbackV1() {
        val template = TimeLogTemplate()
        template.execute { log.info { "비즈니스 로직1 실행" } }
        template.execute { log.info { "비즈니스 로직2 실행" } }
    }
}
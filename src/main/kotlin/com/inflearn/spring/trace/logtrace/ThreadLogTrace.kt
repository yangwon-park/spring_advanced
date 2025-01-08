package com.inflearn.spring.trace.logtrace

import com.inflearn.spring.trace.TraceId
import com.inflearn.spring.trace.TraceStatus
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class ThreadLogTrace : LogTrace {
    private var traceIdHolder: ThreadLocal<TraceId> = ThreadLocal()

    override fun begin(message: String): TraceStatus {
        syncTraceId()
        val traceId = traceIdHolder.get() ?: throw IllegalArgumentException()

        val startTimeMs = System.currentTimeMillis()
        log.info { "[${traceId.getId()}] ${addSpace(START_PREFIX, traceId.getLevel())}$message " }

        return TraceStatus(traceId, startTimeMs, message)
    }

    private fun syncTraceId() {
        val traceId = traceIdHolder.get()

        if (traceId == null) {
            traceIdHolder.set(TraceId())
        } else {
            traceIdHolder.set(traceId.createNextId())
        }
    }

    override fun end(status: TraceStatus) {
        complete(status, null)
    }

    override fun exception(status: TraceStatus?, e: Exception) {
        complete(status, e)
    }

    private fun complete(status: TraceStatus?, e: Exception?) {
        if (status == null) throw IllegalArgumentException()

        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.startTimeMs
        val traceId = status.traceId

        if (e == null) {
            log.info {
                "[${traceId.getId()}] ${
                    addSpace(
                        COMPLETE_PREFIX, traceId.getLevel()
                    )
                } ${status.message} time=${resultTimeMs}ms"
            }
        } else {
            log.info {
                "[${traceId.getId()}] ${
                    addSpace(
                        EX_PREFIX, traceId.getLevel()
                    )
                } ${status.message} time=${resultTimeMs}ms ex=$e"
            }
        }

        releaseTraceId()
    }

    private fun releaseTraceId() {
        val traceId = traceIdHolder.get()

        if (traceId.isFirstLevel()) {
            traceIdHolder.remove() // destroy
        } else {
            traceIdHolder.set(traceId.createPreviousId())
        }
    }

    companion object {
        private const val START_PREFIX = "-->"
        private const val COMPLETE_PREFIX = "<--"
        private const val EX_PREFIX = "<X-"

        private fun addSpace(
            prefix: String,
            level: Int,
        ): String {
            val sb = StringBuilder()
            for (i in 0 until level) {
                sb.append(if (i == level - 1) "|$prefix" else "|  ")
            }

            return sb.toString()
        }
    }
}
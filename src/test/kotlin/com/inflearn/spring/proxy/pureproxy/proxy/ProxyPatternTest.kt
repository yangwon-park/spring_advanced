package com.inflearn.spring.proxy.pureproxy.proxy

import com.inflearn.spring.proxy.pureproxy.proxy.code.CacheProxy
import com.inflearn.spring.proxy.pureproxy.proxy.code.ProxyPatternClient
import com.inflearn.spring.proxy.pureproxy.proxy.code.RealSubject
import org.junit.jupiter.api.Test

class ProxyPatternTest {

    @Test
    fun noProxyTest() {
        val realSubject = RealSubject()
        val client = ProxyPatternClient(realSubject)

        client.execute()
        client.execute()
        client.execute()
    }

    @Test
    fun cacheProxyTest() {
        val realSubject = RealSubject()
        val cacheProxy = CacheProxy(realSubject)
        val client = ProxyPatternClient(cacheProxy)

        client.execute()
        client.execute()
        client.execute()
    }
}
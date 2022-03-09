package com.vaibhav.lruchachelib

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LruCacheTest {
    private lateinit var lruCache: LruCache
    private val cacheSize = 4

    @BeforeEach
    fun setUp() {
        lruCache = LruCache(cacheSize)
    }

    @Test
    fun `should return referred list from LRU cache`() {
        lruCache.refer(1)
        lruCache.refer(2)
        lruCache.refer(3)
        lruCache.refer(1)
        lruCache.refer(4)
        lruCache.refer(5)
        lruCache.refer(2)
        lruCache.refer(2)
        lruCache.refer(1)

        Assertions.assertEquals(lruCache.getData().toString(), listOf(1, 2, 5, 4).toString())
    }
}

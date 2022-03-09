package com.vaibhav.lruchachelib

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LruCachePagingTest {
    private lateinit var lruCachePaging: LruCachePaging
    private val cacheSize = 4

    @BeforeEach
    fun setUp() {
        lruCachePaging = LruCachePaging(cacheSize)
    }

    @Test
    fun `should return referred list from LRU cache`() {
        lruCachePaging.refer(1)
        lruCachePaging.refer(2)
        lruCachePaging.refer(3)
        lruCachePaging.refer(1)
        lruCachePaging.refer(4)
        lruCachePaging.refer(5)
        lruCachePaging.refer(2)
        lruCachePaging.refer(2)
        lruCachePaging.refer(1)

        Assertions.assertEquals(lruCachePaging.getData().toString(), listOf(1, 2, 5, 4).toString())
    }
}

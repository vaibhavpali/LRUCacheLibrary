package com.vaibhav.lruchachelib

import org.junit.jupiter.api.Test

class LRUCacheTest {
    @Test
    fun `Test cache data structure`() {
        val cache = LRUCache<String>(2)

        cache.put("1", "One")
        cache.put("2", "Two")

        cache.get("1")
        cache.put("3", "Three")

        assert(cache.get("1") == "One")
        assert(cache.get("3") == "Three")
        assert(cache.get("3") != "One")

        // Expect this to be null since the backet with "2" was freed on max size (2)
        // Since it was the least recently used
        assert(cache.get("2") == null)

        cache.dump() // {1=One, 3=Three}
    }
}

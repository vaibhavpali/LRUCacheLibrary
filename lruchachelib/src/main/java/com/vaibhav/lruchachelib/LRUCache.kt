package com.vaibhav.lruchachelib

class LRUCache<T>(val capacity: Int) {
    fun remove(key: String): Boolean {
        return internalCache.remove(key) != null
    }

    fun put(key: String, value: T) {
        internalCache[key] = value
    }

    fun get(key: String): T? = internalCache[key]

    fun reset() {
        internalCache.clear()
    }

    private val internalCache: MutableMap<String, T> =
        object : LinkedHashMap<String, T>(0, 0.75f, true) {
            override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, T>?): Boolean {
                return size > capacity
            }
        }

    fun size(): Long {
        return synchronized(this) {
            val snapshot = LinkedHashMap(internalCache)
            snapshot.size.toLong()
        }
    }

    fun dump() {
        println(internalCache)
    }
}

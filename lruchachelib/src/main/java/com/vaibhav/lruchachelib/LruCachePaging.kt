package com.vaibhav.lruchachelib

// ktlint-disable no-wildcard-imports
import java.util.*

class LruCachePaging(private val cacheSize: Int) {
    private var doubleQueue = LinkedList<Int>()
    private var hashSet = HashSet<Int>()

    fun refer(page: Int) {
        if (!hashSet.contains(page)) {
            if (doubleQueue.size == cacheSize) {
                val last = doubleQueue.removeLast()
                hashSet.remove(last)
            }
        } else {
            doubleQueue.remove(page)
        }
        doubleQueue.push(page)
        hashSet.add(page)
    }

    fun getData(): List<Int> {
        return doubleQueue.toList()
    }
}

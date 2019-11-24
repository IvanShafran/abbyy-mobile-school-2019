package main

interface IStorage {

    fun put(key: String, value: String)

    fun put(key: String, value: Int)

    fun put(key: String, value: Long)

    fun put(key: String, value: Char)

    fun put(key: String, value: Double)

    fun get(key: String): Any?

}
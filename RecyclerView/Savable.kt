package com.example.RecyclerView

interface Savable {

    fun init(data: ByteArray)

    fun toBytes(): ByteArray

    fun describe(): String
}
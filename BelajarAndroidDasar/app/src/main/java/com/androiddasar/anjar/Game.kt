package com.androiddasar.anjar

import kotlin.random.Random

object Game {
    private val rules = mapOf(
        "BATU-GUNTING" to true,
        "BATU-KERTAS" to false,
        "GUNTING-KERTAS" to true,
        "GUNTING-BATU" to false,
        "KERTAS-BATU" to true,
        "KERTAS-GUNTING" to false
    )

    private val options = listOf("BATU", "GUNTING","KERTAS")

    private val optionDrawable = mapOf(
        "BATU" to R.drawable.batu,
        "GUNTING" to R.drawable.gunting,
        "KERTAS" to R.drawable.kertas,
    )
    fun pickRandomOption():String = options[Random.nextInt(0,3)]

    fun pickDrawable(option :String): Int = optionDrawable[option]!!

    // cek rule
    fun isDraw(from:String, to:String):Boolean = from == to

    fun isWin(from: String, to: String):Boolean = rules["$from-$to"]!!


}
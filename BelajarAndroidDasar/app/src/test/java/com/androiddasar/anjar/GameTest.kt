package com.androiddasar.anjar

import org.junit.Assert
import org.junit.Test

class GameTest {

    @Test
    fun testPickRandomOption() {
        val options = listOf("BATU","GUNTING","KERTAS")
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
    }

    @Test
    fun testPickDrawable() {
        Assert.assertEquals(R.drawable.kertas, Game.pickDrawable("KERTAS"))
        Assert.assertEquals(R.drawable.gunting, Game.pickDrawable("GUNTING"))
        Assert.assertEquals(R.drawable.batu, Game.pickDrawable("BATU"))
    }

    @Test
    fun testIsDraw() {
        Assert.assertTrue(Game.isDraw("BATU","BATU"))
        Assert.assertTrue(Game.isDraw("GUNTING","GUNTING"))
        Assert.assertTrue(Game.isDraw("KERTAS","KERTAS"))

        Assert.assertFalse(Game.isDraw("BATU","KERTAS"))
        Assert.assertFalse(Game.isDraw("GUNTING","BATU"))
        Assert.assertFalse(Game.isDraw("KERTAS","GUNTING"))
    }

    @Test
    fun testIsWin() {
        Assert.assertTrue(Game.isWin("BATU","GUNTING"))
        Assert.assertTrue(Game.isWin("GUNTING","KERTAS"))
        Assert.assertTrue(Game.isWin("KERTAS","BATU"))

        Assert.assertFalse(Game.isWin("BATU","KERTAS"))
        Assert.assertFalse(Game.isWin("GUNTING","BATU"))
        Assert.assertFalse(Game.isWin("KERTAS","GUNTING"))
    }
}
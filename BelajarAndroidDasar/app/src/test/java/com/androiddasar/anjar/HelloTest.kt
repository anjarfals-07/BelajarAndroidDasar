package com.androiddasar.anjar

import org.junit.Assert
import org.junit.Test

class HelloTest {
    @Test
    fun testSayHello() {
        var result= Hello.sayHello("Anjar")

        Assert.assertEquals("Hello Anjar", result)
    }
}
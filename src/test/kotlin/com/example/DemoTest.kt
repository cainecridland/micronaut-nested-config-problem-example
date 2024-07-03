package com.example
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class DemoTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    lateinit var configuration: Configuration

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun testLevelOneObject() {
        println(configuration.levelOne) //proves it's set
    }

    @Test
    fun testLevelOneValue() {
        assert(configuration.levelOne.levelOneValue == "ONE")
        println(configuration.levelOne.levelOneValue)
    }

    @Test
    fun testLevelTwoObject() {
        println(configuration.levelOne.levelTwo) //proves it's set
    }

    @Test
    fun testLevelTwoValue() {
        assert(configuration.levelOne.levelTwo.levelTwoValue == "TWO")
        println(configuration.levelOne.levelTwo.levelTwoValue)
    }


}

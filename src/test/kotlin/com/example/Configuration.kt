package com.example

import io.micronaut.context.annotation.ConfigurationProperties
import jakarta.inject.Inject

@ConfigurationProperties("product-aggregator")
class Configuration {
    @Inject internal var levelOne = LevelOne()
    @ConfigurationProperties("level-one")
    internal class LevelOne {
        internal lateinit var levelOneValue: String
        @Inject internal var levelTwo = LevelTwo()
        @ConfigurationProperties("level-two")
        internal class LevelTwo {
            lateinit var levelTwoValue: String
        }
    }
}
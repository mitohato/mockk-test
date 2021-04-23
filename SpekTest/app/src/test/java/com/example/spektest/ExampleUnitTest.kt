package com.example.spektest

import com.google.common.truth.Truth
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

class ExampleUnitTest : Spek({
    Feature("Example") {
        val interfaceForTarget by memoized { mockk<InterfaceForTarget>() }
        val target by memoized { Target(interfaceForTarget) }
        Scenario("test") {
            var result: Int? = null
            val expect = 10
            Given("return 5") {
                every {
                    interfaceForTarget.getValue()
                } returns 5
            }
            When("execute()") {
                result = target.execute()
            }
            Then("same value") {
                Truth.assertThat(result).isEqualTo(expect)
            }
            Then("call getValue") {
                verify {
                    interfaceForTarget.getValue()
                }
            }
        }
    }
})

interface InterfaceForTarget {
    fun getValue(): Int
}

class Target(
    private val interfaceForTarget: InterfaceForTarget
) {
    fun execute(): Int = interfaceForTarget.getValue() * 2
}

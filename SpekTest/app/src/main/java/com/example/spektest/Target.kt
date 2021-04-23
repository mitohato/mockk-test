package com.example.spektest

class Target(
    private val interfaceForTarget: InterfaceForTarget
) {
    fun execute(): Int {
        return interfaceForTarget.getValue() * 2
    }
}
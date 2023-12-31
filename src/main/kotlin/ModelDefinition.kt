package org.example

import org.jetbrains.kotlinx.dl.api.core.Sequential
import org.jetbrains.kotlinx.dl.api.core.layer.core.Dense
import org.jetbrains.kotlinx.dl.api.core.layer.core.Input
import org.jetbrains.kotlinx.dl.api.core.layer.reshaping.Flatten

fun createModel(): Sequential {
    return Sequential.of(
        Input(28, 28, 1),
        Flatten(),
        Dense(300),
        Dense(100),
        Dense(10)
    )
}

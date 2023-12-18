package org.example

fun main() {
    val model = createModel()
    trainAndEvaluateModel(model)

    // You can add additional code here if you want to make predictions
    // immediately after training. Otherwise, use ModelInference.kt for inference.
}

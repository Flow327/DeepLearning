package org.example

import org.jetbrains.kotlinx.dl.api.inference.TensorFlowInferenceModel
import org.jetbrains.kotlinx.dl.dataset.embedded.fashionMnist
import java.io.File

fun main() {
    val (train, test) = fashionMnist()

    TensorFlowInferenceModel.load(File("model/my_model")).use { model ->
        val prediction = model.predict(test.getX(0))
        val actualLabel = test.getY(0)

        println("Predicted label is: $prediction. This corresponds to class ${stringLabels[prediction]}.")
        println("Actual label is: $actualLabel.")
    }
}

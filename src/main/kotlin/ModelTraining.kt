package org.example

import java.io.File
import org.jetbrains.kotlinx.dl.api.core.Sequential
import org.jetbrains.kotlinx.dl.api.core.WritingMode
import org.jetbrains.kotlinx.dl.api.core.loss.Losses
import org.jetbrains.kotlinx.dl.api.core.metric.Metrics
import org.jetbrains.kotlinx.dl.api.core.optimizer.Adam
import org.jetbrains.kotlinx.dl.dataset.embedded.fashionMnist


fun trainAndEvaluateModel(model: Sequential) {
    val (train, test) = fashionMnist()

    model.use {
        it.compile(
            optimizer = Adam(),
            loss = Losses.SOFT_MAX_CROSS_ENTROPY_WITH_LOGITS,
            metric = Metrics.ACCURACY
        )

        it.fit(
            dataset = train,
            epochs = 10,
            batchSize = 100
        )

        val accuracy = it.evaluate(dataset = test, batchSize = 100).metrics[Metrics.ACCURACY]
        println("Accuracy: $accuracy")

        it.save(File("model/my_model"), writingMode = WritingMode.OVERRIDE)
    }
}

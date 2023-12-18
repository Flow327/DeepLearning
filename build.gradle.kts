plugins {
    kotlin("jvm") version "1.9.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-tensorflow:0.6.0-alpha-1")
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-onnx:0.6.0-alpha-1")
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-visualization:0.6.0-alpha-1")
    implementation("org.slf4j:slf4j-simple:1.7.30")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
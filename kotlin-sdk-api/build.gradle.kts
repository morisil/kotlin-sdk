import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.dokka)
    alias(libs.plugins.jreleaser)
    alias(libs.plugins.atomicfu)
    `maven-publish`
}

kotlin {

    jvm {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_17
        }
    }

    explicitApi = ExplicitApiMode.Strict

    jvmToolchain(21)

    sourceSets {

        commonMain {
            dependencies {
                api(libs.kotlinx.serialization.json)
                implementation(libs.kotlin.logging)
            }
        }

    }

    js {
        browser()
        nodejs()
        binaries.library()
    }

    wasmJs {
        browser()
        nodejs()
        //d8()
        binaries.library()
    }

//    wasmWasi {
//        nodejs()
//        binaries.library()
//    }

    // native, see https://kotlinlang.org/docs/native-target-support.html
    // tier 1
    macosX64()
    macosArm64()
    iosSimulatorArm64()
    iosX64()
    iosArm64()

    // tier 2
    linuxX64()
    linuxArm64()
    watchosSimulatorArm64()
    watchosX64()
    //watchosArm32()
    watchosArm64()
    tvosSimulatorArm64()
    tvosX64()
    tvosArm64()

    // tier 3
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX86()
    androidNativeX64()
    mingwX64()
    // can be enabled once it is released in BigNum
    //watchosDeviceArm64()
}

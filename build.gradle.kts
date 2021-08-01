plugins {
    id("org.jetbrains.kotlin.js") version "1.5.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("io.arrow-kt:arrow-core:1.0.0-SNAPSHOT")
    implementation("io.arrow-kt:arrow-optics:1.0.0-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.0.0-SNAPSHOT")
    testImplementation(kotlin("test-common"))
    testImplementation(kotlin("test-annotations-common"))
}

kotlin {
    js {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}

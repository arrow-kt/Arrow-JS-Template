plugins {
  kotlin("js") version "1.6.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-js"))
  implementation("io.arrow-kt:arrow-core:1.0.1")
  implementation("io.arrow-kt:arrow-optics:1.0.1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
  implementation("io.arrow-kt:arrow-fx-coroutines:1.0.1")

  testImplementation("io.kotest:kotest-property:5.2.2")
  testImplementation("io.kotest:kotest-assertions-core:5.2.2")
  testImplementation("io.kotest.extensions:kotest-assertions-arrow:1.2.4")
  testImplementation("io.kotest.extensions:kotest-property-arrow:1.2.4") // optional
  testImplementation("io.kotest.extensions:kotest-property-arrow-optics:1.2.4") // optional
}

kotlin {
  js(IR) {
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

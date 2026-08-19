plugins {
  kotlin("js") version "2.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-js"))
  implementation("io.arrow-kt:arrow-core:2.2.3")
  implementation("io.arrow-kt:arrow-optics:2.2.3")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
  implementation("io.arrow-kt:arrow-fx-coroutines:2.2.3")

  testImplementation("io.kotest:kotest-property:6.2.4")
  testImplementation("io.kotest:kotest-assertions-core:6.2.4")
  testImplementation("io.kotest.extensions:kotest-assertions-arrow:2.0.0")
  testImplementation("io.kotest.extensions:kotest-property-arrow:2.0.0") // optional
  testImplementation("io.kotest.extensions:kotest-property-arrow-optics:2.0.0") // optional
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

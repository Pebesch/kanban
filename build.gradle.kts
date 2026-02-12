import net.ltgt.gradle.errorprone.CheckSeverity
import net.ltgt.gradle.errorprone.errorprone

plugins {
    id("java")
    id("idea")
    alias(libs.plugins.errorprone) apply false
    alias(libs.plugins.spotless) apply false
}

group = "ch.schmucki"
version = "0.0.1-SNAPSHOT"
description = "kanban"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "net.ltgt.errorprone")
    apply(plugin = "com.diffplug.spotless")

    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        java {
            googleJavaFormat("1.34.1")
            importOrder()
            removeUnusedImports()
            trimTrailingWhitespace()
            endWithNewline()
        }
    }

    dependencies {
        testImplementation(rootProject.libs.junit.jupiter)
        testRuntimeOnly(rootProject.libs.junit.platform.launcher)
        "errorprone"(rootProject.libs.errorprone.core)
        "errorprone"(rootProject.libs.nullaway)
        implementation(rootProject.libs.jspecify)
    }

    tasks.test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    tasks.withType<JavaCompile>().configureEach {
        options.errorprone {
            check("NullAway", CheckSeverity.ERROR)
            option("NullAway:AnnotatedPackages", "com.uber")
        }

        if (name.lowercase().contains("test")) {
            options.errorprone {
                disable("NullAway")
            }
        }
    }
}
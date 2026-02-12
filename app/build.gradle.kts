plugins {
    alias(libs.plugins.dependency.management)
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation(project(":core"))
    implementation(project(":web"))
    implementation(project(":service"))
    implementation(project(":repository"))
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.data.jpa)
    testImplementation(libs.spring.boot.starter.test)
    developmentOnly(libs.spring.boot.devtools)
    runtimeOnly(libs.h2)
    implementation(libs.spring.boot.h2.console)
}
plugins {
    alias(libs.plugins.dependency.management)
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation(project(":backend:core"))
    implementation(project(":backend:web"))
    implementation(project(":backend:service"))
    implementation(project(":backend:repository"))
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.data.jpa)
    testImplementation(libs.spring.boot.starter.test)
    developmentOnly(libs.spring.boot.devtools)
    runtimeOnly(libs.h2)
    implementation(libs.spring.boot.h2.console)
}
dependencies {
    implementation(project(":repository"))
    implementation(project(":service"))
    implementation(project(":core"))
    implementation(libs.spring.core)
    implementation(libs.spring.context)
    implementation(libs.spring.web)
}

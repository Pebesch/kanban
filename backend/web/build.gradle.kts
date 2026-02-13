dependencies {
    implementation(project(":backend:repository"))
    implementation(project(":backend:service"))
    implementation(project(":backend:core"))
    implementation(libs.spring.core)
    implementation(libs.spring.context)
    implementation(libs.spring.web)
}

dependencies {
    api(libs.spring.boot.starter.data.jpa)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    implementation(project(":backend:core"))
}
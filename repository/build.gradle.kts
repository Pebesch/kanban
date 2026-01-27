dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa:4.0.1")
    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
    implementation(project(":core"))
}
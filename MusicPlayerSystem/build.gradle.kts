plugins {
    id("java")
    id("org.springframework.boot") version "3.3.2" // latest Spring Boot
    id("io.spring.dependency-management") version "1.1.3" // for managing versions
}

group = "org.example"
version = "1.0-SNAPSHOT"
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Starter Web for REST APIs
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Lombok for annotations like @RequiredArgsConstructor, @Getter, @Setter
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")

    // Testing dependencies
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

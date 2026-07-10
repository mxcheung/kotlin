plugins {
    kotlin("jvm") version "2.3.21"
    application
}

group = "com.example.inventory"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass.set("com.example.inventory.MainKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("resolveAllDependencies") {
    doLast {
        configurations.filter { it.isCanBeResolved }.forEach { config ->
            try { config.resolve() } catch (_: Exception) {}
        }
    }
}

kotlin {
    jvmToolchain(25)
}

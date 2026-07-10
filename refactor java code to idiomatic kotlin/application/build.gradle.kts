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
    testImplementation(kotlin("reflect"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

sourceSets {
    create("validation") {
        kotlin.srcDir("src/validation/kotlin")
        // Validation tests read source files as text — no dependency on compiled main output,
        // so this source set can run even when main fails to compile (e.g., between Task 2.1 and 2.2).
    }
}

configurations["validationImplementation"].extendsFrom(configurations["testImplementation"])

val validationTest by tasks.registering(Test::class) {
    description = "Runs platform validation checks."
    group = "verification"
    testClassesDirs = sourceSets["validation"].output.classesDirs
    classpath = sourceSets["validation"].runtimeClasspath
    useJUnitPlatform()
    workingDir = projectDir
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

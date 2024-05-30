plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
}

val graalVMVersion: String = "23.1.2"

dependencies {
    implementation("org.graalvm.polyglot:polyglot:$graalVMVersion")
    implementation("org.graalvm.polyglot:python-community:$graalVMVersion")
}

group = "io.github.svbgabriel"
version = "1.0.0"
description = "hello-world-py"

java.sourceCompatibility = JavaVersion.VERSION_21

application {
    mainClass.set("io.github.svbgabriel.HelloWorldPY")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

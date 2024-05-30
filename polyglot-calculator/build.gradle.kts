plugins {
    java
    application
    id("org.graalvm.buildtools.native") version "0.9.28"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
}

val graalVMVersion: String = "23.1.2"

dependencies {
    implementation("org.graalvm.polyglot:polyglot:$graalVMVersion")
    implementation("org.graalvm.polyglot:js-community:$graalVMVersion")
}

group = "io.github.svbgabriel"
version = "1.0.0"
description = "polyglot-calculator"

java.sourceCompatibility = JavaVersion.VERSION_21

application {
    mainClass.set("io.github.svbgabriel.Calculator")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

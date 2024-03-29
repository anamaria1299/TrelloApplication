/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/5.5.1/userguide/tutorial_java_projects.html
 */

plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application
    application

    //SpringBoot Application
    id("org.springframework.boot") version "2.1.7.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:27.1-jre")
    implementation(kotlin("stdlib"))

    // Use JUnit test framework
    testImplementation("junit:junit:4.12")

    //SpringBoot dependency
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtime("org.springframework.boot:spring-boot-starter-tomcat")

    //JWT
    implementation("io.jsonwebtoken:jjwt:0.6.0")

    //Mongo DB
    compile("org.springframework.boot:spring-boot-starter-data-mongodb")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}


application {
    // Define the main class for the application
    mainClassName = "edu.escuelaing.ieti.App"
}

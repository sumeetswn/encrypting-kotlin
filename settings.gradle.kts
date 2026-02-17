rootProject.name = "encrypting-kotlin"
pluginManagement {
    val kotlinVersion: String by settings
    val dokkaVersion: String by settings
    val nexusVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("org.jetbrains.dokka") version dokkaVersion
        id("io.github.gradle-nexus.publish-plugin") version nexusVersion
        `maven-publish`
        signing
    }

    val ossrhUsername = providers.gradleProperty("ossrhUsername").getOrElse("")
    val ossrhPassword = providers.gradleProperty("ossrhPassword").getOrElse("")
    extra.set("ossrhUsername", ossrhUsername)
    extra.set("ossrhPassword", ossrhPassword)
}

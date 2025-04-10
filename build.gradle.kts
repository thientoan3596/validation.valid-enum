plugins {
    `java-library`
    `maven-publish`
}
group = project.findProperty("group")?.toString() ?: "com.github.thientoan3596"
version = project.findProperty("version")?.toString() ?: "1.0.0-SNAPSHOT"
repositories {
    mavenCentral()
}
dependencies {
    api("jakarta.validation:jakarta.validation-api:3.0.2")
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
    }
}
val sourcesJar by tasks.registering(Jar::class) {
    archiveBaseName.set(rootProject.name)
    archiveVersion.set(project.version.toString())
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}
tasks.register<Jar>("releaseJar"){
    archiveBaseName.set(rootProject.name)
    archiveVersion.set(project.version.toString())
    from(sourceSets.main.get().output)
    finalizedBy(sourcesJar) 
    doLast {
        println(archiveFile.get().asFile.absolutePath)
        println(sourcesJar.get().archiveFile.get().asFile.absolutePath)
    }
}

tasks.register("version") {
    doLast {
        println(project.version)
    }
}
tasks.register("name") {
     doLast {
        println(rootProject.name)
    }
}
tasks.register("file"){
    doLast {
        println("${rootProject.name}-${project.version}")
    }
}
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}

plugins {
    kotlin("jvm") version "1.5.21"
}

group = "com.xiaoyv"
version = "1.1"

repositories {
    maven {
       setUrl("https://maven.aliyun.com/repository/public/")
    }
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.qiniu:qiniu-java-sdk:7.8.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.5.21")
}

tasks.test {
    useJUnit()
}

tasks.jar {
    manifest {
        attributes["Manifest-Version"] = 1.0
        attributes["Main-Class"] = "com.xiaoyv.utilcode.util.Utils"
    }
}
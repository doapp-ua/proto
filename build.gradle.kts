plugins {
    id("root.publication")
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.serialization) apply false
    `maven-publish`
}

//afterEvaluate {
//    publishing {
//        publications {
//            create<MavenPublication>("maven") {
//                from (components["proto"])
//                groupId = "com.doapp.proto"
//                artifactId = "proto"
//                version = "1.0"
//            }
//        }
//    }
//}
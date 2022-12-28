plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
apply("$rootDir/gradle/libmodule.gradle")

dependencies {
    implementation(project(":shared:common"))

}

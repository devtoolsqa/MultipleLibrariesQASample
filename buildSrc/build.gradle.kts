plugins {
    `kotlin-dsl`
}

dependencies {
    // these are needed for gradle plugin development
    implementation(gradleApi())
    implementation(localGroovy())
}

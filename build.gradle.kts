import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.kotlin.dsl.withType

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.dagger.hilt) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.android.library) apply false
}

// Add Detekt configuration to point to our config file
// This tells the Detekt plugin to use the custom config we added under config/detekt/detekt.yml
// and to build upon the default config so rules not overridden keep their defaults.
subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    tasks.withType<Detekt>().configureEach {
        config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
        parallel = true
        autoCorrect = true
        buildUponDefaultConfig = true
        setSource(files("src/main/java", "src/main/kotlin"))
        reports {
            html.required.set(true)
//            html.outputLocation.set(layout.buildDirectory.file("reports/detekt/${project.name}.html"))
            xml.required.set(false)
            txt.required.set(false)
            sarif.required.set(false)
            md.required.set(false)
        }
    }
}

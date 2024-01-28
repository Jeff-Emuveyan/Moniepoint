pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Moniepoint"
include(":app")
include(":feature")
include(":feature:home")
include(":feature:shipment")
include(":feature:calculate")
include(":core")

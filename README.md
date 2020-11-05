# jfx-utils

A kotlin/java library of JavaFX Utilities and common code

    * Common Dialogs
    * JavaFX utility functions


# Build

* Create a local properties file (for JFX configuration) in **<repo>/local.properties**. A sample local.properties:

        JFX_VERSION=14.0.1
        JFX_PATH=/Library/Java/javafx/14.0.1


Then run

    gradlew build

# Deploy

The library is not yet available in any central Maven repository, until people request it.

        gradlew publishToMavenLocal 

### Limitations
* Uses log4j for logging for now
* Not available in Maven repositories

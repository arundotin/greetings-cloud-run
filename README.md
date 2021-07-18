# Greetings for Cloud Run

This Greetings API is written in Java with Micronaut. This can be execute on JVM as well. But here to find the speed, am using GraalVM

## Install SDKMAN

* Simply open a new terminal and enter:
`$ curl -s https://get.sdkman.io | bash`

* Follow the on-screen instructions to complete installation.
* Open a new terminal or type the command:

`$ source "$HOME/.sdkman/bin/sdkman-init.sh"`

## Install Graal VM

`$ sdk install java 21.1.0.r11-grl`

You need to install the native-image component which is not installed by default.

`$ gu install native-image`

## Run Gradle task for Local

`./gradlew nativeImage`

## Build for GCP Cloud Run

`gcloud builds submit --tag gcr.io/[PROJECT-ID]/hello-world --timeout 30m`
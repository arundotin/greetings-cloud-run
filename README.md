# Greetings for Cloud Run

This Greetings API is written in Java with Micronaut. This can be execute on JVM as well. But here to experience the speed in Cloudrun, am using GraalVM to build a native image and would deploy this container in my cloud-run

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

`gcloud builds submit --tag gcr.io/[PROJECT-ID]/greetings-cloud-run --timeout 30m --machine-type=N1_HIGHCPU_8`

> Note : Any machine type lesser than this will not build the native image



`gcloud beta run deploy --image gcr.io/[PROJECT ID]/greetings-cloud-run`

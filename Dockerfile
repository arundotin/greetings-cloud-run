# Stage 1: Build the JAR
FROM gradle:jdk11 as gradle
COPY --chown=gradle . /home/app
WORKDIR /home/app
RUN gradle assemble --no-daemon

# Stage 2: Build the native image
FROM ghcr.io/graalvm/graalvm-ce:latest as graalvm
RUN \
    # Install GraalVM Native Image
    gu install native-image;
COPY --from=gradle /home/app/build/libs/greetings-cloud-run-0.1-all.jar /home/app/server.jar
WORKDIR /home/app
RUN native-image -H:Name=greetings-cloud-run --no-server -cp server.jar com.arun.Application
EXPOSE 8080
ENTRYPOINT ["./greetings-cloud-run"]
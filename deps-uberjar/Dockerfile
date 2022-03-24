# No need for any clojure deps since the uberjar has already been built
FROM openjdk:17
WORKDIR /

# Note the very tight .dockerignore which only exposes target/my-project.jar
# to the build context.
COPY target/my-project.jar /

CMD java -cp my-project.jar clojure.main -m my-project.main
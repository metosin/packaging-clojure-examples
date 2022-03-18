# Uberjar

Building:

```
lein uberjar
```

Running:

```
java -cp target/my-project.jar clojure.main -m my-project.main
```

Browse <http://localhost:3333>

# Docker

After building the uberjar, package it into a docker container with:

```
docker build -t my-project:lein-uberjar .
```

Running the container:

```
docker run --network host --rm -d --name my-project my-project:lein-uberjar
```

Browse <http://localhost:3333>

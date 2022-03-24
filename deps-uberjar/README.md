# Contents

- [deps.edn](deps.edn) - backend & frontend dependencies
- [shadow-cljs.edn](shadow-cljs.edn) – the shadow-cljs configuration. Uses paths & deps from `deps.edn`.
- [build.clj](build.clj) - the tools.build script
- [Dockerfile](Dockerfile)

# Uberjar

Building:

```
clj -T:shadow-cljs:build uberjar
```

Running:

```
java -cp target/my-project.jar clojure.main -m my-project.main
```

Browse <http://localhost:3333>

# Docker

After building the uberjar, package it into a docker container with:

```
docker build -t my-project:deps-uberjar .
```

Running the container:

```
docker run --network host --rm -d --name my-project my-project:deps-uberjar
```

Browse <http://localhost:3333>

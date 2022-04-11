# Contents

- [deps.edn](deps.edn) – backend & frontend dependencies
- [shadow-cljs.edn](shadow-cljs.edn) – the shadow-cljs configuration. Uses paths & deps from `deps.edn`.
- [package.json](package.json), [package-lock.json](package-lock.json) - JS deps (react)
- [Dockerfile.backend-only](Dockerfile.backend-only) – a Dockerfile that builds a backend-only container
- [Dockerfile](Dockerfile) – a two-stage Dockerfile that builds the frontend in stage 1, and builds & runs the backend in stage 2

# Docker container with only backend

Building:

```
docker build -t my-project:backend-only -f Dockerfile.backend-only .
```

Running, testing and killing:

```
docker run -p 127.0.0.1:3333:3333 --rm -d --name my-project my-project:backend-only
curl localhost:3333/api/ping
docker kill my-project
```

# Docker container with frontend and backend

Building:

```
docker build -t my-project:latest .
```

Running, testing and killing:

```
docker run -p 127.0.0.1:3333:3333 --rm -d --name my-project my-project:latest
```

Browse <http://localhost:3333>

```
docker kill my-project
```

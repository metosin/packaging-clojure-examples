# Docker

```
docker build -t my-project:backend-only -f Dockerfile.backend-only .
docker run --network host --rm -d --name my-project my-project:backend-only
curl localhost:3333/api/ping
docker kill my-project
```

```
docker build -t my-project:latest .
docker run --network host --rm -d --name my-project my-project:latest
```

Browse <http://localhost:3333>

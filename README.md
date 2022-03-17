# Docker

```
docker build -t my-project:backend-only -f Dockerfile.backend-only .
docker run --network host --rm -d --name my-project my-project:backend-only
curl localhost:3333/api/ping
```

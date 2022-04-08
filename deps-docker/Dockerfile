### Stage 1: build frontend
FROM clojure:openjdk-17-tools-deps-buster AS build
RUN mkdir /app
WORKDIR /app

# Install npm
RUN curl -fsSL https://deb.nodesource.com/setup_17.x | bash - && apt-get install -y nodejs

# Separate layer for deps: better caching
COPY package.json /app
COPY package-lock.json /app
RUN npm ci

COPY . /app
RUN clojure -M:shadow-cljs release frontend

### Stage 2: run backend
FROM clojure:openjdk-17-tools-deps-buster
RUN mkdir /app
WORKDIR /app
COPY deps.edn /app

# Separate layer for deps: better caching
RUN clojure -P

# Add sources
COPY . /app
# Add frontend build output from previous stage
COPY --from=build /app/built-resources /app

CMD clojure -M -m my-project.main

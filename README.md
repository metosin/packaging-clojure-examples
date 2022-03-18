# Packaging Clojure for Production

Companion repo for this blog post (TODO link).

All the examples have the same resources/ and src/, only the tool
configurations (`project.clj`, `deps.edn`, `Dockerfile`, `shadow-cljs.edn`,
...) vary.

Contents:

- [deps-docker/](deps-docker/) – a deps.edn project packaged directly into a docker image, no uberjar
- [lein/](lein/) – a Leiningen project that builds an uberjar, optionally packaging it inside a docker image

# Packaging Clojure for Production

Companion repo for this [blog post](https://metosin.fi/blog/packaging-clojure/)

All the examples have the same resources/ and src/, only the tool
configurations (`project.clj`, `deps.edn`, `Dockerfile`, `shadow-cljs.edn`,
...) vary.

Contents:

- [deps-docker/](deps-docker/) – a deps.edn project packaged directly into a docker image, no uberjar
- [deps-uberjar/](deps-uberjar/) - a deps.edn project that builds an uberjar, optionally packagint it inside a docker image
- [lein/](lein/) – a Leiningen project that builds an uberjar, optionally packaging it inside a docker image

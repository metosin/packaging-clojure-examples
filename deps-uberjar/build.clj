(ns build
  (:require [shadow.cljs.devtools.api :as shadow]
            [clojure.tools.build.api :as b]))

(def version "0.0.1-SNAPSHOT")
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def uber-file "target/my-project.jar")

(defn clean [_]
  (b/delete {:path "target"}))

(defn uberjar [_]
  (clean nil)
  (b/copy-dir {:src-dirs ["src/clj" "resources"]
               :target-dir class-dir})
  ;; This would be needed for AOT compilation:
  #_
  (b/compile-clj {:basis basis
                  :src-dirs ["src"]
                  :class-dir class-dir})
  ;; Build frontend:
  (shadow/release :frontend) ; will output to target/classes/public/js
  (b/uber {:class-dir class-dir
           :uber-file uber-file
           :basis basis})
  (println "Uberjar:" uber-file))

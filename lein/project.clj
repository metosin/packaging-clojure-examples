(defproject my-project "0.0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [metosin/reitit "0.5.16"]
                 [ring/ring-jetty-adapter "1.9.5"]]
  :source-paths ["src/clj"]
  ;; Figwheel-main puts temporary files in target/public, but we've
  ;; configured it to put the final frontend.js in
  ;;   target/resources/public/js/frontend.js
  ;; Now when we add target/resources to the class path, we won't get
  ;; any extra stuff in our uberjar.
  :resource-paths ["resources" "target/resources"]
  :aliases {"fig" ["with-profile" "cljs" "run" "-m" "figwheel.main"]}
  :profiles {:cljs {:source-paths ["src/cljs"]
                    :dependencies [[com.bhauman/figwheel-main "0.2.16"]
                                   [org.clojure/clojurescript "1.11.4"]
                                   [reagent/reagent "1.1.0"]
                                   [lambdaisland/fetch "1.0.41"]
                                   [cljsjs/react "17.0.2-0"]
                                   [cljsjs/react-dom "17.0.2-0"]]}
             :uberjar {:prep-tasks [["fig" "--" "--build-once" "prod"]
                                    ;; This would be needed for AOT compilation:
                                    #_"compile"]
                       :uberjar-name "my-project.jar"
                       ;; AOT can speed up startup a bit, but complicates the build
                       :aot []}})

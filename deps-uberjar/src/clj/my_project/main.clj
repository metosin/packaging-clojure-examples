(ns my-project.main
  (:require [reitit.ring :as ring]
            [ring.adapter.jetty :as jetty]))

(def app
  (ring/ring-handler
   (ring/router
    ["/api"
     ["/ping" {:get {:handler (fn [_]
                                {:status 200
                                 :body "pong"})}}]])
   (ring/routes
    (ring/create-resource-handler {:path "/" :root "public"}) ;; serve index.html and built js
    (ring/create-default-handler))))

(defn -main []
  (println "Starting server on http://localhost:3333")
  (jetty/run-jetty app {:port 3333}))

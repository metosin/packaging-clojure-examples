(ns my-project.frontend
  (:require [lambdaisland.fetch :as fetch]
            [reagent.core :as r]
            [reagent.dom :as rdom]))

(def state (r/atom {}))

(defn app []
  [:<>
   [:h1 "Frontend"]
   [:span "Response from backend:" (pr-str (get @state :pong))]])

(defn ping! []
  (-> (fetch/get "/api/ping")
      (.then (fn [resp]
               (swap! state assoc :pong (:body resp))))))

(defn init []
  (ping!)
  (rdom/render
   [app]
   (.getElementById js/document "frontend")))

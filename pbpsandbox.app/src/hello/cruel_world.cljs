(ns hello.cruel-world
  (:require [reagent.core :as r]))

(defn what-kind? []
  "Cruelerr")

(defonce c (r/atom 1))

(defn simple-component []
  [:div
   [:p "I am a commponent!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} (str " and  counter " @c)] " text."]])


(defn run []
  (r/render [simple-component]
            (js/document.getElementById "app")))

(run)


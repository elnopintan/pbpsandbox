(ns pbpsandbox.core
  (:require [reagent.core :as r]
            [firebase :as f]
            [firebase.app :as fapp]
            [firebase.auth :as fauth]
            [pbpsandbox.fbconfig :refer [conf]]))

(defn what-kind? []
  "Cruelerr")

(defonce c (r/atom 1))
(defonce fb-app (atom false))

(defn initialize-fb []
  (if (not @fb-app)
    (do
      (js/console.log @fb-app)
      (f/initializeApp conf)
      (swap! fb-app (fn [] true))
      (js/console.log @fb-app)))
  (defonce provider (fauth/GoogleAuthProvider. )))

(defn auth []
  (-> (f/auth)
      (.signInWithPopup provider)
      (.then #(js/console.log (.-user %)))))

(defn simple-component []
  [:div
   [:p "I am a commponent!"]
   [:div {:class "mdl-card__supporting-text mdl-color-text--grey-600"}
    [:button {:class "mdl-button mdl-js-button mdl-button--raised" :id "quickstart-sign-in" :onClick #(auth)} "Sign in with Google"]]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "blue"}} (str " and  counter " @c)] " text."]])


(defn run []
  (initialize-fb)
  (r/render [simple-component]
            (js/document.getElementById "app")))

(run)


(ns clj-site.layout
  (:require [hiccup.page :refer [html5]]
            [optimus.link :as link]))

(def default-title "Korny's clojure pages")

(defn layout-page [page request & {:keys [title] :or {title default-title}}]
  (html5
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:name "viewport"
             :content "width=device-width, initial-scale=1.0"}]
     [:title title]
     [:link {:rel "stylesheet" :href (link/file-path request "/styles/main.css")}]]
    [:body
     ;[:div.logo "cjohansen.no"]
     [:div.body page]]))

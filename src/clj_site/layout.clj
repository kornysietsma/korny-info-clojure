(ns clj-site.layout
  (:require [hiccup.page :refer [html5]]
            [optimus.link :as link]))

(def default-title "Korny's Clojure info site")

(def fonts [
             "http://fonts.googleapis.com/css?family=Cousine:400,700,400italic,700italic&subset=latin,latin-ext"
             "http://fonts.googleapis.com/css?family=Vollkorn:400italic,700italic,400,700', :rel => 'stylesheet"
             ;"http://fonts.googleapis.com/css?family=Playfair+Display:400,700,900,400italic,700italic,900italic"
             ])

(defn layout-page [page request & {:keys [title] :or {title default-title}}]
  (html5
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:name "viewport"
             :content "width=device-width, initial-scale=1.0"}]
     [:meta {:content "IE=edge,chrome=1" :http-equiv "X-UA-Compatible"}]
     [:title title]
     [:link {:rel "icon" :href "/favicon.ico" :type "image/ico"}]
     [:link {:rel "shortcut" :href "/favicon.ico" :type "image/ico"}]
     (for [font fonts]
       [:link {:rel "stylesheet" :href font}])
     [:link {:rel "stylesheet" :href (link/file-path request "/styles/site.scss")}]]
    [:body
     [:section.container
      [:header [:h1 [:a {:href "/"} "Korny's Clojure info site"]]]
      page]]))

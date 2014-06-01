(ns clj-site.pages
  (:require [hiccup.page :refer [html5]]
            [stasis.core :as stasis]
            [optimus.link :as link]
            [clj-site.layout :as layout]
            [me.raynes.cegdown :as md]))

(def pegdown-options ;; https://github.com/sirthias/pegdown
  [:autolinks :fenced-code-blocks :strikethrough])

(defn partial-pages [pages]
  (into {}
        (for [[title page] pages]
          [title
           (partial layout/layout-page page)])))

(defn markdown-pages [pages]
  (into {}
        (for [[title page] pages]
          [(clojure.string/replace title #"\.md$" "")
           (partial layout/layout-page (md/to-html page pegdown-options))])))

(defn get-partial-pages []
  (partial-pages (stasis/slurp-directory "resources/partials" #".*\.html$")))

(defn get-markdown-pages []
  (markdown-pages (stasis/slurp-directory "resources/md" #"\.md$")))
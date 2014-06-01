(ns clj-site.pages
  (:require [hiccup.page :refer [html5]]
            [stasis.core :as stasis]
            [optimus.link :as link]
            [clj-site.layout :as layout]
            [me.raynes.cegdown :as md]))

(def pegdown-options ;; https://github.com/sirthias/pegdown
  [:autolinks :fenced-code-blocks :strikethrough])

(defn partial-pages [pages]
  (zipmap (keys pages)
          (map #(fn [req] (layout/layout-page req %)) (vals pages))))

(defn markdown-pages [pages]
  (zipmap (map #(clojure.string/replace % #"\.md$" "") (keys pages))
          (map #(fn [req] (layout/layout-page req (md/to-html % pegdown-options))) (vals pages))))

(defn get-partial-pages []
  (partial-pages (stasis/slurp-directory "resources/partials" #".*\.html$")))

(defn get-markdown-pages []
  (markdown-pages (stasis/slurp-directory "resources/md" #"\.md$")))
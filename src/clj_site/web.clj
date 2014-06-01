(ns clj-site.web
  (:require [ring.middleware.content-type :refer [wrap-content-type]]
            [stasis.core :as stasis]
            [optimus.prime :as optimus]
            [optimus.assets :as assets]
            [optimus.export]
            [hiccup.page :refer [html5]]
            [optimus.optimizations :as optimizations]
            [optimus.strategies :refer [serve-live-assets]]
            [clj-site.pages :as pages]
            [clj-site.highlight :refer [highlight-code-blocks]]))

(defn get-assets []
  (assets/load-assets "public" [#"/styles/.*\.css"
                               ;#"/images/.*"
                               ; #"/scripts/.*\.js"
                                ]))

(defn prepare-page [page req]
  (-> (if (string? page) page (page req))
      highlight-code-blocks))

(defn prepare-pages [pages]
  (zipmap (keys pages)
          (map #(partial prepare-page %) (vals pages))))

(defn get-raw-pages []
  (stasis/merge-page-sources
    {:partials (pages/get-partial-pages)
     :markdown (pages/get-markdown-pages)
     :public (stasis/slurp-directory "resources/public" #".*\.html$")}))

(defn get-pages []
  (prepare-pages (get-raw-pages)))

(def optimize optimizations/all)

(def app (-> (stasis/serve-pages get-pages)
             (optimus/wrap get-assets optimize serve-live-assets)
             wrap-content-type))

(def export-dir "./dist")

(defn export []
  (let [assets (optimize (get-assets) {})]
    (stasis/empty-directory! export-dir)
    (optimus.export/save-assets assets export-dir)
    (stasis/export-pages (get-pages) export-dir {:optimus-assets assets})))
(defproject clj-site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [stasis "1.1.1"]
                 [ring "1.2.2"]
                 [optimus "0.14.4"]
                 [optimus-sass "0.0.2"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.5"]
                 [clygments "0.1.1"]
                 [me.raynes/cegdown "0.1.1"]
                 [hiccup "1.0.5"]]
  :ring {:handler clj-site.web/app}
  :aliases {"build-site" ["run" "-m" "clj-site.web/export"]}
  :profiles {:dev {:plugins [[lein-ring "0.8.10"]]}})

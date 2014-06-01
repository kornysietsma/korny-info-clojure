#!/bin/bash
set -e
lein build-site
rsync -av --delete dist/ kornyinf@korny.info:~/public_html/clojure/
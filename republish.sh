#!/bin/bash
lein build-site
git add docs
echo "don't forget to commit and push!"

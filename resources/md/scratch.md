# Clojure from scratch

## Reading

A great from-scratch introduction is [aphyr's Clojure from the ground up series](http://aphyr.com/posts/301-clojure-from-the-ground-up-welcome)

A more detailed online book is [Clojure for the Brave and True](http://www.braveclojure.com/)

I'd also recommend digging through the book [Clojure Programming](http://shop.oreilly.com/product/0636920013754.do) - or others on the [bookshelf](/bookshelf) when I've actually written it :)

There is a fair bit of useful background info at http://clojure.org as well.

## Playing

You learn best from doing.  Even if you read one of the above, you should start building stuff as well.  The key things you'll need are:

### A build tool

[Leiningen](http://leiningen.org/) is the build tool for clojure; you can do stuff without it, by hand or via maven or the like, but generally leiningen is your best starting point.  It will download all it's dependencies, including clojure itself.

If you want to play with simple apps, `lein new myproj` will get you going.  Have a look at [the Leiningen tutorial](https://github.com/technomancy/leiningen/blob/stable/doc/TUTORIAL.md) for more.

If you want to play with web apps, take a look at [compojure](https://github.com/weavejester/compojure) - `lein new compojure myproj` will build you a very simple web app for experimentation.

### An editor

You can get away with whatever editor you are comfortable with - as long as it can edit text files and browse directories, you will be able to get started - however there are many with integrated clojure support:

* Intellij Idea + the [Cursive Clojure](https://cursiveclojure.com/) plugin - this is my favourite suggestion for IDE users, especially if you already have Idea.  You can use the free community edition; Cursive is currently free also, though this might change in the future
* If you are an eclipse user then you can use [Counterclockwise](https://code.google.com/p/counterclockwise/) - it's also meant to be excellent, but I haven't tried it myself
* Sublime Text has less support, but it's a popular cross-platform editor that might be good if you don't know any of the others and just want to get started
* [Light Table](http://www.lighttable.com/) is a smart editor written in clojurescript - it's a bit more fiddly to use and configure than the above, but still very useful.  A good power-user editor for those not using emacs!
* Or of course you can use emacs or vim.  Both have exceptionally good clojure support available - especially emacs, as it is lisp-based so clojure is a great match.  Both also have steep learning curves.  I'm an emacs user at heart, but not really going to recommend it on a "from scratch" page!

## Practicing

You can also learn a lot from repetitive exercises (commonly called "Koans") - these are a great way to become fluent in a language.

* [4clojure](https://www.4clojure.com/) is a handy online learning site.  Beware though, the difficulty jumps from "real simple" to "OMGWTFBBQ" - don't be disheartened if one of the problems seems ridiculously hard, just try another problem for a bit.
* There is also http://clojurekoans.com/ - I haven't tried these, but they look good.

And remember to keep the [Clojure cheat sheet](http://jafingerhut.github.io/cheatsheet/grimoire/cheatsheet-tiptip-cdocs-summary.html) handy - and refer to it often!  This is your basic vocabulary of clojure verbs - you want to practice and learn most of them.  More at the [resources](/resources) page.

## Asking for help

The IRC channel #clojure on [freenode](http://freenode.net/) is a great place to ask questions.  You don't even need a client - the [web chat](https://webchat.freenode.net/) seems to work pretty well.

Also the [clojure google group](http://groups.google.com/group/clojure) is very active, and another great place to learn stuff.

## Searching

And, of course, there are all the usual online resources - feel free to google for a problem, or look on [Stack Overflow](http://stackoverflow.com/questions/tagged/clojure) - and it can be educational to dig through [trending repositories on github](https://github.com/trending?l=clojure) as well.

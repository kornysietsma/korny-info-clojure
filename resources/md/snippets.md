# Snippets

This is an unsorted collection of code snippets, mostly from [this blog post](http://blog.korny.info/2014/05/11/snippets.html) - but I intend to add more here, and maybe categorise them.

## Namespaces and main methods

```clj
(ns foo.bar
  (:import [java.net URI URL])
  (:require [clj-http.client :as client :refer [request]]
            [compojure.core :refer :all]) ; prefer this over 'use'
  (:gen-class))  ; if you have a main method to expose

(defn -main
  [& args]
  (println "args:" args))
```

## Midje basics

```clj
(ns foo.t-bar
  (:require [midje.sweet :refer :all]
            [foo.bar :as subject]))  ; or just :refer :all

(facts "about foos"
  (fact "the foo is alive"
    (subject/foo 123) => (just {:foo 123})
    (provided (bar 123) => :foo)))
```

## Midje custom checker

```clj
(defn same-json [expected]
  (fn [actual]
    (= (parse-string actual true) (parse-string expected true))))

; or the same test but better outputs on failure

(defchecker same-json [expected]
  (chatty-checker [actual]
     (= (parse-string actual true) (parse-string expected true))))

(fact "json is similar"
  (slurp "file1.json") => (same-json (slurp "file2.json")))
```

## Destructuring

```clj
(let [[a b & rest :as all]       [:a :b :c :d]
      {e :e [f g] :fg}           {:e "e" :fg ["f" "g"]}
      {:keys [h i] :or {:h "h"}} {:i "i"}]
      ; a is :a, b is :b, e is "e", f is "f", g is "g"
      ; h defaults to "h", i is "i"
      ; rest is [:c :d]
      ; all is [:a :b :c :d]
)

(for [[key val] {:a "a" :b "b" :c "c"}] ... )

; mostly avoid this as the syntax is confusing, but on occasion:
(defn foo [& {:keys [a b] :or {a "foo" b "bar"}]
  (println a b))

; special syntax for passing key/val parameters:
(foo :b "baz") => "foo baz"
```

## Map manipulation

```clojure
(def old-map {:foo :bar, :baz :bat})
(into {}
  (for [[k v] old-map]
    [v k]))  ; or anything that produces a pair
=> {:bar :foo, :bat :baz}
```

see also [algo.generic's fmap function](https://github.com/clojure/algo.generic) if you just want to manipulate values not keys

I've also seen this idiom:

```clj
(zipmap (map keyfn (keys old-map))
        (map valfn (vals old-map)))
```

which generally works, but I'm not sure I see this as any better than the alternative above - and it depends on (keys old-map) and (vals old-map) to be ordered the same, which is true for Clojure maps, but not guaranteed by the Map interface.

## Protocols and Records

```clojure
(defprotocol FooBar
  (buzz [this] "does a buzzy thing"))

(defrecord Widget [hands feet]
  FooBar
  (buzz [this] (str hands feet)))

(buzz (Widget. "ha" "fe"))
=> "hafe"

; same as above but '->Widget' is a first class function
(buzz (->Widget "h" "f"))
=> "hf"

(buzz (map->Widget {:feet "foot"}))
=> "foot"  ; hands is nil

(extend-type Integer
  FooBar
  (buzz [this] (str "buzz:" this)))

(buzz 17)
=> "buzz:17"
```

## Threading

```clojure
(-> x y (z :a) foo)
; same as
(foo (z (y x) :a))

(->> x y (z :a) foo)
; same as
(foo (z :a (y x)))

; need to wrap anonymous fns:
(-> x (#(reverse %)) y)
; same as
(y (#(reverse %) x))

(as-> foo x
      (inc x)
      (* x 3))
; same as
(* (inc foo) 3)

; also can nest as-> inside ->
(-> foo
    inc
    (as-> x
       (foo x bar)
       (baz x)))
```

## Paredit and Cursive

I've mostly moved from emacs to Intellij Idea + [the Cursive plugin](https://cursiveclojure.com/)

I intend to put up a decent cheat sheet for using Cursive's structural mode, which is basically a variant of paredit.  But I'm out of time.  For now, look at the excellent tutorial [on the cursive site](https://cursiveclojure.com/userguide/paredit.html).


(defproject example/lib-a "1.0.0"
  :description "Example library with no internal dependencies."
  :monolith/inherit true

  :pedantic? :abort

  :dependencies
  [[org.clojure/clojure "1.8.0"]]

  :plugins [[lein-monolith "1.0.1" :exclusions [org.clojure/clojure]]]

  :profiles
  {:provided
   {:plugins [[test2junit "1.2.5" :exclusions [org.clojure/clojure]]]}})

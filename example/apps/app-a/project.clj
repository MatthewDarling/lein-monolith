(defproject example/app-a "0.5.0"
  :description "Example project with internal and external dependencies."
  :monolith/inherit true
  :deployable true

  :dependencies
  [[commons-io "2.5"]
   [example/lib-a "1.0.0"]
   [example/lib-b "0.2.0"]
   [org.clojure/clojure "1.8.0"]]

  :plugins [[lein-monolith "1.0.1"]]

  :profiles
  {:shared {:source-paths [~(System/getenv "CONFIG_JAR_PATH")]}
   :dev [:shared
         {:dependencies [[org.clojure/tools.nrepl "0.2.12"]]}]
   :uberjar {;;; Actual :uberjar profile contents
             :dependencies [[metrics-clojure "2.9.0"]]
             ;;; Copied from :shared profile
             :source-paths [~(System/getenv "CONFIG_JAR_PATH")]}})

(ns leiningen.exampleplug
  (:require [leiningen.install :as install]
            [leiningen.core.main :as lmain]
            [robert.hooke :as hooke]))

(defn- once
  [project]
  (lmain/info  "Triggering exampleplug"))

(defn- abort [s]
  (lmain/info s)
  (lmain/abort))

(defn exampleplug
  {}
  ([project]
   (once project)))

(defn exampleplug-hook
  [task & args]
  (once (first args))
  (apply task args))

(defn activate []
  (hooke/add-hook #'install/install #'exampleplug-hook))

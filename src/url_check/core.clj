(ns url-check.core
  (:require [clj-http.client :as client])
  (:gen-class))

(def urls ["http://leiningen.org"
           "https://google.com"
           "https://github.com"
           "http://nope"])

(defn ok [response] (= 200 (:status response)))

;; TODO: Handle exceptions
(defn check-url
  [s]
  (try
    (client/get s {:throw-exceptions false})
    (println (str "[OK] " s))
    (catch Exception _
      (println (str "[KO] " s))))
  )

(defn -main
  [& args]
  (doseq [s urls] (check-url s)))

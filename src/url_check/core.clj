(ns url-check.core
  (:require [clj-http.client :as client])
  (:gen-class))

(def urls ["http://leiningen.org"
           "https://google.com"
           "https://github.com"
           "http://httpstat.us/404"
           "http://nope"])

(defn check-url
  [s]
  (try
    (client/get s)
    (println (str "[OK] " s))
    (catch Exception e
      (println (str "[FAIL] " s " - " (.getMessage e)))))
  )

(defn -main
  [& args]
  (doseq [s urls] (check-url s)))

(ns url-check.core
  (:require [clj-http.client :as client])
  (:gen-class))

(def urls ["http://leiningen.org"
           "https://google.com"
           "https://github.com"
           "http://httpstat.us/404"
           "http://nope"])

(defn check-url
  "Checks a URL. Anything other than a 200-207/300-307 response is considered a failure."
  [url]
  (try
    (client/get url)
    {:url url :status "OK"}
    (catch Exception e
      {:url url :status "FAIL" :message (.getMessage e)})))

(defn filter-status
  "Filters results with the given status. Expects a list of maps."
  [coll status]
  (filter (fn [s] (= (:status s) status)) coll))

(defn -main
  [& args]
  (println "Checking" (count urls) "URLs")
  (let [results (map check-url urls)]
    (println "OK:" (count (filter-status results "OK")))
    (println "Failed:" (count (filter-status results "FAIL")))
    (doseq [x (filter-status results "FAIL")] (println \tab (:url x) (:message x)))))

;; Things to do:
;; Fetch URLs from database
;; Check URLs in parallel
;; Send email with failures

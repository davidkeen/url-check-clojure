(ns url-check.core
  (:require [clj-http.client :as client]
            [url-check.db :as db])
  (:import (java.time LocalDate))
  (:gen-class))

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
  (let [urls (db/urls (.getYear (LocalDate/now)))
        results (map check-url urls)]
    (println "Checking" (count urls) "URLs")
    (println "OK:" (count (filter-status results "OK")))
    (println "Failed:" (count (filter-status results "FAIL")))
    (doseq [x (filter-status results "FAIL")] (println \tab (:url x) (:message x)))))

;; Things to do:
;; Check URLs in parallel
;; Send email with failures

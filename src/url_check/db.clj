(ns url-check.db
  (:require [clojure.java.jdbc :as j]))

(def db {:classname "com.mysql.cj.jdbc.Driver"
         :subprotocol "mysql"
         :subname "//127.0.0.1:3306/clojure_test"
         :user "clojure_test"
         :password "clojure_test"
         :useSSL false})

(defn urls
  [year]
  (j/query db
            ["select url from event where start >= ?" (str year)]
            {:row-fn :url}))


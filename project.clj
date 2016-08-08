(defproject url-check "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.2.0"]
                 [org.clojure/java.jdbc "0.6.2-alpha2"]
                 [mysql/mysql-connector-java "6.0.3"]]
  :main ^:skip-aot url-check.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

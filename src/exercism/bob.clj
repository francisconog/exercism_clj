(ns exercism.bob
  (:require [clojure.string :as str]))

(defn response-for 
  [s]
  
  (let [s (str/trim s)]
    (cond
      (and (= (str/upper-case s) s)
           (str/ends-with? s "?")
           (> (count (str/split s #"(?=[a-zA-Z])")) 1)) "Calm down, I know what I'm doing!"
      (str/ends-with? s "?") "Sure."
      (and (= (str/upper-case s) s)
           (> (count (str/split s #"(?=[a-zA-Z])")) 1)) "Whoa, chill out!"
      (str/blank? s) "Fine. Be that way!"
      :else "Whatever.";
      )))

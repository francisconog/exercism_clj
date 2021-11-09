(ns exercism.log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (-> s
      (str/split #":" 2)
      (get 1)
      (str/trim)))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (cond
    (str/includes? s "ERROR") "error"
    (str/includes? s "WARNING") "warning"
    (str/includes? s "INFO") "info"
    ;:else "None";
    ))

(defn reformat
  "Takes a string representing a log line and formats it
  with the message first and the log level in parentheses."
  [s]
  (let [message (-> s
                    (str/split #":" 2)
                    (get 1)
                    (str/trim))
        log-type (log-level s)]
    (str/join [message " (" log-type ")"]))
  
  )
(ns exercism.acronym)

(defn acronym
  [s]
  ;; your code goes here
  (if (> (count s) 0)
    (->> (clojure.string/split s #"[^a-zA-Z]")
         (mapcat #(clojure.string/split % #"(?<=[a-z])(?=[A-Z])"))
         (map #(get % 0))
         (reduce str)
         clojure.string/upper-case);
    ""))
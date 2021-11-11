(ns exercism.etl
  (:require [clojure.string :as str]))


(defn transform-key-into-val
  [key vals]
  (loop [vs vals
         dict {}]
    (if vs
      (recur (next vs) (assoc dict (str/lower-case (first vs)) key));
      dict)))

(defn transform
  [source]
  (loop [ks (keys source)
         new-scoring {}]
    (if ks
      (let [first-key (first ks)
            first-vals (get source first-key)

            transformed-score (transform-key-into-val first-key first-vals)]
        (recur (next ks) (conj new-scoring transformed-score)))
      new-scoring)
  ;
    ))


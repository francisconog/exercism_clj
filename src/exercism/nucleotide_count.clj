(ns exercism.nucleotide-count
  (:require [clojure.string :as str]))

(defn boolean-to-int
  "Convert boolean true to 1"
  [x]
  (cond
    (true? x) 1
    (false? x) 0
    :else nil))

(defn count-of-nucleotide-in-strand
  [nucleotide strand]
  
  (when (not (some true? (map #(= nucleotide %) [\A \T \C \G])))
    (throw (Throwable. "Invalid nucleotide")))
  
  (let [nucleotide-sequence (re-seq #"[ACGT]" strand)]
    nucleotide-sequence
    (->> nucleotide-sequence
         (map #(boolean-to-int (= (str nucleotide) %)))
         (reduce +))))

(defn update-nucleotide-map
  [nucleotide nucleotide-map value]
  (update nucleotide-map nucleotide + value)
  ;
  )


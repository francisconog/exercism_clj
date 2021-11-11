(ns exercism.hamming)

(defn boolean-to-int
  "Convert boolean true to 1"
  [x]
  (if (true? x) 1 0))

(defn distance
  "Calculate the Hamming Distance between two DNA strands"
  [strand1 strand2]
  (if (= (count strand1) (count strand2))
    (let [sequence1 (re-seq #"[ACGT]" strand1)
          sequence2 (re-seq #"[ACGT]" strand2)
          dist (map #(boolean-to-int (not (= %1 %2))) sequence1 sequence2)]
      (reduce + dist))
    nil))

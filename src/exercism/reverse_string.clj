(ns exercism.reverse-string)

(defn reverse-string [s]
  (let [len (count s)
        indexes (reverse (range len))]
    (if (> len 1)
      (reduce str (map #(get s %) indexes))
      s)
      ;
    ))

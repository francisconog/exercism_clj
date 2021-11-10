(ns exercism.all-your-base)


(defn convert
  [b xs B]
  ;; your code goes here
  (if (and (> b 1)
           (> B 1)
           (every? true? (map #(and (< % b) (>= % 0)) xs)))
    (if (and (every? true? (map #(zero? %) xs)) (not (empty? xs)))
      '(0)
      (let [indexes (reverse (range (count xs)))]
        (loop [decimal_number (int (reduce + (map #(* %1 (Math/pow b %2)) xs indexes)))
               remainder_stack []]
          (if (> decimal_number 0)
            (let [remainder (Math/floorMod decimal_number B)]
              (recur (Math/floorDiv decimal_number B)
                     (conj remainder_stack remainder)))
            (reverse remainder_stack)));
        ))
    nil))

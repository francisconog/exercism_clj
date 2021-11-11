(ns exercism.collatz-conjecture)

(defn three-x-plus-1
  [num]
  (+ (* 3 num) 1))

(defn collatz-step
  [num]
  (if (even? num)
    (/ num 2)
    (three-x-plus-1 num)))

(defn collatz 
  [num]
  (when (neg? num)
    (throw (Throwable. "negative value is an error")))
  (when (zero? num)
    (throw (Throwable. "zero is an error")))

  (loop [num num
         n 0]
    (if (not (= num 1))
      (recur (collatz-step num) (inc n))
      n)))


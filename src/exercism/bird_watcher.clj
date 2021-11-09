(ns exercism.bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today
  [birds]
  (last birds))

(defn inc-bird
  [birds]
  (assoc birds 6 (inc (today birds))))

(defn day-without-birds?
  [birds]
  (if (some true? (map #(= 0 %) birds))
    true
    false))


(defn n-days-count
  [birds n]
  (reduce + (subvec birds 0 n)))

(defn one-if-true
  [x]
  (if x
    1
    0))

(defn busy-days
  [birds]
  (reduce + (map #(one-if-true (>= % 5)) birds)))

(defn odd-week?
  [birds]
  (or
   (every? true? (map #(= %1 %2) birds [1 0 1 0 1 0 1]))
   (every? true? (map #(= %1 %2) birds [0 1 0 1 0 1 0]))))


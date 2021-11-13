(ns exercism.raindrops)

(defn Pling?
  [num]
  (if (zero? (Math/floorMod num 3))
    "Pling"
    ""))

(defn Plang?
  [num]
  (if (zero? (Math/floorMod num 5))
    "Plang"
    ""))

(defn Plong?
  [num]
  (if (zero? (Math/floorMod num 7))
    "Plong"
    ""))

(defn convert
  [num]
  (let [s (str (Pling? num) (Plang? num) (Plong? num))]
    (if (seq? s)
      s
      (str num))))

;;;; Alternative form
;; (defn convert
;;   [num]
;;   (let [s (str (Pling? num) (Plang? num) (Plong? num))]
;;     (if (not (empty? s))
;;       s
;;       (str num))))
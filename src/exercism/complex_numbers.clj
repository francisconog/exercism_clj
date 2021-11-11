(ns exercism.complex-numbers)

(defn real
  "Real part of a complex number"
  [[a b]]
  a)

(defn imaginary
  "Imaginary part of a complex number"
  [[a b]]
  b)

(defn abs
  "absolute value of a given complex number"
  [[a b]]
  (->> [a b]
       (map #(Math/pow % 2))
       (reduce +)
       Math/sqrt))

(defn conjugate
  "conjugate of a given complex number"
  [[a b]]
  [a (* -1 b)])

(defn add
  "addition of two complex numbers"
  [[a b] [c d]]
  [(+ a c) (+ b d)])

(defn sub
  "subtraction of two complex numbers"
  [[a b] [c d]]
  [(- a c) (- b d)])

(defn mul
  "multiplication of two complex numbers"
  [[a b] [c d]]
  [(- (* a c) (* b d)) (+ (* b c) (* a d))])

(defn div
  "division of two complex numbers"
  [[a b] [c d]]
  (let [real-part (/ (+ (* a c) (* b d))
                     (+ (Math/pow c 2) (Math/pow d 2)))
        imaginary-part   (/ (- (* b c) (* a d))
                            (+ (Math/pow c 2) (Math/pow d 2)))]
    [real-part imaginary-part]))

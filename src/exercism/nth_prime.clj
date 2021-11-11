(ns exercism.nth-prime)


(defn primality-test-n-greater-than-3
  ""
  [n i]
  (if (or (zero? (Math/floorMod n i))
          (zero? (Math/floorMod n (+ i 2))))
    false
    true))

(defn is-prime?-greater-than-3
  "Primality test using 6k±1 optimization for n > 3."
  [n]
  (loop [i 5
         state true]
    (if (and (< i (+ (int (Math/sqrt n)) 1))
             (true? state))
      (recur (+ i 6) (primality-test-n-greater-than-3 n i))
      state)))

(defn is-prime?
  "Primality test using 6k±1 optimization."
  [n]
  (cond
    (<= n 3) (> n 1)
    (or (= (Math/floorMod n 2) 0)
        (= (Math/floorMod n 3) 0)) false
    :else (is-prime?-greater-than-3 n)))

(defn nth-prime
  "Given a number n, determine what the nth prime is"
  [n]
  (when (neg? n)
    (throw (IllegalArgumentException. "there is no negative prime")))
  (when (zero? n)
    (throw (IllegalArgumentException. "there is no zeroth prime")))
  (loop [i 3
         primes [2]]
    (if (< (count primes) n)
      (recur (+ i 2) (if (is-prime? i) (conj primes i) primes))
      (get primes (- n 1))))
  ;
  )


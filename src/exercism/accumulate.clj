(ns exercism.accumulate)

; Both solutions kinda work out, but the first fails in the fifth test due
; a type problem, since it returns a LazySeq and it must return a PersistentVector
; to succeed. But, for me it is a simplier and more concise solution, so I left it
; here


(defn accumulate
  "Given a collection and an operation to perform on each 
   element of the collection, returns a new collection containing 
   the result of applying that operation to each element of the 
   input collection"
  [f xs]
  (for [x xs
        :let [y (f x)]]
    y;
    ))

(defn accumulate
  "Given a collection and an operation to perform on each 
   element of the collection, returns a new collection containing 
   the result of applying that operation to each element of the 
   input collection"
  [f xs]
  (loop [xs xs
         y []]
    (if (and xs (> (count xs) 0))
      (let [x (first xs)]
        (recur (next xs) (conj y (f x))))
      y)
  ))

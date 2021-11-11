(ns exercism.pangram
  (:require [clojure.string :as str]))


(defn pangram?
  "Determine if a sentence is a pangram"
  [s]
  (loop [letters-seq (re-seq #"[a-z]" (str/lower-case s))
         letters-table {"a" 0, "b" 0, "c" 0, "d" 0, "e" 0, "f" 0, "g" 0
                        "h" 0, "i" 0, "j" 0, "k" 0, "l" 0, "m" 0, "n" 0
                        "o" 0, "p" 0, "q" 0, "r" 0, "s" 0, "t" 0, "u" 0
                        "v" 0, "w" 0, "x" 0, "y" 0, "z" 0}];
    (if (seq letters-seq)
      (recur (next letters-seq)
             (update letters-table (first letters-seq) inc))
      (->> letters-table
           vals
           (map pos?)
           (every? true?));
      )))

;;; This is one way to generate the letters-map with clojure, if you do not want
;;; to lose your time writing it 😅😅😅

;; (defn generate-letters-table
;;   []
;;   (let [characters (->> (range 97 123)
;;                         (map #(char %)))]
;;     (loop [characters characters
;;            character-table {}]
;;       (if (seq characters)
;;         (recur (next characters)
;;                (assoc character-table (str (first characters)) 0))
;;         character-table)))
;; )


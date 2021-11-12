(ns exercism.pig-latin
  (:require [clojure.string :as str]))



(defn nested-seq-to-str
  [n-seq]
  (->> n-seq
       (map #(reduce str %))
       (reduce str)))

(defn parse-inverted-splition
  [s-seq i]
  (-> (split-at i s-seq)
      reverse
      nested-seq-to-str
      (str "ay")))

(defn match-rule-2-3
  [s]
  (let [match (re-find #"^[bcdfghjklmnpqrstvwxz]*?(qu)" s)]
    (if match
      (match 0)
      (re-find #"^[bcdfghjklmnpqrstvwxz]*" s))
    ;
    ))

(defn rule-2-3
  [s]
  (let [s-seq (str/split s #"")]
    (parse-inverted-splition  s-seq (count (match-rule-2-3 s)))))

(defn match-rule-4
  [s]
  (let [match (re-find #"^y?([bcdfghjklmnpqrstvwxz])*" s)]
    (if match
      (match 0)
      (re-find #"^[bcdfghjklmnpqrstvwxz]*" s))
    ;
    ))
(defn rule-4
  [s]
  (let [s-seq (str/split s #"")]
    (parse-inverted-splition  s-seq (count (match-rule-4 s)))))


(defn translate-word
  [s]
  (cond
    (or
     (= (take 2 s) '(\x \r));
     (= (take 2 s) '(\y \t));
     )(str s "ay") ; rule 1
    (not (= "" (match-rule-2-3 s))) (rule-2-3 s)
    (not (= "" (match-rule-4 s))) (rule-4 s)
    :else (str s "ay")))

(defn translate
  [s]
  (if (str/includes? s " ")
    (->> (str/split s #" ")
         (map translate-word)
         (str/join " "))
    (translate-word s)))


;; (defn get-consonants-list
;;   "Generate a string with all consonants"
;;   []
;;   (let [characters (->> (range 97 123)
;;                         (map #(char %)))]
;;     (->> characters
;;          (map str)
;;          (reduce str)
;;          (re-seq #"[^aeiou]")
;;          (reduce str)
;;          ;
;;          )))
;; ;"bcdfghjklmnpqrstvwxyz"
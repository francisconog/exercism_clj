(ns exercism.anagram
  (:require [clojure.string :as str]))


(defn letter-map-incrementer
  [coll key]
  (if (some true? (map #(= % key) (keys coll)))
    (update coll key inc); true
    (assoc coll key 1); else
    ))

(defn get-letter-map
  [word];
  (loop [word word
         letter-map {}];
    (if (not-empty word)
      (recur (next word) (letter-map-incrementer letter-map (str (first word))));
      letter-map);
    ))

(defn same-latter-map?
  [word letter-map];
  (let [prospect-letter-map (get-letter-map word)];
    (= letter-map prospect-letter-map)))

(defn is-anagram?
  [word prospected-word]
  (let [lower-case-word (str/lower-case word)
        lower-case-prospected (str/lower-case prospected-word)
        letter-map (get-letter-map lower-case-word)]
    (if (not (= lower-case-word lower-case-prospected));
      (same-latter-map? lower-case-prospected letter-map)
      false)))

(defn conj-anagram
  [coll cond value]
  (if cond
    (conj coll value)
    coll))

(defn anagrams-for
  [word prospect-list]
  ;; your code goes here
  (let [true-indexes (map #(is-anagram? % word) prospect-list)];
    (loop [anagrams []
           ti true-indexes
           pl prospect-list]
      (if (not-empty pl)
        (recur (conj-anagram anagrams (first ti) (first pl))
               (next ti)
               (next pl);
               )
        anagrams; else
        ))))



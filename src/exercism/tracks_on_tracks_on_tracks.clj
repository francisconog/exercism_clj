(ns exercism.tracks-on-tracks-on-tracks)

(defn new-list
  "Creates an empty list of languages to practice."
  []
  '())

(defn add-language
  "Adds a language to the list."
  [lang lang-list]
  (conj lang-list lang))

(defn first-language
  "Returns the first language on the list."
  [lang-list]
  (first lang-list))

(defn remove-language
  "Removes the the first language added to the list."
  [lang-list]
  (rest lang-list))

(defn count-languages
  "Returns the total number of languages on the list."
  [lang-list]
  (count lang-list))

(defn learning-list
  "Creates an empty list, adds Clojure and Lisp, removes Lisp, adds
  Java and JavaScript, then finally returns a count of the total number
  of languages."
  []

  (def list (new-list))
  (def list (add-language "Lisp" list))
  (def list (add-language "Clojure" list))
  (def list (remove-language list))
  (def list (add-language "Java" list))
  (def list (add-language "JavaScript" list))
  (def list (count-languages list))
  list)

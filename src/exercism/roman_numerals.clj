(ns exercism.roman-numerals)

(defn destruct-number
  [n]
  (let [dez (Math/floorMod n 10)
        cent (Math/floorMod n 100)
        mil (Math/floorMod n 1000)
        dec-mil (Math/floorMod n 10000)]
    (cond
      (<= n 10) [n]
      (<= n 100) [dez, (- cent dez)]
      (<= n 1000) [dez, (- cent dez), (- mil cent)]
      (<= n 10000) [dez, (- cent dez), (- mil cent), (- dec-mil mil)]
      ;
      )))

(defn numerals
  [n]
  (let [d (destruct-number n)
        roman-numbers {1 "I", 2 "II", 3 "III", 4 "IV", 5 "V", 6 "VI", 7 "VII"
                       8 "VIII", 9 "IX", 10 "X", 20 "XX", 30 "XXX"
                       40 "XL", 50 "L", 60 "LX", 70 "LXX", 80 "LXXX"
                       90 "XC", 100 "C", 200 "CC", 300 "CCC", 400 "CD"
                       500 "D", 600 "DC", 700 "DCC", 800 "DCCC", 900 "CM"
                       1000 "M", 2000 "MM", 3000 "MMM"}]
    (->> d
         (map #(roman-numbers %))
         reverse
         (reduce str))))




(ns exercism.cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [base-speed 221
        success-rate (if (<= speed 4) ;else 1
                       1.0
                       (if (<= speed 8) ;else 2 
                         0.9
                         (if (= speed 9) ;else 3 
                           0.8
                           0.77)))]
    (* base-speed speed success-rate)))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))

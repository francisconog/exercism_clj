(ns exercism.interest-is-interesting)

(defn interest-rate
  "Calculate the interest rate based on the specified balance"
  [balance]
  (if (< balance 0)
    -3.213
    (if (< balance 1000) ;else 1
      0.5
      (if (< balance 5000) ;else 2
        1.621
        2.475)))) ;else 3


(defn annual-balance-update
  "calculate the annual balance update, taking into account the interest rate"
  [balance]
  (let [interest_rate (bigdec (/ (interest-rate balance) 100))
        annual-yield (* (if (< balance 0)
                          (- balance)
                          balance) interest_rate)]
    (+ balance annual-yield);
    ))

(defn amount-to-donate
  "calculate how much money to donate to charities based on the balance and the 
   tax-free percentage that the government allows"
  [balance tax-free-percentage]

  (if (> balance 0)
    (int (* balance tax-free-percentage 1E-2 2))
    0))

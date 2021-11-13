(ns exercism.robot-name)

(defn random-letter
  []
  (char (+ 65 (rand-int 26))))

(defn random-name
  [& nome]
  (str
   (random-letter)
   (random-letter)
   (rand-int 9)
   (rand-int 9)
   (rand-int 9)))

(defn robot
  []
  (atom (random-name)))

(defn robot-name
  [robot]
  @robot)

(defn reset-name
  [robot-]
  (reset! robot- (random-name)))


(let [a-robot (robot)
      its-original-name (robot-name a-robot)
      its-new-name (do (reset-name a-robot)
                       (robot-name a-robot))]
  (println its-original-name "->" its-new-name))

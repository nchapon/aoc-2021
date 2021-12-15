(ns aoc-2021.day2 
  (:require
    [clojure.string :as string]))

(def position {:horizontal 0
               :depth 0})

(def position-with-aim {:horizontal 0
                        :depth 0
                        :aim 0})



(defmulti move
  (fn [_ instruction] (first instruction)))

(defmethod move :forward
  [position instruction]
  (let [amount (second instruction)]
    (if (get position :aim)
      (-> position
          (update :horizontal + amount)
          (update :depth + (* amount (get position :aim))))
      (update position :horizontal + amount))))


(defmethod move :up
  [position instruction]
  (if (get position :aim)
    (update position :aim - (second instruction))
    (update position :depth - (second instruction))
    ))


(defmethod move :down
  [position instruction]
  (if (get position :aim)
    (update position :aim + (second instruction))
    (update position :depth + (second instruction))
    ))


(defn parse-instruction
  "Parse instruction"
  [s]
  (let [[dir val] (string/split s #" ")]
    [(keyword dir) (Integer/parseInt val)]))


(defn multiply
  "Compute position"
  [p]
  (* (:horizontal p)
     (:depth p)))

(defn day2-part1
  [instructions]
(->> instructions
     string/split-lines
     (map parse-instruction)
     (reduce move position)
     (multiply)))

(defn day2-part2
  [instructions]
(->> instructions
     string/split-lines
     (map parse-instruction)
     (reduce move position-with-aim)
     (multiply)))





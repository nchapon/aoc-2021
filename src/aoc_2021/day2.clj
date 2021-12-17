(ns aoc-2021.day2 
  (:require
   [clojure.string :as string]
   [aoc-2021.core :refer [read-puzzle]]))

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

(defn part-1
  [instructions]
(->> instructions
     (map parse-instruction)
     (reduce move position)
     (multiply)))

(defn part-2
  [instructions]
(->> instructions
     (map parse-instruction)
     (reduce move position-with-aim)
     (multiply)))


(defn day2 []
  (println "Running Day 2")
  (let [input (read-puzzle "resources/day2/input.txt")]
    (println "Part 1 : " (part-1 input))
    (println "Part 2 : " (part-2 input))))





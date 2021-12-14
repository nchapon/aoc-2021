(ns aoc-2021.day2 
  (:require
    [clojure.string :as string]))

(def position {:horizontal 0
               :depth 0
               :aim 0})


(defmulti move
  (fn [_ instruction] (first instruction)))
  
(defmethod move :forward
  [position instruction]
  (update position :horizontal + (second instruction)))


(defmethod move :up
  [position instruction]
  (update position :depth - (second instruction)))


(defmethod move :down
  [position instruction]
  (update position :depth + (second instruction)))


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






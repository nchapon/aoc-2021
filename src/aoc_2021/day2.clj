(ns aoc-2021.day2 
  (:require
    [clojure.string :as string]))

(defmulti move
  (fn [_ instruction] (first instruction)))
  
(defmethod move :forward  
  [[x y] instruction]
  [(+ x (second instruction)) y])


(defmethod move :up
  [[x y] instruction]
  [x (- y (second instruction))])


(defmethod move :down 
  [[x y] instruction]
  [x (+ y (second instruction))])


(defn parse-instruction
  "Parse instruction"
  [s]
  (let [[dir val] (string/split s #" ")]
    [(keyword dir) (Integer/parseInt val)]))


(defn run
  [instructions]
(->> instructions
     string/split-lines
     (map parse-instruction)
     (reduce move [0 0])
     (apply *)))








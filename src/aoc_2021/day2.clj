(ns aoc-2021.day2 
  (:require
    [clojure.string :as string]))

(defn read-input
  "Read Input File"
  []
  (slurp "resources/day2/input.txt"))


(defmulti move
  (fn [instruction _] (first instruction)))
  
(defmethod move :forward  
  [instruction [x y]]
  [(+ x (second instruction)) y])


(defmethod move :up
  [instruction [x y]]
  [x (- y (second instruction))])


(defmethod move :down 
  [direction [x y]]
  [x (+ y (second direction))])


(defn parse-instruction
  "Parse instruction"
  [s]
  (let [[dir val] (string/split s #" ")]
    [(keyword dir) (Integer/parseInt val)]))


(comment
  (->> (read-input)
       string/split-lines
       (map parse-instruction))

  (let [dir val]
    (string/split "forward 9" #" ")

    (first [:forward 5]))

  (let [[dir val] (string/split "forward 9" #" ")]
    [(keyword dir) (Integer/parseInt val)])

  (parse-instruction "forward 9"))





(ns aoc-2021.core 
  (:require
    [aoc-2021.day2 :refer [day2-part1]]))


(defn read-puzzle
  "Read puzzle File"
  [f]
  (slurp f))

(defn run-day2 []
  (day2-part1 (read-puzzle "resources/day2/input.txt")))


(comment
  (run-day2)) 




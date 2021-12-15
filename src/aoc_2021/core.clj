(ns aoc-2021.core 
  (:require
    [aoc-2021.day2 :refer [day2-part1 day2-part2]]))


(defn read-puzzle
  "Read puzzle File"
  [f]
  (slurp f))

(defn run-day2 []
  (println "Running Day 2")
  (let [puzzle (read-puzzle "resources/day2/input.txt")]
    (println "Part 1 : " (day2-part1 puzzle))
    (println "Part 2 : " (day2-part2 puzzle))))

 




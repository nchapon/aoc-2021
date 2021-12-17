(ns aoc-2021.day3 
  (:require
    [aoc-2021.core :refer [read-puzzle]]))

(def gamma-rate (partial apply max-key val))
(def epsilon-rate (partial apply min-key val))

(defn get-frequencies
  ""
  [input]
  (let [end (count (first input))]
   (for [x (range end)]
     (frequencies (map #(subs % x (inc x)) input)))))

(defn- binary->int
  [s]
  (read-string (str "2r" s)))


(defn compute-rate [rate-fn input]
  (->> input
       get-frequencies
       (map (comp key rate-fn))
       (apply str)
       binary->int))

(defn part-1
  "Day 3 part1"
  [input]
  (* (compute-rate gamma-rate input)
     (compute-rate epsilon-rate input)
     ))







(ns aoc-2021.day3 
  (:require
    [aoc-2021.core :refer [read-puzzle]]))

(def gamma-rate (partial apply max-key val))
(def epsilon-rate (partial apply min-key val))

(defn get-bit-frequencies-by-position [input pos]
  (frequencies (map #(subs % pos (inc pos)) input)))

(defn get-bit-frequencies
  ""
  [input]
  (let [end (count (first input))]
   (for [x (range end)]
     (get-bit-frequencies-by-position input x))))

(defn- binary->int
  [s]
  (read-string (str "2r" s)))


(defn compute-rate [rate-fn input]
  (->> input
       get-bit-frequencies
       (map (comp key rate-fn))
       (apply str)
       binary->int))

(defn part-1
  "Day 3 part1"
  [input]
  (* (compute-rate gamma-rate input)
     (compute-rate epsilon-rate input)
     ))



(defn part-2
  "Day 3 part 2"
  [input]
  )

(def vals [
              "00100"
              "11110"
              "10110"
              "10111"
              "10101"
              "01111"
              "00111"
              "11100"
              "10000"
              "11001"
              "00010"
              "01010"
              ])


(apply max-key val (get-bit-frequencies-by-position vals 0))







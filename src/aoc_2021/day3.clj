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

(defn count-bits
  "Count bits for input at position"
  [input pos]
  (let [counted-bits (get-bit-frequencies-by-position input pos)]
    [(get counted-bits "0") (get counted-bits "1")]
    ))

(defn most-common
  "Returns most common numbers, 1 if equality"
  [[zeros ones]]
  (if (>= ones zeros) "1" "0"))

(defn least-common
  "Returns least common numbers, 0 if equality"
  [[zeros ones]]
  (if (<= zeros ones) "0" "1"))

(def most-common-bit (comp most-common count-bits))
(def least-common-bit (comp least-common count-bits))

(defn filter-numbers-by
  ""
  [bit pos numbers]
  (if (= (subs numbers pos (inc pos)) bit)
    true false))

(defn filter-by-bit-criteria
  "Filter input numbers by bit criteria function"
  [bit-criteria-fn input]

  (loop [numbers input
         pos 0]
    (if (= 1 (count numbers))
      numbers
      (recur (filter #(filter-numbers-by (bit-criteria-fn numbers pos) pos %) numbers) (inc pos)))))

(defn get-oxygen-generator-rating
  "Returns oxygen generator rating"
  [input]

  (->> input
       (filter-by-bit-criteria most-common-bit)
       (apply str)
       (binary->int)))


(defn get-co2-scrubber-rating
  "Returns CO2 scrubber rating"
  [input]

  (->> input
       (filter-by-bit-criteria least-common-bit)
       (apply str)
       (binary->int)))


(defn part-2
  "Day 3 part 2"
  [input]
  (* (get-oxygen-generator-rating input)
     (get-co2-scrubber-rating input)))


(defn day3 []
  (println "Running Day 3")
  (let [input (read-puzzle "resources/day3/input.txt")]
    (println "Part 1 : " (part-1 input))
    (println "Part 2 : " (part-2 input))))





















(ns aoc-2021.day3 
  (:require
    [aoc-2021.core :refer [read-puzzle]]
    [clojure.string :as string]))

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



(defn get-most-significant-bit
  ""
  [input pos]
  (let [counted-bits (get-bit-frequencies-by-position input pos)
        zeros (get counted-bits "0")
        ones (get counted-bits "1")]
    (if (>= ones zeros) "1" "0")
    ))

(defn get-less-significant-bit
  ""
  [input pos]
  (let [counted-bits (get-bit-frequencies-by-position input pos)
        zeros (get counted-bits "0")
        ones (get counted-bits "1")]
    (if (<= zeros ones) "0" "1")
    ))


(defn number-filter
  ""
  [pos bit numbers]
  (if (= (subs numbers pos (inc pos)) bit)
    true false))

(defn get-oxygen-generator-rating
  ""
  [input]

  (loop [numbers input
         pos 0]
    (if (= 1 (count numbers))
      numbers
      (recur (filter #(number-filter pos (get-most-significant-bit numbers pos) %) numbers) (inc pos)))))


(defn get-co2-scrubber-rating
  ""
  [input]

  (loop [numbers input
         pos 0]
    (if (= 1 (count numbers))
      numbers
      (recur (filter #(number-filter pos (get-less-significant-bit numbers pos) %) numbers) (inc pos)))))


(defn part-2
  "Day 3 part 2"
  [input]
  (* (binary->int (apply str (get-oxygen-generator-rating input)))
     (binary->int (apply str (get-co2-scrubber-rating input)))))


(defn day3 []
  (println "Running Day 3")
  (let [input (read-puzzle "resources/day3/input.txt")]
    (println "Part 1 : " (part-1 input))
    (println "Part 2 : " (part-2 input))))





















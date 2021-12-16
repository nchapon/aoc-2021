(ns aoc-2021.day1 
  (:require
    [clojure.string :as string]))

(defn depth-increase?
  "Returns true if second is greater than first."
  [first second]
  (if (< first second) true false))

(defn count-increase
  "Count numbers of increas depths"
  [depths]
  (first
   (reduce (fn [[count previous] number]
                   (if (depth-increase? previous number)
                     [(inc count) number]
                     [count number]))
                 [0 (first depths)]
                 (rest depths))))

(defn- str->int
  [s]
  (Integer/parseInt s))

(defn day1-part1
  [depths]
  (->> depths
       (string/split-lines)
       (map str->int)
       (count-increase)))




(defn get-depths-windowed
  [depths]
  (loop [xs (seq depths)
       result []]
  (if (>= (count xs) 3)
    (let [x (take 3 xs)]
      (recur (next xs) (conj result (apply + x))))
    result)))


(defn count-increase-windowed
  [depths]
  (count-increase (get-depths-windowed depths)))

(defn day1-part2
  [depths]
  (->> depths
       (string/split-lines)
       (map str->int)
       (count-increase-windowed)))









(ns aoc-2021.day3-test 
  (:require
   [aoc-2021.day3 :refer [part-1 part-2]]
   [clojure.test :refer [deftest is testing]]))

(def input [
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

(deftest test-part-1
  (testing "Testing part 1"
    (is (= (part-1 input) 198))))


(deftest test-part-2
  (testing "Testing part 2"
    (is (= (part-2 input) 230))))










(ns aoc-2021.day2-test 
  (:require
   [aoc-2021.day2 :refer [move run]]
   [clojure.test :refer [deftest is testing]]))

(deftest test-move-forward
  (testing "Move Forward should increment"
    (is (= (move [0 0] [:forward 5]) [5 0]))))


(deftest test-move-up
  (testing "Move Up should decrease y value"
    (is (= (move [0 0] [:up 4]) [0 -4]))))


(deftest test-move-down
  (testing "Move down should increase y value"
    (is (= (move [0 0] [:down 2]) [0 2]))))


(def instructions
"forward 5
down 5
forward 8
up 3
down 8
forward 2")

(deftest test-run-instructions
  (testing "Run a sample of the course"
    (is (= (run instructions) 150))))











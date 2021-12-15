(ns aoc-2021.day2-test 
  (:require
   [aoc-2021.core :refer [read-puzzle]]
   [aoc-2021.day2 :refer [day2-part1 move day2-part2]]
   [clojure.test :refer [deftest is testing]]))

(def position {:horizontal 0
               :depth 0})

(deftest test-move-forward
  (testing "Move Forward should increment"
    (is (= (move position [:forward 5])
           {:horizontal 5
            :depth 0}))))

(deftest test-move-forward-with-aim
  (testing "Move Forward should increment"
    (is (= (move {:horizontal 0 :depth 0 :aim 2} [:forward 5])
           {:horizontal 5
            :depth 10
            :aim 2}))))

(deftest test-move-up
  (testing "Move Up should decrease y value"
    (is (= (move position [:up 4])
           {:horizontal 0
            :depth -4}))))

(deftest test-move-up-with-aim
  (testing "Move Up should decrease aim by value"
    (is (= (move {:horizontal 0 :depth 0 :aim 0} [:up 4])
           {:horizontal 0
            :depth 0
            :aim -4}))))

(deftest test-move-down
  (testing "Move down 2 should increase depth by 2"
    (is (= (move position [:down 2])
           {:horizontal 0
            :depth 2}))))

(deftest test-move-down-with-aim
  (testing "Move down 2 should decrease aim by 2"
    (is (= (move {:horizontal 0 :depth 0 :aim 0} [:down 2])
           {:horizontal 0
            :depth 0
            :aim 2}))))


(def instructions
"forward 5
down 5
forward 8
up 3
down 8
forward 2")

(deftest test-run-instructions-part1
  (testing "Run a sample of the course"
    (is (= (day2-part1 instructions) 150))))

(deftest test-run-instructions-part2
  (testing "Run a sample of the course"
    (is (= (day2-part2 instructions) 900))))


(deftest test-run-puzzle-part1
  (testing "Run a sample of the course"
    (is (= (day2-part1 (read-puzzle "resources/day2/input.txt")) 1989265))))
















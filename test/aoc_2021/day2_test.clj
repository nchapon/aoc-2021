(ns aoc-2021.day2-test 
  (:require
    [aoc-2021.day2 :refer [move]]
    [clojure.test :refer [deftest testing is]]))



(deftest test-move-forward
  (testing "Move Forward should increment"
    (is (= (move [:forward 5] [0 0]) [5 0]))))


(deftest test-move-up
  (testing "Move Up should decrease y value"
    (is (= (move [:up 4] [0 0]) [0 -4]))))


(deftest test-move-down
  (testing "Move down should increase y value"
    (is (= (move [:down 2] [0 0]) [0 2]))))

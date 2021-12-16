(ns aoc-2021.day1-test 
  (:require
   [aoc-2021.day1 :refer [count-increase count-increase-windowed]]
   [clojure.test :refer [deftest is testing]]))


(def depths [199
            200
            208
            210
            200
            207
            240
            269
            260
            263])

(deftest count-increase-depths
  (testing "Should count 7 increases"
   (is (= (count-increase depths) 7))))


(deftest count-increase-depths-windowed
  (testing "Should count 7 increases"
   (is (= (count-increase-windowed depths) 5))))









  
















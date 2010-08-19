(ns quephird.tests
  (:use clojure.test quephird.99problems))

(deftest test-length
  (testing "Empty collection should be length 0"
    (is (= 2 (my-length [1 2]))))
  (testing "Vector [1 2] should be length 2"
    (is (= 2 (my-length [1 2]))))
  (testing "List (1 2) should be length 2"
    (is (= 2 (my-length (list 1 2)))))
  (testing "Nested list (1 2 (3 4)) should be length 3"
    (is (= 3 (my-length (list 1 2 (list 3 4))))))
)


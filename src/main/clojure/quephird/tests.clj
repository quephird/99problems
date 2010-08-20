(ns quephird.tests
  (:use clojure.test quephird.99problems))

(deftest test-length
  (testing "Empty collection should be length 0"
    (is (= 0 (length []))))
  (testing "Vector [1 2] should be length 2"
    (is (= 2 (length [1 2]))))
  (testing "List (1 2) should be length 2"
    (is (= 2 (length '(1 2)))))
  (testing "Nested list (1 2 (3 4)) should be length 3"
    (is (= 3 (length '(1 2 '(3 4))))))
)

(deftest test-my-last
  (testing "Last element of empty collection should be nil"
    (is (nil? (my-last []))))
  (testing "Last element of vector of one element should be the one element"
    (is (= 42 (my-last [42]))))
  (testing "Last element of list of one element should be the one element"
    (is (= 42 (my-last '(42)))))
  (testing "Last element of (1 2 3 4) should be 4"
    (is (= 4 (my-last '(1 2 3 4)))))
  (testing "Last element of nested list (1 2 3 (4 5 6)) should be (4 5 6)"
    (is (= '(4 5 6) (my-last '(1 2 3 (4 5 6))))))
)

(deftest test-remove-consec-dups
  (testing "Removing consecutive duplicates from empty list should result in empty list"
    (is (empty? (remove-consec-dups '()))))
  (testing "Removing consecutive duplicates from list with no consecutive duplicates should result in same list"
    (is (= '(1 2 3 4) (remove-consec-dups '(1 2 3 4)))))
  (testing "Removing consecutive duplicates from list containing only one element repeated should result in list containing just that one element"
    (is (= '(42) (remove-consec-dups '(42 42 42 42)))))
  (testing "Removing consecutive duplicates from (1 2 2 3 3 3 4 4 4 4) should result in (1 2 3 4)"
    (is (= '(1 2 3 4) (remove-consec-dups '(1 2 2 3 3 3 4 4 4 4)))))
)

(deftest test-pack-consec-dups
  (testing "Packing list with no duplicates should result in list of lists each with one element"
    (is (= '((1) (2) (3)) (pack-consec-dups '(1 2 3)))))
  (testing "Packing list with one element repeated should result in list containing the same list"
    (is (= '((a a a a)) (pack-consec-dups '(a a a a)))))
  (testing "Packing '(a a a b c c d d d d) should result in '((a a a) (b) (c c) (d d d d))"
    (is (= '((a a a) (b) (c c) (d d d d)) (pack-consec-dups '(a a a b c c d d d d)))))
)

(deftest test-run-length-encode
  (testing "RLE'ing of list with no duplicates should result in list of lists each of form '(1 foo)"
    (is (= '((1 a) (1 b) (1 c)) (run-length-encode '(a b c)))))
  (testing "RLE'ing list with one element repeated n times should result in list containing one element of the form '(n foo)"
    (is (= '((4 a)) (run-length-encode '(a a a a)))))
  (testing "RLE'ing '(a a a b c c d d d d) should result in '((3 a) (1 b) (2 c) (4 d))"
    (is (= '((3 a) (1 b) (2 c) (4 d)) (run-length-encode '(a a a b c c d d d d)))))
)

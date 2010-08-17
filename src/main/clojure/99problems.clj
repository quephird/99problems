;; TODO
;;
;; Need to namespace these functions
;; NEED UNIT TESTS!1!!!

;; P01

(defn my-last [coll]
  (if (empty? coll) 
    nil
    (let [[x & xs] coll]
       (if (empty? xs)
          x
          (my-last xs)))))

;; P04

(defn my-length [coll]
  (if (empty? coll)
      0
      (+ 1 (my-length (rest coll)))))

;; P02

(defn last-but-one [coll]
  (cond 
    (< (my-length coll) 2) nil
    (= (my-length coll) 2) (first coll)
    :else (last-but-one (rest coll))))


;; P03

(defn kth [k coll]
  (cond
    (> k (my-length coll)) nil
    (= 0 k) (first coll)
    :else (kth (- k 1) (rest coll))))

;; P05

(defn my-reverse [coll]
  (loop [tmp coll
         retval []]
    (if (empty? tmp)
      retval
      (recur (rest tmp) (concat (list (first tmp)) retval)))))


;; P06

(defn palindrome? [coll]
  (= coll (my-reverse coll)))

;; P07

(defn flatten [coll]
  (if (empty? coll) 
    []
    (let [[x & xs] coll]
      (if (coll? x)
        (concat (flatten x) (flatten xs))
        (cons x (flatten xs))))))

;; P08
;; Ugh... this works but it is ugly.

(defn remove-consec-dups [coll]
  (loop [xs coll
         prev-x nil
         retval []]
    (if (empty? xs)
      retval
      (if (= (first xs) prev-x)
        (recur (rest xs) (first xs) retval)
        (recur (rest xs) (first xs) (conj retval (first xs)))))))


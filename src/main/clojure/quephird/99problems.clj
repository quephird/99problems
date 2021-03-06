(ns quephird.99problems)

;; P01

(defn my-last [coll]
  (if (empty? coll) 
    nil
    (let [[x & xs] coll]
       (if (empty? xs)
          x
          (my-last xs)))))

;; P04

(defn length [coll]
  (if (empty? coll)
      0
      (+ 1 (length (rest coll)))))

;; P02

(defn last-but-one [coll]
  (cond 
    (< (length coll) 2) nil
    (= (length coll) 2) (first coll)
    :else (last-but-one (rest coll))))


;; P03

(defn kth [k coll]
  (cond
    (> k (length coll)) nil
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

(defn remove-consec-dups [coll]
  (loop [[x & xs] coll
         prev-x nil
         retval []]
    (if (nil? x)
      retval
      (if (= x prev-x)
        (recur xs x retval)
        (recur xs x (conj retval x))))))

;; P09
;; This is horrible, but it works
;; NOTE TO SELF... Need to look at this in the future

(defn pack-consec-dups [coll]
  (loop [[x & xs] coll
         dup-xs []
         retval []]
    (if (nil? x)
      (conj retval dup-xs)
      (if (= x (first dup-xs))
        (recur xs (conj dup-xs x) retval)
        (if (empty? dup-xs)
          (recur xs [x] retval)
          (recur xs [x] (conj retval dup-xs))
)))))

;; P10

(defn run-length-encode [coll]
  (let [pcd (pack-consec-dups coll)]
    (loop [[x & xs] pcd
           retval []]
      (if (empty? x)
        retval
        (recur xs (conj retval [(length x) (first x)]))))))

;; P11

(defn run-length-encode-mod [coll]
  (let [pcd (pack-consec-dups coll)]
    (loop [[x & xs] pcd
           retval []]
      (if (empty? x)
        retval
        (if (= (length x) 1)
          (recur xs (conj retval (first x)))
          (recur xs (conj retval [(length x) (first x)])))))))

;; P12

(defn duplicate-n-times [elt n]
    (loop [i n dups []]
      (if (= i 0)
        dups
        (recur (- i 1) (conj dups elt)))))

(defn run-length-decode [coll]
  (loop [[x & xs] coll
         retval []]
    (if (nil? x)
      retval
      (if (coll? x)
        (recur xs (concat retval (duplicate-n-times (first (rest x)) (first x))))
        (recur xs (concat retval [x]))))))

;; P14

(defn duplicate-all-elts [coll]
  (loop [[x & xs] coll
         retval []]
    (if (nil? x)
      retval
      (recur xs (conj retval x x)))))

;; P15

(defn duplicate-all-elts-n-times [coll n]
  (loop [[x & xs] coll
         retval []]
    (if (nil? x)
      retval
      (recur xs (concat retval (duplicate-n-times x n))))))

;; P16

(defn drop-every-nth [coll n]
  (loop [[x & xs] coll
         ctr 1
         retval []]
    (if (nil? x)
      retval
      (if (= ctr n)
        (recur xs 1 retval)
        (recur xs (+ ctr 1) (conj retval x))
        ))))

;; P17

(defn split [coll n]
  (loop [[x & xs] coll
           ctr 1
           prev-xs []]
    (if (nil? x)
      [prev-xs []]
      (if (= ctr n)
        [(conj prev-xs x) xs]
        (recur xs (+ ctr 1) (conj prev-xs x))))))
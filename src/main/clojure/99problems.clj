;; P01

(defn my-last [lst]
  (if (empty? lst) 
    nil
    (let [[x & xs] lst]
       (if (empty? xs)
          x
          (my-last xs)))))

;; P04

(defn my-length [lst]
  (if (empty? lst)
      0
      (+ 1 (my-length (rest lst)))))

;; P02

(defn last-but-one [lst]
  (cond 
    (< (my-length lst) 2) nil
    (= (my-length lst) 2) (first lst)
    :else (last-but-one (rest lst))))


;; P03

(defn kth [k lst]
  (cond
    (> k (my-length lst)) nil
    (= 0 k) (first lst)
    :else (kth (- k 1) (rest lst))))

;; P05

(defn my-reverse [lst]
  (loop [tmp lst
         retval []]
    (if (empty? tmp)
      retval
      (recur (rest tmp) (concat (list (first tmp)) retval)))))


;; P06

(defn palindrome? [lst]
  (= lst (my-reverse lst)))


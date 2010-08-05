
;; P04

(defn my-length [lst]
  (if (empty? lst)
      0
      (+ 1 (my-length (rest lst)))))

;; P01

(defn my-last [lst]
  (if (empty? lst) 
    nil
    (let [[x & xs] lst]
       (if (empty? xs)
          x
          (my-last xs)))))



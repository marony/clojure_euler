(ns malib.prime)

(defn is-prime?
  "素数かどうか判断する"
  [n]
  (cond
    (<= n 1)
    false
    (= n 2)
    true
    ; 2からnの平方根までのシーケンス
    :else
    (let [xs (range 2 (inc (int (Math/sqrt n))))]
      ; 全ての数で割れなかったら
      (not (some #(= (mod n %) 0) xs)))))

(def primes
  "素数の無限シーケンス"
  (letfn [(next-prime' [n]
                       (loop [n' n]
                         (if (= 2 n')
                           3
                           (let [next (+ n' 2)]
                             (if (is-prime? next)
                               next
                               (recur next))))))]
    (iterate next-prime' 2)))

(defn primes2
  "エラトステネスの篩"
  [n]
  (let [xs (range 2 (inc n))
        max (int (Math/sqrt n))]
    (loop [[y & ys] xs
           ps []]
      (let [pss (conj ps y)]
        (if (> y max)
          (sort (concat ys pss))
          (recur (remove #(= (rem % y) 0) ys) pss))))))

(defn prime-factors
  "素因数分解して素数のリストを返す"
  [n]
  (loop [n' n
         xs' []]
    ; 2からn' / 2までのシーケンス
    (let [xss' (range 2 (inc (long (/ n' 2))))
          ; 割れた数の最初の数
          x' (first (filter #(zero? (mod n' %)) xss'))]
      (if (nil? x')
        ; 割れなかったらこの数自身が素因数
        (conj xs' n')
        ; 割れたら割った数をさらに素因数分解
        (recur (/ n' x') (conj xs' x'))))))

(ns clojure-euler.problems
  (:use malib.math malib.prime malib.util))

(load "problem005")
(load "problem008")
(load "problem011")

(defn problem001
  [max]
  ; 1以上max未満の遅延シーケンス
  (->>
    (range 1 max)
    (filter #(or (zero? (mod % 3)) (zero? (mod % 5))))
    (reduce +)))

(defn problem002
  [max]
  (let
      ; 前の二つの数字を足したものを次の数字とするシーケンス
      [fib (iterate #(let
                        [[n1 n2 n3] %]
                      [n2 n3 (+ n2 n3)]) [1 1 2])]
    (->> fib
         ; タプル(配列だけど)から最初の要素のみ取り出す
         (map #(let [[n1 n2 n3] %] n1))
         ; maxより小さいところまで取り出す
         (take-while #(< % max))
         ; 偶数のみにする
         (filter even?)
         ; 全て足す
         (reduce +))))

(defn problem003
  [n]
  ; 素因数分解したものの最大の数値
  (apply max (prime-factors n)))

(defn problem004
  [n]
  ; n桁の数字のシーケンス(10のn - 1乗 以上～10のn乗 未満、n = 2なら10～99)
  (let [xs (range (int (Math/pow 10 (dec n))) (int (Math/pow 10 n)))]
    ; 数字同士を掛け合わせる
    (apply max (for [x xs y xs :when (palindromic? (* x y))]
                 (* x y)))))

(defn problem006
  [max]
  ; 1..maxのシーケンス
  (let [xs (range 1 (inc max))
        sum-of-square (reduce #(+ %1 (int (Math/pow %2 2))) 0 xs)
        square-of-sum (int (Math/pow (reduce #(+ %1 %2) 0 xs) 2))]
    (- square-of-sum sum-of-square)))

(defn problem007
  [n]
  (nth primes (dec n)))

(defn problem009
  [n]
  (first
    (for [x (range 1 (- n 2))
          y (range (inc x) (- n 1))
          z (range (inc y) n)
          :when (and (= n (+ x y z)) (= (+ (* x x) (* y y)) (* z z)))]
      (* x y z))))

(defn problem010
  [max]
  (apply + (take-while #(< % max) primes)))

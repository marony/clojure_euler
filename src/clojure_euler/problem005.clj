(in-ns 'clojure-euler.problems)

(defn count-in-list
  "リストの要素ごとの数をマップで返す"
  ; (count-in-list [1 1 2 2 2 3 3 3 3])
  ; ↓
  ; {3 4, 2 3, 1 2}
  [xs]
  (letfn [(count-in-list'
            [acc x]
            (if-let [c (acc x)]
              (assoc acc x (inc c))
              (assoc acc x 1)))]
    (reduce count-in-list' {} xs)))

(defn problem005
  [max]
  ; マップに複数入っているものをばらす
  (letfn [(flatten-map
            [xs]
            (if (< 1 (count xs))
              ; 複数要素なのでばらす
              (loop [x (first xs)
                     xs' (rest xs)
                     rs ()]
                (if x
                  (recur (first xs') (rest xs') (conj rs {(x 0) (x 1)}))
                  rs))
              ; 1要素なのでそのまま返す
              xs))]
    ; 1..maxのシーケンス
    (let [xs (range 1 (inc max))
          ; シーケンス内のそれぞれの数値を素因数分解
          pss (map prime-factors xs)
          ; 素数ごとのカウントをとる
          counts (flatten (map (comp flatten-map count-in-list) pss))]
      ; 素数のカウントをマージする
      ; counts = ({1 1} {2 1} {3 1} {2 2} {5 1} {3 1, 2 1} {7 1} {2 3} {3 2} {5 1, 2 1})
      ; ↓
      ; ({1 1} {2 3} {3 2} {5 1} {7 1})
      (letfn [(merge-count
                [acc xs]
                (let [key ((first xs) 0)
                      count ((first xs) 1)
                      c (acc key)]
                  (if c
                    ; 数が多いほうだけ残す
                    (if (> count c)
                      (assoc acc key count)
                      (assoc acc key c))
                    ; 見つからないので新たに追加
                    (assoc acc key count))))
              ; 素数をその個数分掛ける
              (product-count
                [acc xs]
                (* acc (int (Math/pow (xs 0) (xs 1)))))]
        (->> counts
             (reduce merge-count {})
             (reduce product-count 1))))))

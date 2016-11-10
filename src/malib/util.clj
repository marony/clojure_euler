(ns malib.util)

(defn palindromic?
  "左右対称の数値か？"
  [n]
  ; 数字を文字列にする
  (let [s (str n)
        ; 長さ
        l (.length s)
        ; 長さの半分
        h (int (/ l 2))
        ; 文字列の前半
        lhs (.substring s 0 h)
        ; 文字列の後半を逆順にしたもの
        rhs (clojure.string/reverse (.substring s (+ h (mod l 2)) l))]
    (= lhs rhs)))

(defn char-to-num
  "'0'～'9'を数字にする"
  [c]
  (- (int c) (int \0)))

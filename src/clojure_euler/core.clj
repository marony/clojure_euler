(ns clojure-euler.core
  (:use clojure-euler.problems))

;C:\Users\tada\bin\lein.bat run
;problem001 : 233168
;"Elapsed time: 10.194091 msecs"
;problem002 : 4613732
;"Elapsed time: 1.817122 msecs"
;problem003 : 6857
;"Elapsed time: 5.907878 msecs"
;problem004 : 906609
;"Elapsed time: 887.806539 msecs"
;problem005 : 232792560
;"Elapsed time: 10.767966 msecs"
;problem006 : 25164150
;"Elapsed time: 1.177203 msecs"
;problem007 : 104743
;"Elapsed time: 1560.924911 msecs"
;problem008 : 40824
;"Elapsed time: 7.950802 msecs"
;problem009 : (31875000)
;"Elapsed time: 41359.733965 msecs"
;problem010 : 142913828922
;"Elapsed time: 67243.340863 msecs"
;problem011 : 70600674
;"Elapsed time: 85.992452 msecs"
;[END]

(defn -main
  "I don't do a whole lot."
  [& args]
  (do
    (print "problem001 : ")
    (time
      (->> (problem001 1000)
           println))
    (print "problem002 : ")
    (time
      (->> (problem002 4000000)
           println))
    (print "problem003 : ")
    (time
      (->> (problem003 600851475143)
           println))
    (print "problem004 : ")
    (time
      (->> (problem004 3)
           println))
    ; 綺麗に書き直す
    (print "problem005 : ")
    (time
      (->> (problem005 20)
           println))
    (print "problem006 : ")
    (time
      (->> (problem006 100)
           println))
    (print "problem007 : ")
    (time
      (->> (problem007 10001)
           println))
    (print "problem008 : ")
    (time
      (->> (problem008 5)
           println))
    ; 遅すぎるので書き直す
    (print "problem009 : ")
    (time
      (->> (problem009 1000)
           println))
    ; 遅すぎるので書き直す
    (print "problem010 : ")
    (time
      (->> (problem010 2000000)
           println))
    ; 綺麗に書き直す
    (print "problem011 : ")
    (time
      (->> (problem011 4)
           println))
    (println "[END]")))

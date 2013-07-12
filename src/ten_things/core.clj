(ns ten-things.core)

;; Threading Macro
(defn get-something [] "something")
(defn get-this [] "this")
(defn get-that [] "that")
(defn get-full-name [names]
  (assoc names :full-name
         (str (:first-name names) " " (:last-name names))))

(-> {:first-name "Shaun" :last-name "Parker"}
    (get-full-name)
    (:full-name))

(->> get-something
     (assoc {} :key))

(def people [{:name "Shaun Parker" :age 21}
             {:name "Daniel Glauser" :age 20}
             {:name "Tom Flarhrety" :age 18}])

(map #(:can-drink (if (> (:age %) 21)
                    (prn true)
                    (prn false))) people)

;; Commenting
(prn (get-this) (get-that) "foo")

;; Repl tricks M-. M-,
;; Non-repl tricks C-x C-i

;; Paredit
;; C-shift-)
;; M-r

;; destructuring
(defn prn-age [person]
  (println "name:" (:name person) "age:" (:age person)))

(defn prn-age [{name :name age :age}]
  (println "name:" name "age:" age))

(def things ["first" "second" "third" "fourth"])
(defn first-two-things [[first second]]
  (println first second))

;; for (all them options)
(for [thing things] (println thing))

(for [idx (range 1 5) :let [double (* 2 idx)]] (println double))

(for [idx (range 1 5) :let [plus-uno (+ 1 idx)] :when (odd? plus-uno)]
  (println plus-uno))

;; testing and with-redefs
(defn my-prn [arg] prn arg)

(defn call-yet-another-thing [arg]
  (my-prn arg)
  arg)

(defn call-another-thing [arg]
  (call-yet-another-thing arg))

(defn call-one-thing [arg]
  (call-another-thing arg))

;; Named anonymous functions show better stacktraces

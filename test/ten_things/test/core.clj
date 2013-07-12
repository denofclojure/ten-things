(ns ten-things.test.core
  (:require [clojure.test :refer :all]
            [ten-things.core :refer :all]))

(deftest test-things
  (testing "Calling things"
    (is (= "foo" (call-one-thing "foo")))
    (is (= "foo" (call-another-thing"foo")))
    (is (= "foo" (call-yet-another-thing"foo")))))

(deftest test-things-in-isolation
  (testing "Calling things - redef one level below"
    (with-redefs [call-another-thing (constantly "bar")]
      (is (= "bar" (call-one-thing "foo")))))
  (testing "Calling things - redef two levels below"
    (with-redefs [call-yet-another-thing (constantly "baz")]
      (is (= "baz" (call-another-thing "foo"))))))





















;;(with-redefs [my-prn (fn [arg] (prn "hijacked"))] (call-yet-another-thing "blah"))

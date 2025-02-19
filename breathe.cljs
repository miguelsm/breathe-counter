(ns breathe
  "A CLI tool that guides breathing exercises with timed voice prompts."
  (:require ["execa" :refer [execa]]
            [clojure.string :as str]
            [promesa.core :as p]))

(defn speak [message]
  (execa "espeak" #js [message]))

(defn countdown [message seconds]
  (when (> seconds 0)
    (println (str message " for " seconds " seconds..."))
    (speak message)
    (p/delay (* seconds 1000))))

(defn breathe-cycle [cycle total-cycles [inhale hold1 exhale hold2]]
  (println (str "Cycle " (inc cycle) "/" total-cycles))
  (p/let [_ (countdown "Breathe in" inhale)
          _ (countdown "Hold" hold1)
          _ (countdown "Breathe out" exhale)
          _ (countdown "Hold" hold2)]
    nil))

(defn run [args]
  (let [[pattern cycles] args
        pattern          (map js/parseInt (str/split pattern #"-"))
        cycles           (js/parseInt cycles)]
    (if (or (not= (count pattern) 4) (some js/isNaN pattern) (js/isNaN cycles))
      (println "Invalid input. Format: breathe <in-hold-out-hold> <cycles>, e.g., breathe 4-1-2-1 30")
      (p/loop [i 0]
        (if (< i cycles)
          (p/let [_ (breathe-cycle i cycles pattern)]
            (p/recur (inc i)))
          (p/let [_ (speak "Well done!")]
            (println "Well done!")))))))

(defn -main [& args]
  (if (< (count args) 2)
    (println "Usage: breathe <in-hold-out-hold> <cycles>")
    (run args)))

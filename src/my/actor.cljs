(ns my.actor
  (:require
    ["apify" :as Apify]
    [promesa.core :as p]))

(defn main []
  (Apify/main
    (fn []
      (-> (p/let
            [browser (Apify/launchPuppeteer #js {:headless true})
             page (.newPage browser)
             _ (.goto page "http://vaclav.synacek.com")
             my-name (.$eval page "h1" #(.-innerText %))
             _ (Apify/setValue "OUTPUT" #js {:name my-name})]
            (println (str "name is: " my-name))
            (.close browser)) 
          (p/catch 
            (fn [error]
              (println "something is broken and needs to be fixed")
              (print error)))))))



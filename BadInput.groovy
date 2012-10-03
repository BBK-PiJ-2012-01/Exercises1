class BadInput extends Exception {
    BadInput(def value) {
        println "Input of " + value + " is not appropriate."
    }
    
    BadInput() {
        println "Bad input given!"
    }
}
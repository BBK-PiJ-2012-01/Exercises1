int guess_number = 0, guess = -1
int random_num = Math.abs(1000 * Math.random())

println "Try to guess my number! "

while (guess != random_num) {
    print "Tell me a number: "
    guess = IOGeneric.getNumberFromUser()
    guess_number++
    
    if (guess > random_num)
        println "No! My number is lower"
    else if (guess < random_num)
        println "No! My number is higher"
}

println "CORRECT!"
println "You needed " + guess_number + " guesses."
int getNumberFromUser(){
    int num
    try {
        String str = System.console().readLine()
        num = Integer.parseInt(str)
    } catch(all) {
        throw new BadNumber()
    }
    return num
}


int guess_number = 0, guess = -1
int random_num = Math.abs(1000 * Math.random())

print "Try to guess my number! " + random_num

while (guess != random_num) {
    println "Tell me a number: "
    guess = getNumberFromUser()
    guess_number++
    
    if (guess > random_num)
        println "No! My number is lower"
    else if (guess < random_num)
        println "No! My number is higher"
}

println "CORRECT!"
println "You needed " + guess_number + " guesses."
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

// See PrimeFinder.groovy (shared with later exercises)
PrimeFinder p = new PrimeFinder()


int num_1, num_2

println "This program returns a list of prime numbers between two numbers"
println "Type the first number: "
num1 = getNumberFromUser()
println "Now type the second number: "
num2 = getNumberFromUser()

int[] primes = p.range([num1, num2].min(), [num1, num2].max())

println "The primes between " + [num1, num2].min() + " and " + [num1, num2].max() + " are:"
for (n in primes){ println "   " + n }
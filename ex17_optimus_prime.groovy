def pf = new PrimeFinder()

// This method doesn't use the optimisation in PrimeFinder
// which needs to know all prime numbers lower than the 
// test_number.

print "Enter the number to search near for a prime number: "
int distance=0, number=IOGeneric.getNumberFromUser()
def primes = []

if (number < 2)
    throw new BadInput(number)

if (pf.isPrime(number))
    primes.add(number)
    
while (primes.size() == 0) {
    distance++
    if (number-distance > 2 && pf.isPrime(number-distance))
        primes.add(number-distance)
    if (pf.isPrime(number+distance))
        primes.add(number+distance)
}

for (n in primes){ println "   " + n }
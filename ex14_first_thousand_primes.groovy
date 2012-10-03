println "Here are the first 1000 prime numbers..."

def pf = new PrimeFinder()
pf.findFirstNPrimes(100)
primes = pf.cardinalRange(1, 1000)

for (n in primes){ println "   " + n }
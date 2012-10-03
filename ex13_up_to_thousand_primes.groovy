def pf = new PrimeFinder()

println "Here are the prime numbers up to 1000..."
int[] primes = pf.range(2, 1000)

for (n in primes){ println "   " + n }
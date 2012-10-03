class PrimeFinder{
    protected def known_primes
    protected int primes_known_upto
    
    PrimeFinder(){
        known_primes = []
        primes_known_upto = 1
    }
    
    boolean dirty_prime_checker(int number){
        for (i in 2..(number-1)){
            if (number%i == 0)
                return false
        }
        return true
    }
    
    boolean isPrime(int test_number){
        // Number must be greater than 1
        if (test_number < 2)
            throw new BadNumber(test_number)
        
        // See if any already-known primes
        // are factors
        for (known_prime in known_primes){
            if (known_prime > test_number / 2)
                break
            if (test_number % known_prime == 0)
                return false
        }
        
        // Now check for all larger factors
        if (primes_known_upto + 1 < test_number / 2){
            for (divisor in (primes_known_upto + 1)..(test_number / 2)) {
                if (test_number % divisor == 0)
                    return false
            }
        }
        
        return true
    }
    
    int[] range(int min_val, int max_val){
        def primes = []
        
        if (max_val > primes_known_upto)
            findUpto(max_val)
        
        // Find primes in the given range
        for (known_prime in known_primes){
            if (known_prime > max_val)
                break
            if (known_prime >= min_val)
                primes.add(known_prime)
        }
        
        return primes
    }
    
    int[] range(int max_val){
        return range(0, max_val)
    }
    
    void findUpto(int new_max){
        // Calculates all prime numbers up to the new_max
        
        // Ensure the new maximum is larger than 1.
        if (new_max < 2)
            throw new BadNumber(new_max)
            
        // Now find primes between the old max 
        // (primes_known_upto) and new_max
        for (test_number in (primes_known_upto + 1)..new_max) {
            if (isPrime(test_number)) {
                // Add this prime to our list of known primes
                // to make future searches faster
                known_primes.add(test_number)
            }
            primes_known_upto = test_number
        }
        
    }
    
    void findFirstNPrimes(int n) {
        // Calculates the first n prime numbers
        
        // Ensure the number of primes exceeds 0
        if (n < 1)
            throw new BadNumber(new_max)
            
        // If n prime numbers are already known,
        // there's nothing left to do.
        while(n > known_primes.size()) {
            primes_known_upto += 1
            if (isPrime(primes_known_upto)) {
                // Add this prime to our list of known primes
                known_primes.add(test_number)
            }
        }
        
    }
    
    int[] cardinalRange(int n) {
        // Returns the first n prime numbers
        return cardinalRange(1, n)
    }
    
    int[] cardinalRange(int n1, n2) {
        // Returns the n1st, (n1+1)st, (n1+2)st, ... , n2st
        // prime numbers
        
        // Check that n1 is sane
        if (n1 < 1)
            throw new BadNumber(n1)
            
        // Find the first n2 prime numbers (and check n2 is sane)
        findFirstNPrimes(n2)
        
        return known_primes[(n1-1)..(n2-1)]
    }
    
}
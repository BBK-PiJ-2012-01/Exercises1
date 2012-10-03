class BadNumber extends Exception{
    BadNumber(int value){
        println "Value of " + value + " is not appropriate"
    }
    
    BadNumber(){
        println "Value of number was not set!"
    }
}




class PrimeFinder{
    private def known_primes
    private int primes_known_upto
    
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
        
        // Ensure the new maximum is larger than 1.
        if (new_max < 2)
            throw new BadNumber(new_max)
            
        // Now find primes between the old max 
        // (primes_known_upto) and new_max
        int divisor
        for (test_number in (primes_known_upto + 1)..new_max) {
            if (isPrime(test_number)) {
                // Add this prime to our list of known primes
                // to make future searches faster
                known_primes.add(test_number)
            }
            primes_known_upto = test_number
        }
        
    }
    
}

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

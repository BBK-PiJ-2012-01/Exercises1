import groovy.time.*


float calculatePiWithN(int n) {
    double pi_over_four = 0
    for (k in 0..n) {
        pi_over_four += (-1)**k/(2*k+1)
    }
    return pi_over_four * 4
}

void calculatePiToNSigFig(int n) {
    /*
    *    Iterates until pi value is stable up to precision of n
    *    for at least 100 iterations.
    *
    *    If the stable pi value is different to the given value,
    *    then print "Failure!".  Otherwise say how many iterations
    *    and how much time it took to calculate.
    */
    double pi=0, old_pi_rounded=-1, real_pi=((double)3.14159265358).round(n)
    int stable_for=0, stable_at
    int k = 0
    def start_time = new Date()
    
    println "\nHow large must n be for pi to be correct to " + n + "d.p.? "
    
    while (true) {
        pi += 4*(-1)**k/(2*k+1)
        if (pi.round(n) == old_pi_rounded)
            stable_for++
        else {
            stable_for = 0
            stable_at = k
        }
        if (stable_for > 100)
            break
        k++
        old_pi_rounded = pi.round(n)
    }

    pi = pi.round(n)
    TimeDuration duration = TimeCategory.minus(new Date(), start_time)
    
    if (pi==real_pi)
        println "Success!  It took " + k + " iterations (" + duration + ") to be accurate to " + n + "d.p."
    else
        println "Failure!  From our calculations, pi = " + pi + " , but actually p = " + real_pi

        println ""
}

print "Enter the number of terms in the series to evaluate: "

int n = IOGeneric.getNumberFromUser()
if (n < 2)
    throw new BadInput(n)
    
String result = calculatePiWithN(n)
IOGeneric.printResult(result)

for (i in 2..9) {calculatePiToNSigFig(i)}
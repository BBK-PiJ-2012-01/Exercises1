int getNumberFromUser(){
    int num
    try {
        String str = System.console().readLine()
        num = Integer.parseInt(str)
    } catch(all) {
        throw new BadNumber()
    }
    
    if (num<2)
        throw new BadNumber()
        
    return num
}

float calculatePiWithN(int n) {
    double pi_over_four = 0
    for (k in 0..n) {
        pi_over_four += (-1)**k/(2*k+1)
    }
    return pi_over_four * 4
}

def calculatePiToNSigFig(int n) {
    double pi=0, old_pi=-1, real_pi=3.14159265358
    int stable_for=0, stable_at
    int k = 0
    while (true) {
        pi += 4*(-1)**k/(2*k+1)
        if (pi.round(n+2) == old_pi.round(n+2))
            stable_for++
        else {
            stable_for = 0
            stable_at = k
        }
        if (stable_for > 100)
            break
        k++
    }
    println "real_pi = " + real_pi + " , calculated pi = " + pi
    pi = pi.round(n)
    return [calculated:pi, stable_at:stable_at, success:(pi==real_pi.round(n))]
}

print "Enter the number of terms in the series to evaluate: "


String result = calculatePiWithN( getNumberFromUser() )

println '-'.multiply( result.length() )
println result
println '-'.multiply( result.length() )

println "\nHow large must n be for pi to be correct to 2d.p.? "
pi_results = calculatePiToNSigFig(2)
if 
println "It took n=" + 

println "\nHow large must n be for pi to be correct to 9d.p.? "
println "It took n=" + calculatePiToNSigFig(9)
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

int calculatePiToNSigFig(int n) {
    if (n > 11)
        throw new BadNumber(n)
    double real_pi = ((double)3.14159265358).round(n)
    double pi = 0
    int k = 0
    while (true) {
        pi += 4*(-1)**k/(2*k+1)
        if (pi.round(n) == real_pi)
            break
        k++
    }
    return k
}

print "Enter the number of terms in the series to evaluate: "


String result = calculatePiWithN( getNumberFromUser() )

println '-'.multiply( result.length() )
println result
println '-'.multiply( result.length() )

print "\nHow large must n be for pi to be correct to 2d.p.? "
println calculatePiToNSigFig(2)

print "\nHow large must n be for pi to be correct to 9d.p.? "
println calculatePiToNSigFig(9)
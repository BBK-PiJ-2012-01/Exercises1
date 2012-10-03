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

println "Enter the first number: "
int num1 = getNumberFromUser()

println "Enter the second number: "
int num2 = getNumberFromUser()

int div = num1.div(num2)
String result = num1 + " / " + num2 + " = " + div + ", remainder " + (num1 - div * num2)
println '-'.multiply( result.length() )
println result
println '-'.multiply( result.length() )
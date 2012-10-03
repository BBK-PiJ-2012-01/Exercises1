class BadNumber extends Exception{
    BadNumber(int value){
        println "Value of " + value + " is not appropriate"
    }
    
    BadNumber(){
        println "Value of number was not set!"
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

println "Enter the first number: "
int num1 = getNumberFromUser()

println "Enter the second number: "
int num2 = getNumberFromUser()

println "Enter the third number: "
int num3 = getNumberFromUser()

int[] sorted_list = [num1, num2, num3].sort()

String result = ""
for (i in 0..2){
    result += sorted_list[i] + " , "
}
println '-'.multiply( result.length() )
println result
println '-'.multiply( result.length() )
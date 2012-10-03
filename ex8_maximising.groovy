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

println "Give me some numbers and I'll give you back the largest of them: "

int max_num, current_num

while(true) {
    current_num = getNumberFromUser()
    if (current_num > max_num)
        max_num = current_num
    else if (current_num == -1)
        break
} 

result = "Largest number was " + max_num

println '-'.multiply( result.length() )
println result
println '-'.multiply( result.length() )
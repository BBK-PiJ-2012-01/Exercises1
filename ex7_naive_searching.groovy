println "Enter the first number: "
int num1 = IOGeneric.getNumberFromUser()

println "Enter the second number: "
int num2 = IOGeneric.getNumberFromUser()

println "Enter the third number: "
int num3 = IOGeneric.getNumberFromUser()

int[] sorted_list = [num1, num2, num3].sort()

String result = ""
for (i in 0..2){
    result += sorted_list[i] + " , "
}

IOGeneric.printResult(result)
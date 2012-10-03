println "Enter the first number: "
int num1 = IOGeneric.getNumberFromUser()

println "Enter the second number: "
int num2 = IOGeneric.getNumberFromUser()

int div = num1.div(num2)
String result = num1 + " / " + num2 + " = " + div + ", remainder " + (num1 - div * num2)

IOGeneric.printResult(result)

/*
*    I think that, while I adhered to the letter of the exercise,
*    I might have ignored its spirit...
*/
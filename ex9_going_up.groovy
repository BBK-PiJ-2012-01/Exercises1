println "Give me consecutive numbers up.  Type -1 to end."

int last_num = IOGeneric.getNumberFromUser(), current_num
String result = "Yes"

while(true) {
    current_num = IOGeneric.getNumberFromUser()
    if (current_num == -1)
        break
    if (current_num - last_num != 1)
        result = "No"
    last_num = current_num
} 

IOGeneric.printResult(result)
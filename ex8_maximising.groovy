println "Give me some numbers and I'll give you back the largest of them: "

int max_num, current_num

while(true) {
    current_num = IOGeneric.getNumberFromUser()
    if (current_num > max_num)
        max_num = current_num
    else if (current_num == -1)
        break
} 

result = "Largest number was " + max_num

IOGeneric.printResult(result)
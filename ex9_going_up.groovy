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

int last_num = getNumberFromUser(), current_num
String result = "Yes"

while(true) {
    current_num = getNumberFromUser()
    if (current_num == -1)
        break
    if (current_num - last_num != 1)
        result = "No"
    last_num = current_num
} 

println '-'.multiply( result.length() )
println result
println '-'.multiply( result.length() )
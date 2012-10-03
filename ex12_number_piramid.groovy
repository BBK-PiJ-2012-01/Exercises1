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

println "How many lines should be in the pyramid? (max 9)"
int max_lines = getNumberFromUser()
println "-"*max_lines

if (max_lines < 1 || max_lines > 9)
    throw new BadNumber(max_lines)
    
String str

for (i in 1..max_lines){
    str = i
    println str*i
}

println "-"*max_lines
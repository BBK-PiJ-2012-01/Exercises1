print "How many lines should be in the pyramid? (max 9) "
int max_lines = IOGeneric.getNumberFromUser()
println "-"*max_lines

if (max_lines < 1 || max_lines > 9)
    throw new BadInput(max_lines)
    
String str

for (i in 1..max_lines){
    str = i
    println str*i
}

println "-"*max_lines
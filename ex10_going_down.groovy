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

enum Sequence {
    up, down, bad, undefined, empty
}

int last_num, current_num
Sequence direction = Sequence.empty


while(true) {
    current_num = getNumberFromUser()
    if (current_num == -1)
        break
    else if (direction == Sequence.undefined) {
        difference = current_num - last_num
        if (difference == 1)
            direction = Sequence.up
        else if (difference == -1)
            direction = Sequence.down
        else
            direction = Sequence.bad
    } else if (direction == Sequence.empty)
        direction = Sequence.undefined
    else if (direction == Sequence.up && current_num - last_num != 1)
        direction = Sequence.bad
    else if (direction == Sequence.down && current_num - last_num != -1)
        direction = Sequence.bad
    else
        println "... fine ..."
        
    last_num = current_num
} 

String result

// If the user puts only one number in, it is not a sequence.
// Therefore I think it should be a failure:
if ([Sequence.bad, Sequence.empty, Sequence.undefined].contains(direction))
    result = "No"
else
    result = "Yes"

println '-'.multiply( result.length() )
println result
println '-'.multiply( result.length() )
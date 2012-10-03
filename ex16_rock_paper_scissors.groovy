class BadPlay extends BadNumber {}

def getPlayFromUser(){
    
    
    return num
}

class Choice implements Comparable<Choice> {
    static Order = [R:0, P:1, S:2]
    int value
    
    Choice(String character) {
        try {
            value = Choice.Order[character]
        } catch(all) {
            throw new BadPlay(character)
        }
    }
    
    int compareTo(Choice other) {
        if (other.value == (value+1)%3)
            return -1
        if ((other.value+1)%3 == value)
            return 1
        if (other.value == value)
            return 0
    }
}

class Game {
    int p1score=0, p2score=0
    int winner = 0
    
    int play(String str) {
        Choice p1 = new Choice(str[0])
        Choice p2 = new Choice(str[1])
        
        if (p1>p2) {
            p1score++
            if (p1score == 3)
                winner = 1
        } else if (p1<p2) {
            p2score++
            if (p2score == 3)
                winner = 2
        }
        return winner
    }
    
    void playFromKeyboard() {
        while(winner == 0) {
            print "Enter the play: "
            String str = System.console().readLine().toUpperCase()
            if (str.size() != 2)
                throw new BadPlay(str)
            play(str)
        }
        println "Player " + winner + " won!!"
    }
    
}


g = new Game()
g.playFromKeyboard()
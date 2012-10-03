class BadPlay extends BadInput {}


class Choice implements Comparable<Choice> {
    /*
    *    Any one person's choice in one game (eg. rock).
    *    It can be compared to another choice to see who
    *    wins the game (ie. winner > loser).
    */
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
    /*
    *    Stores the player scores and takes their inputs,
    *    and announces the winner.
    */
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
        while (winner == 0) {
            print "Enter the play: "
            String str = System.console().readLine().toUpperCase()
            if (str.size() != 2)
                throw new BadPlay(str)
            play(str)
        }
        announceWinner()
    }
    
    void playFromFile(String filename) {
        File file = new File(filename)
        
        // Each line of size 2 is passed to play.
        file.eachLine { line -> 
            if (line.size() >= 2)
                play(line[0..1]) 
        }
        announceWinner()
    }
    
    void announceWinner() {
        if (winner == 0)
            println "No winner... player 1: " + p1score + ", player 2: " + p2score
        else
            println "Player " + winner + " won!!"
    }
    
}


g = new Game()
println "If playing from file, enter filename (eg. 'play.txt')."
print  "Otherwise press enter: "
String str = System.console().readLine()
if (str.size() == 0)
    g.playFromKeyboard()
else
    g.playFromFile(str)
import java.lang.NumberFormatException


class BadInput extends Exception{
    BadInput(def value){
        println "Input of " + value + " is not appropriate"
    }
    
    BadInput(){
        println "No input given!"
    }
}


class Card{
    static def RankValues = [J:11, Q:12, K:13, A:1]
    static def Suits = [spades:0, hearts:1, diamonds:2, clubs:3]
    
    int suit, rank
    Card(int new_suit, int new_rank){
        suit = new_suit
        rank = new_rank
    }
    
    int getSuit(){
        return suit
    }
    
    int getRank(){
        return rank
    }
    
    boolean equals(Card other_card){
        return (suit == other_card.getSuit() && rank == other_card.getRank())
    }
}


class Hand{
    // Hand contains cards and statistical information on them
    // (and the methods to get it)
    def cards
    def sorted_ranks, ranks_with_high_ace, conforming_ranks
    def sorted_suits
    int max_conforming_suits
    boolean ranks_consecutive
    
    String trick = ""
    
    Hand(def new_cards){
        cards = new_cards
        sorted_ranks = (new_cards*.getRank()).sort()
        
        int number_of_aces = sorted_ranks.count(Card.RankValues["A"])
        ranks_with_high_ace = sorted_ranks[number_of_aces..sorted_ranks.size()-1] + [14]*number_of_aces
        
        sorted_suits = (new_cards*.getSuit()).sort()
    }
    
    void computeRankConsecutivity(){
        // Create a sequential list from lowest rank to highest
        int[] sequential_ranks = sorted_ranks[0]..sorted_ranks[-1]
        // If the ranks are consecutive, then it should equal this sequence:
        ranks_consecutive = (sorted_ranks == sequential_ranks)
        // If it wasn't consecutive, try again with aces high:
        if (!ranks_consecutive){
            sequential_ranks = ranks_with_high_ace[0]..ranks_with_high_ace[-1]
            ranks_consecutive = (ranks_with_high_ace == sequential_ranks)
        }
        
        //println "Rank consecutivity = " + ranks_consecutive
    }
    
    void computeRankConformity(){
        // Conforming_ranks is a vector containing the first modal rank,
        // then the second modal rank, and the third etc...
        conforming_ranks = []
        for (rank in sorted_ranks.toSet()){
            // This could be improved...
            conforming_ranks.add(sorted_ranks.count(rank.value))
        }
        conforming_ranks = conforming_ranks.sort().reverse()
        
        //println "Rank conformity = " + conforming_ranks
    }
    
    void computeSuitConformity(){
        // How many times does the modal suit appear?
        max_conforming_suits = 1
        int current_count
        for (suit in sorted_suits.toSet()){
            current_count = sorted_suits.count(suit)
            if (current_count > max_conforming_suits)
                max_conforming_suits = current_count
        }
        
        //println "Suit conformity = " + max_conforming_suits
    }
}


class HandPicker extends Hand{
    // Extends 'Hand' with the ability to interpret the
    // statistical information within a 'Hand' object
    // and decide on the best hand.
    HandPicker(def new_cards){
        super(new_cards)
        
        computeRankConsecutivity()
        computeRankConformity()
        computeSuitConformity()
        
        if (max_conforming_suits == 5 && ranks_consecutive)
            trick = "Straight Flush"
        else if (conforming_ranks[0] >= 4)
            trick = "Poker"
        else if (conforming_ranks[0..1] == [3, 2] && checkForFullHouse())
            trick = "Full House"
        else if (max_conforming_suits == 5 && !ranks_consecutive)
            trick = "Flush"
        else if (ranks_consecutive)
            trick = "Straight"
        else if (conforming_ranks[0] == 3)
            trick = "Three of a kind"
        else if (conforming_ranks[0..1] == [2,2])
            trick = "Two Pairs"
        else if (conforming_ranks[0] == 2)
            trick = "Pair"
        else
            trick = "Nothing"
    }
    
    boolean checkForFullHouse(){
        def Set1 = [cards[0]], Set2 = []
        
        for (card in cards[1..4]){
            if (Set1[0].equals(card))
                Set1.add(card)
            else if (Set2.size() == 0)
                Set2.add(card)
            else if (Set2[0].equals(card))
                Set2.add(card)
            else
                return false
        }
        
        println "One set has " + Set1.size() + " and the other has " + Set2.size()
        if ([Set1.size(), Set2.size()].sort() == [2,3])
            return true
        else
            return false
    }
}
           

class IOClass{
    // Handles user input/output with the above classes.
    HandPicker hand
    
    IOClass(){
        hand = getHandFromUser()
        printResult(hand.trick)
    }

    Card getCardFromUser(){
        println "Enter card rank: (2 - 10, J, Q, K, A)"
        String str
        int rank
        try {
            str = System.console().readLine().toUpperCase()
            rank = Integer.parseInt(str)
        
            if (rank < 2 || rank > 10)
                throw new BadInput(rank)
        } catch(NumberFormatException) {
            if (Card.RankValues.keySet().contains(str))
                rank = Card.RankValues[str]
            else
                throw new BadInput(str)
        }
        
        
        println "Enter card suit: (spades, clubs, hearts, diamonds)"
        int suit
        str = System.console().readLine().toLowerCase()
        if (Card.Suits.containsKey(str))
            suit = Card.Suits[str]
        else
            throw new BadInput()
        
        return new Card(suit, rank)
    }
    
    
    Hand getHandFromUser(){
        println "Give me five cards!"
        
        def cards = []
        for (i in 0..4){
            println "========= " + (i+1) + " ========="
            cards.add( getCardFromUser() )
            //cards.add( new Card(i%4, i+1) )
        }
        return new HandPicker(cards)
    }


    def printResult(String result) {
        println ""
        println '-'.multiply( result.length() )
        println result
        println '-'.multiply( result.length() )
    }
    
}

io = new IOClass()


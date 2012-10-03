class IOGeneric {
    /*
    *    Generic user input/output class used in many exercises.
    */
    static int getNumberFromUser(){
        int num
        try {
            String str = System.console().readLine()
            num = Integer.parseInt(str)
        } catch(all) {
            throw new BadInput()
        }
        return num
    }
    

    static void printResult(String result) {
        println '-'.multiply( result.length() )
        println result
        println '-'.multiply( result.length() )
    }
}


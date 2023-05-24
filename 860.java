class Solution {
    public boolean lemonadeChange(int[] bills) {
        int numFives = 0;
        int numTens = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                numFives++;
            } else if (bill == 10) {
                if (numFives == 0) {
                    return false;
                }
                numFives--;
                numTens++;
            } else { // bill == 20
                if (numTens > 0 && numFives > 0) {
                    numTens--;
                    numFives--;
                } else if (numFives >= 3) {
                    numFives -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}

class Solution {
    public int maximum69Number (int num) {
        // Convert the number to a string for easier manipulation
        String strNum = Integer.toString(num);
        // Loop through the string and replace the first 6 with a 9
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) == '6') {
                // Replace the first 6 with a 9 and return the result
                return Integer.parseInt(strNum.substring(0, i) + '9' + strNum.substring(i+1));
            }
        }
        // If no 6 was found, return the original number
        return num;
    }
}

class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int i = 0, n = word.length();
        while (i < n) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                int j = i + 1;
                while (j < n && Character.isDigit(word.charAt(j))) {
                    j++;
                }
                String num = word.substring(i, j);
                num = num.replaceAll("^0+", ""); // remove leading zeros
                set.add(num);
                i = j;
            } else {
                i++;
            }
        }
        return set.size();
    }
}

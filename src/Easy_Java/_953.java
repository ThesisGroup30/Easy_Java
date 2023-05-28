package Easy_Java;

public class _953 {
	public boolean isAlienSorted(String[] words, String order) {
        int[] charOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (charOrder[word1.charAt(j) - 'a'] > charOrder[word2.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
                if (j == minLength - 1 && word1.length() > word2.length()) {
                    return false;
                }
            }
        }
        return true;
    }
}

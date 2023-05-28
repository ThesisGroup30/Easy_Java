package Easy_Java;

public class _709 {
	public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') { // check if the character is uppercase
                sb.append((char)(c + 32)); // add the lowercase version to the StringBuilder
            } else {
                sb.append(c); // add the original character if it's not uppercase
            }
        }
        return sb.toString();
    }
}

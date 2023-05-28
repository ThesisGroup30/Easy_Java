package Easy_Java;

import java.util.Stack;

public class _682 {
	public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String op : operations) {
            switch (op) {
                case "C":
                    sum -= stack.pop();
                    break;
                case "D":
                    int doubleScore = 2 * stack.peek();
                    stack.push(doubleScore);
                    sum += doubleScore;
                    break;
                case "+":
                    int lastScore = stack.pop();
                    int secondLastScore = stack.peek();
                    int newScore = lastScore + secondLastScore;
                    stack.push(lastScore);
                    stack.push(newScore);
                    sum += newScore;
                    break;
                default:
                    int score = Integer.parseInt(op);
                    stack.push(score);
                    sum += score;
            }
        }
        return sum;
    }
}

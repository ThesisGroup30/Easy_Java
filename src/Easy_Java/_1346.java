package Easy_Java;

import java.util.HashSet;
import java.util.Set;

public class _1346 {
	public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (seen.contains(2 * arr[i]) || (arr[i] % 2 == 0 && seen.contains(arr[i] / 2))) {
                return true;
            }
            seen.add(arr[i]);
        }
        return false;
    }
}

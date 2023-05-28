package Easy_Java;

import java.util.Collections;
import java.util.PriorityQueue;

public class _1046 {
	public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.add(Math.abs(x - y));
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}

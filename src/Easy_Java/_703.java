package Easy_Java;

import java.util.PriorityQueue;

public class _703 {
	private int k;
    private PriorityQueue<Integer> minHeap;

    public _703(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

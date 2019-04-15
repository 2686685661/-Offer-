package 树.数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	public int count = 0;
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			return i2 - i1;
		}
	});

	public void Insert(Integer num) {
		if(count % 2 == 0) {  //当数据总数为偶数时，新加入的元素，应当进入小根堆
			//（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
			//1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
			maxHeap.offer(num);
			int filterMaxNum = maxHeap.poll();
			//2.筛选后的【大根堆中的最大元素】进入小根堆
			minHeap.offer(filterMaxNum);
		}
		else {  //当数据总数为奇数时，新加入的元素，应当进入大根堆
			//（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
			//1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
			minHeap.offer(num);
			int filerMinNum = minHeap.poll();
			//2.筛选后的【小根堆中的最小元素】进入大根堆
			maxHeap.offer(filerMinNum);
		}

		count++;
	}

	public Double GetMedian() {

		if(count % 2 == 0) {
			return new Double((minHeap.peek() + maxHeap.peek())) / 2;
		}
		else {
			return new Double(minHeap.peek());
		}
	}
}

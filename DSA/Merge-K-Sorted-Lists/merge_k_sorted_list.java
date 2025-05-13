/*
 * Compared to merge to 2 sorted lists, we cant have n pointers to n lists. So can have two apporaches
 * 1. Add all elements to an arrayList and sort.
 * 2. Add all elements to a priority queue
 * Focus on approach two 
 * Plan 
 * 1. Create a minHeap 
 * 2. For each element in all the lists. Add towards the minHeap.
 * 3. Return minHeap as arraylist
 * 
 * After looking at problem again, we
 */

import java.util.PriorityQueue;

public class merge_k_sorted_list{

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> minQueue = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode root: lists){
            minQueue.add(root); 
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cursor = dummyNode; //cursor.next == null
        while(!minQueue.isEmpty()){ //{3,3,6}
            cursor.next = minQueue.poll();// 2
            cursor = cursor.next; //2 -> 3
            if(cursor.next != null)
                minQueue.add(cursor.next);
        
        }
        
        return dummyNode.next;
        
        }
 }
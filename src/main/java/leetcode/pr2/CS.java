
package leetcode.pr2;

import java.util.HashMap;
import java.util.Map;

public class CS  {
        public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Map<Integer,Integer> map = new HashMap<>();
            ListNode first = l1;
            ListNode second = l2;
            int keyIdx = 0;
            while (first != null || second != null){
                int val1 = 0;
                int val2 = 0;
                if (first != null){
                    val1 = first.val;
                    first = first.next;
                }
                if (second != null){
                    val2 = second.val;
                    second = second.next;
                }
                int sum = val1 + val2;
                map.put(keyIdx++,sum);
            }
            int idx = 0;
            while(idx < keyIdx){
                int val = map.get(idx) ;
                map.put(idx,val % 10);
                int pt = idx + 1;
                while(keyIdx >= pt && val >= 10){
                    if(keyIdx == pt){
                        map.put(pt,1);
                        break;
                    }
                    val = map.get(pt) + 1;
                    map.put(pt++,val % 10);
                }
                idx++;
            }


            int pt = 1;
            ListNode head = new ListNode(map.get(0));
            ListNode curr = head;
            while (map.containsKey(pt)){
                curr.next = new ListNode(map.get(pt++));
                curr = curr.next;
            }
            return head;
        }
    }
}


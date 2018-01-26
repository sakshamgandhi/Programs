
//running median

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.PriorityQueue;
import java.util.regex.*;
class Solution{
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public Solution(){
        max =new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void insert(Integer num) {
        if(max.peek() == null || num.compareTo(max.peek()) < 0) 
        max.add(num);
        else min.add(num);
        if(max.size() - min.size() > 1) min.add(max.remove());
        if(min.size() - max.size() > 1) max.add(min.remove());
    }
    public void findMedian() {
        if(max.size() == min.size()) System.out.println((double)(max.peek() + min.peek())/2);
        else if(max.size() > min.size()) System.out.println((double)max.peek());
        else System.out.println((double)min.peek());
    }
    public static void main(String args[] ) throws Exception {
        Solution sol = new Solution();
        Scanner s = new Scanner(System.in); 
        int n = s.nextInt();
        for(int i = 0; i < n; i++) {
            sol.insert(s.nextInt());
            sol.findMedian();
        }
    }
}

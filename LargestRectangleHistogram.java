/*
Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

For example,
Given height = [2,1,5,6,2,3],
return 10.

*/


public class LargestRectangleHistogram {
    int maxArea = -1;
    public int largestRectangleArea(ArrayList<Integer> A) {
        int maxArea = -1;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while(i < A.size()) {
            if (stack.isEmpty() || A.get(stack.peek()) <= A.get(i)) {
                stack.push(i++);
            }
            else {
                int currentBarIndex = stack.pop();
                int tempArea = A.get(currentBarIndex) * (stack.isEmpty() ? i  : (i-stack.peek()-1));
                maxArea = Math.max(maxArea, tempArea);
            }
        }
        if (stack.isEmpty()) return maxArea;
        else {
            while(!stack.isEmpty()) {
                int currentBarIndex = stack.pop();
                int tempArea = A.get(currentBarIndex) * (stack.isEmpty() ? i  : (i-stack.peek()-1));
                maxArea = Math.max(maxArea, tempArea);
            }
            return maxArea;
        }
    }
}

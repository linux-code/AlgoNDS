/*

Given an array, find the nearest smaller element G[i] for every element A[i] in the array 
such that the element has an index smaller than i.

Elements for which no smaller element exist, consider next smaller element as -1.

Example:

Input : A : [4, 5, 2, 10, 8]
Return : [-1, 4, -1, 2, 2]

Example 2:

Input : A : [3, 2, 1]
Return : [-1, -1, -1]

*/

class Pair {
    int num;
    Pair prevMin;
}

public class NearestSmallerElement {
    
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Stack<Pair> stack = new Stack<Pair>();
        for (int i = 0; i<A.size(); i++) {
            answer.add(-1);
            Pair pair = new Pair();
            pair.num = A.get(i);
            pair.prevMin = null;
            if (stack.isEmpty()) {
                stack.push(pair);
            }
            else {
                Pair temp = stack.peek();
                while(temp !=null) {
                    if (temp.num < A.get(i)){
                        answer.set(i, temp.num);
                        pair.prevMin = temp;
                        stack.push(pair);
                        break;
                    }
                    temp = temp.prevMin;
                }
                if (temp == null)  stack.push(pair);
            }
        }
        return answer;
    }
}

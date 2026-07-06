class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int nsl[] = new int[n];
        int nsr[] = new int[n];

        // Next Smaller Right
        Stack<Integer> s = new Stack<>();

        for(int i = n - 1; i>=0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }

            nsr[i] = (s.isEmpty()) ? n : s.peek();
            s.push(i);
        }

        //Next Smaller Left
        s = new Stack<>();

        for(int i = 0; i<n; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }

            nsl[i] = (s.isEmpty()) ? -1 : s.peek();
            s.push(i);
        }


        // Current Area
        for(int i = 0; i<n; i++){
            int width = nsr[i] - nsl[i] - 1;
            int currArea = heights[i] * width;

            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
}
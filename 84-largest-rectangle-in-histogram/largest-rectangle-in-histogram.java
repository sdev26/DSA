class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int maxHeight=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<=n;i++){
            int currHeight=(i==n)?0:arr[i];
            while(!st.isEmpty()&& currHeight<=arr[st.peek()]){
                int width=arr[st.pop()];
                int right=i;
                int left=(st.size()==0)?-1:st.peek();
                int height=right-left-1;
                maxHeight=Math.max(maxHeight,width*height);
            }
            st.push(i);
        }
        return maxHeight;
    }
}
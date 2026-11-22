class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix[0].length;
        int heights[]=new int[n];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1')
                    heights[j]++;
                else
                    heights[j]=0;
            }
            max=Math.max(max,rectangle(heights));
        }
        return max;
    }
    public int rectangle(int []heights){
        int n=heights.length;
        int stack[]=new int[n+1];
        int top=-1,max=0;
        for(int i=0;i<=n;i++){
            int curr=(i==n)?0:heights[i];
            while(top>=0&&heights[stack[top]]>curr){
                int h=heights[stack[top--]];
                int left=(top==-1)?-1:stack[top];
                int width=i-left-1;
                max=Math.max(max,h*width);
            }
            if(i<n)
                stack[++top]=i;
        }
        return max;
    }
}
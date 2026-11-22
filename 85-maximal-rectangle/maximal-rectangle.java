class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n=matrix[0].length;
        int height[]=new int[n];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]=='1')
                        height[j]++;
                    else
                        height[j]=0;
            }
            max=Math.max(max,rectangle(height));
        }
        return max;
    }
    public int rectangle(int[]height){
        int n=height.length;
        int stack[]=new int[n+1];
        int top=-1,max=0;
        for(int i=0;i<=n;i++){
             int curr=(i==n)?0:height[i];
            while(top>=0&&height[stack[top]]>curr){
               int h=height[stack[top--]];
               int left=(top==-1)?-1:stack[top];
               int width=i-left-1;
               max=Math.max(max,width*h);
            }
            if(i<n)
                stack[++top]=i;
        }
        return max;
    }
}
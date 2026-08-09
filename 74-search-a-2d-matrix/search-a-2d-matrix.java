class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int m=matrix.length,n=matrix[0].length;
        int low =0;
        int high=m*n-1;
       
        return binSearch(matrix,low ,high,target);
    }
    public boolean binSearch(int [][]arr,int low ,int high, int target){
        if(low>high)return false;
         int mid=low+(high-low)/2;
        int m=arr.length,n=arr[0].length;
        int r=mid/n,c=mid%n;
        if(arr[r][c]==target){
            return true;
        }
       if (arr[r][c] > target) {
            return binSearch(arr, low, mid - 1, target);
        } else {
            return binSearch(arr, mid + 1, high, target);
        }

    }
}
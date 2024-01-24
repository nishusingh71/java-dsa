package Arrays;

public class MaxSubArray {
    public static void maxSumArray(int nums[])
    {
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int start=i;
            for(int j=i;j<nums.length;j++){
                int end=j;
                currSum=0;
                for(int k=start;k<=end;k++){
                    currSum+=nums[k];
                }
                System.out.println("currSum="+currSum);
                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
            System.out.println("maxSum="+maxSum);
        }
        
        
    }
    public static void main(String[] args) {
        int nums[]={1,-2,6,-1,3};
        maxSumArray(nums);
       
    }
}

package DivideAndConquer;

public class MajorityElement {
    //Brute force Approach-1
    public static int majorityElement(int[] nums){
        // int majorityCount=nums.length/2;
        // for(int i=0;i<nums.length;i++){
        //     int count=0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             count+=1;
        //         }
        //     }
        //     if(count>majorityCount){
        //         return nums[i];
        //     }
        // }
        // return -1;
        return majorityElementRec(nums, 0, nums.length-1);
    }

    //Approach 2- Divide&Conquer
    private static int countInRange(int [] nums,int num,int si,int ei){
       int count=0;
       for(int i=si;i<=ei;i++){
        if(nums[i]==num){
            count++;
        }
       } 
       return count;
    }
    public static int majorityElementRec(int[] nums,int si,int ei){
        if(si==ei){
            return nums[si];
        }
        int mid=(ei-si)/2+si;
        int left=majorityElementRec(nums, si, mid);
        int right=majorityElementRec(nums, mid+1, ei);
        if(left==right){
            return left;
        }
        int leftCount=countInRange(nums, right, si, ei);
        int rightCount=countInRange(nums, leftCount, mid+1, ei);
        return leftCount>rightCount?left:right;
        }
    public static void main(String[] args) {
        int nums[]={2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}

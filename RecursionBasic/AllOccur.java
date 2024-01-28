package RecursionBasic;

public class AllOccur {
    public static void allOcc(int arr[],int key,int i){
        //Base Case
        if(i==arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.print(i);
        }
        allOcc(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[]={3,2,4,5,6,2,7,2,2};
        allOcc(arr, 2, 0);
    }
}

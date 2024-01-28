package RecursionBasic;

public class FriendPairing {
    public static int friendPairing(int n){
        if(n==1||n==2){
            return n;
        }
        //choice 
        return friendPairing(n-1)+(n-1)*friendPairing(n-2);
    }
    public static void main(String[] args) {
        System.out.println(friendPairing(3));
    }
}

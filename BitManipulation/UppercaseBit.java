package BitManipulation;

public class UppercaseBit {
    public static void main(String[] args) {
        for(char ch='A';ch<='Z';ch++){
            // convert upper to lower case
            System.out.print((char)(ch|' '));
        }
    }
}

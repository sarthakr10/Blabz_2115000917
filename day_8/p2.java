import java.util.*;
public class p2{
    public static String rev(String str){
        char [] charArray = str.toCharArray();
        int right = 0;
        int left = charArray.length-1;
        while(left>right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left--;
            right++;
        }
        return new String(charArray); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        String reverse = rev(str);
        System.out.println("Reversed String is : "+reverse);
    }
}

package day_8;
import java.util.*;
public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.trim().toLowerCase();
        String vow = "aeiou";
        int c  = 0;
        ArrayList<Character> vowels = new ArrayList<>();
        for(int i = 0 ; i<vow.length(); i++){
            vowels.add(vow.charAt(i));
        }
        for(int i =0 ; i<str.length() ; i++){
            if(vowels.contains(str.charAt(i))){
                c++;
            }
        }
        System.out.println("Total number of vowels in the given string are : "+c);
        sc.close();
    }
}
public class p10 {
    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        String result = removeCharacter(input, charToRemove);
        System.out.println("Modified String : " + result);
    }

    public static String removeCharacter(String str, char ch) {
        return str.replace(Character.toString(ch), "");
    }
}
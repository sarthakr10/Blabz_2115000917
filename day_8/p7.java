public class p7 {
    public static void main(String[] args) {
        String input = "Hello World!";
        String toggled = toggleCase(input);
        System.out.println(toggled);
    }

    public static String toggleCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
            chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
            chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }
}
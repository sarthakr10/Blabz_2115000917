public class p7 {
    public static void main(String[] args) {
        String input = "Hello World!";
        String toggled = toggleCase(input);
        System.out.println(toggled);
    }

    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
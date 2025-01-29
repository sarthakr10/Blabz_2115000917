public class p8 {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";

        int result = compareStrings(str1, str2);

        if (result < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("\"" + str1 + "\" is equal to \"" + str2 + "\" in lexicographical order");
        }
    }

    public static int compareStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int lim = Math.min(len1, len2);

        for (int i = 0; i < lim; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return len1 - len2;
    }
}
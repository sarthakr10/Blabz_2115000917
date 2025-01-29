public class p6 {
    public static void main(String[] args) {
        String str = "hellohellohello";
        String subStr = "hello";
        int count = countOccurrences(str, subStr);
        System.out.println("The substring '" + subStr + "' occurs " + count + " times in the string.");
    }

    public static int countOccurrences(String str, String subStr) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }
        return count;
    }
}
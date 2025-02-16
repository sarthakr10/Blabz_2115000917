public class Concatenate {
    public static void main(String[] args) {
        String[] strings = {"Hello", " SRK ", " HOW YOU DOING ", "?"};
        String result = concatenateStrings(strings);
        System.out.println(result);
    }

    public static String concatenateStrings(String[] strings) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strings) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
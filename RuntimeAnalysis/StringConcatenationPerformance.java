public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int N = 1_000_000;
        String text = "hello";

        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += text;
        }
        long stringTime = System.nanoTime() - startTime;
        System.out.println("String Concatenation Time: " + stringTime / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(text);
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        System.out.println("StringBuilder Time: " + stringBuilderTime / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append(text);
        }
        long stringBufferTime = System.nanoTime() - startTime;
        System.out.println("StringBuffer Time: " + stringBufferTime / 1_000_000.0 + " ms");
    }
}


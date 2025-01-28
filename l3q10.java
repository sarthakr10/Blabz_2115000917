public class l3q10 {

    public static void main(String[] args) {
        int x1 = 2, y1 = 4;
        int x2 = 4, y2 = 6;
        int x3 = 6, y3 = 8;

        if (areCollinearUsingSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points are collinear using the slope method.");
        } else {
            System.out.println("The points are not collinear using the slope method.");
        }
    
            if (areCollinearUsingArea(x1, y1, x2, y2, x3, y3)) {
                System.out.println("The points are collinear using the area method.");
            } else {
                System.out.println("The points are not collinear using the area method.");
            }
    }
    
    public static boolean areCollinearUsingArea(int x1, int y1, int x2, int y2, int x3, int y3) {
            int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
            return area == 0;
    }
    

    public static boolean areCollinearUsingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        int slopeAB = (y2 - y1) * (x3 - x2);
        int slopeBC = (y3 - y2) * (x2 - x1);
        int slopeAC = (y3 - y1) * (x2 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }
}
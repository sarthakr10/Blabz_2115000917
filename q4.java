public class q4 {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        double profitPercentage = (double) profit / costPrice * 100;

        System.out.printf("The cost price is %d and selling price is %d%n The Profit is %d and the Profit Percentage is %.2f%%%n", costPrice, sellingPrice, profit, profitPercentage);
    }
}
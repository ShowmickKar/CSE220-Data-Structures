public class FinalQ {
    public static void main(String[] args) {
        int[] arr = {25000, 100000, 250000, 350000};
        print(arr, 0);
    }

    public static void print(int[] arr, int index) {
        if (index < arr.length) {
            double profit = calcProfit(arr[index]);
            System.out.println(index + 1 + ". Investment: " + arr[index] + "; Profit: " + profit);
            print(arr, index + 1);
        }
    }

    public static double calcProfit(int investment) {
        if (investment <= 25000) return 0;
        if (investment <= 100000) {
            return (double) 4.5 + calcProfit(investment - 100);
        }
        return (double) 8 + calcProfit(investment - 100);
    }
}

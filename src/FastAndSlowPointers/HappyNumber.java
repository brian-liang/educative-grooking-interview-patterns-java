package FastAndSlowPointers;

class HappyNumber {

    public static int sumOfSquaredDigits(int number) {
        int totalSum = 0;
        while (number != 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digit, 2));
        }
        return totalSum;
    }
    public static boolean isHappyNumber(int n) {
       int slow = n;
       int fast = sumOfSquaredDigits(n);

       while(fast != 1 && fast != slow){
           slow = sumOfSquaredDigits(slow);
           fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
       }

        return fast == 1;
    }

    public static void main(String args[]) {
        int a[] = {1, 5, 19, 25, 7};
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ".\tInput Number: " + a[i]);
            String output = isHappyNumber(a[i]) ? "True" : "False";

            System.out.println("\n\tIs it a happy number? " + output);
            System.out.println("-----------------------------------");
        }
    }
}
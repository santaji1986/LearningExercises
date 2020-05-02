public class PowerEvaluationUsingRecursion {

    public static void main(String[] args) {
        final int result = power(3, 3);
        System.out.println(result);
    }

    static int power(int a, int b) {
        if (b == 0) {
            return 1;
        } else {
            return a * power(a, b - 1);
        }
    }

}
// Recursion stack
// power(2,3) 8
// 2*power(2,2) 2*4
// 2*power(2,1) 2*2
// 2*power(2,0) 2*1

package chapter4;

public class Chapter4 {

    public static void main(String[] args) {
        System.out.println(sumOfNumbersFrom1ToN(1000));
    }
    
    public static char[] reverse(char[] toReverse){
        for ( int index = 0; index < toReverse.length / 2; index++ ){
            char temp = toReverse[index];
            toReverse[index] = toReverse[toReverse.length-1-index];
            toReverse[toReverse.length-1-index] = temp;
        }
        return toReverse;
    }
    

    // O(n^2) - quadratic
    public static int sumerOfNumbersFrom1ToNBad(int n){
        int sum = 0;
        for ( int current = 1; current <= n; current++){
            for ( int one = 1; one <= current; one++ ){
                sum++;
            }
        }
        return sum;
    }
    
    // O(n)
    public static int sumOfNumbersFrom1ToN(int n) {
        int sum = 0;
        for (int current = 1; current <= n; current++) {
            sum += current;
        }
        return sum;
    }

    // O(1)
    public static int sumOfNumbersFrom1ToNBetter(int n) {
        return n * (n + 1) / 2;
    }

}

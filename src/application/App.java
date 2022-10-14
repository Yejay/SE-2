package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Main application class.
 * 
 */
public class App {

    /**
     * Default constructor.
     */
    public App() {
    }

    /**
     * main() function.
     * 
     * @param args command line arguments passed to <i>main()</i>.
     */
    public static void main(String[] args) {
        int n = 1092;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException ex) {
            }
        }
        try {
            var app = new App();
            var factors = app.factorize(n);
            System.out.println("Hello, App!");
            System.out.println(String.format("n=%d factorized is: %s", n, factors.toString()));
            //
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Factorize a number into smallest prime factors.
     * <p>
     * Examples:
     * <pre>
     * n=27 -> [3, 3, 3]
     * n=1092 -> [2, 2, 3, 7, 13]
     * n=10952347 -> [7, 23, 59, 1153]
     * </pre>
     * @param n number to factorize
     * @return list of factors
     */
    public List<Integer> factorize(int n) {
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
}
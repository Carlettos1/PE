package com.carlettos.five;

import com.carlettos.core.PERun;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.</p>
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.</p>
 *
 * @author Carlos
 */
public class Problem4 extends PERun {

    @Override
    protected void run() {
        List<Integer> palindromos = new ArrayList<>();
        for (int x = 100; x < 1000; x++) {
            for (int y = 100; y < 1000; y++) {
                if(isPalindrome(x * y)){
                    palindromos.add(x * y);
                }
            }
        }
        System.out.println(palindromos.stream().reduce(0, Integer::max));
    }
    
    private boolean isPalindrome(int number){
        String n = String.valueOf(number);
        int len = n.length();
        int mitad = len / 2;
        for (int i = 0; i < mitad; i++) {
            if(n.charAt(i) != n.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }
}

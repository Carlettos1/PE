package com.carlettos.five;

import com.carlettos.core.PERun;

/**
 *  <p>If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.</p>
    <p>Find the sum of all the multiples of 3 or 5 below 1000.</p>
 * @author Carlos
 */
public class Problem1 extends PERun{

    @Override
    protected void run() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i % 5 == 0 | i % 3 == 0 ? i : 0;
        }
        System.out.println(sum);
    }
}

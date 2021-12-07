package com.carlettos.five;

import com.carlettos.core.PERun;

/**
 * <p>
 * The sum of the squares of the first ten natural numbers is,</p>
 * $$1^2 + 2^2 + ... + 10^2 = 385$$
 * <p>
 * The square of the sum of the first ten natural numbers is,</p>
 * $$(1 + 2 + ... + 10)^2 = 55^2 = 3025$$
 * <p>
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is $3025 - 385 = 2640$.</p>
 * <p>
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.</p>
 *
 * @author Carlos
 */
public class Problem6 extends PERun{

    @Override
    protected void run() {
        int max = 100;
        int sum_sq = 0;
        int sq_sum = 0;
        for (int i = 0; i <= max; i++) {
            sum_sq += i;
            sq_sum += i*i;
        }
        sum_sq = sum_sq* sum_sq;
        System.out.println(sum_sq - sq_sum);
    }
}

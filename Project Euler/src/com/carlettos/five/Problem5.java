package com.carlettos.five;

import com.carlettos.core.PERun;

/**
 * <p>
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.</p>
 * <p>
 * What is the smallest positive number that is
 * <dfn title="divisible with no remainder">evenly divisible</dfn> by all of the
 * numbers from 1 to 20?</p>
 *
 * @author Carlos
 */
public class Problem5 extends PERun {

    @Override
    protected void run() {
        //I think is faster doing the thinking in your mind that in the code, 
        //its just reducing the divisors of every number (adding every prime number)
        //between 1 and 20, so, 18 = 3*3*2, requieres 2 "3" and 1 "2",
        //so, if that condition is satisfied, you dont need to do anything,
        //but if it doesnt, you need to add at least 1 divisor to the multiplication
        // e.g., 9, when I think of 9, I think of 3*3, but you only have 1 "3", 
        //because its a prime, so, you need to add one more 3 to the list.
        //then you just multiply every number in the list.
        //the 2L its just because I'm afraid of overflowing the int.
        System.out.println(2L * 3 * 5 * 7 * 11 * 13 * 17 * 19 * 2 * 2 * 3 * 2);
    }
}

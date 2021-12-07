package com.carlettos.five;

import com.carlettos.core.PERun;

/**
 * <p>
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.</p>
 * <p>
 * What is the 10 001st prime number?</p>
 *
 * @author Carlos
 */
public class Problem7 extends PERun{

    @Override
    protected void run() {
        int stop = 10_001;
        long num = 2;
        
        //not worring about number 2
        num++;
        stop--;
        
        while (true) {
            if(isPrimo(num) && --stop == 0){
                break;
            }
            num+=2; // not worring about even numbers
        }
        System.out.println(num);
    }

    /**
     * doesn't include the number 2
     */
    private boolean isPrimo(long num) {
        long sq = (long)Math.sqrt(num) + 1;
        for (long i = 3; i <= sq; i+=2) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}

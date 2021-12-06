package com.carlettos.five;

import com.carlettos.core.PERun;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * The prime factors of 13195 are 5, 7, 13 and 29.</p>
 * <p>
 * What is the largest prime factor of the number 600851475143 ?</p>
 *
 * @author Carlos
 */
public class Problem3 extends PERun {

    @Override
    protected void run() {
        List<Long> divisores = getDivisores(600851475143L);
        long max = divisores.stream().filter(l -> getDivisores(l).isEmpty()).reduce(0L, Long::max);
        System.out.println(max);
    }

    private List<Long> getDivisores(long number) {
        List<Long> divisores = new ArrayList<>();
        double raiz = Math.sqrt(number) + 1;

        if (number % 2 == 0L) {
            divisores.add(2L);
        }
        for (long divisor = 3; divisor < raiz; divisor += 2) {
            if (number % divisor == 0L) {
                divisores.add(divisor);
            }
        }
        
        return divisores;
    }
}

package com.carlettos.fifteen;

import com.carlettos.core.PERun;
import com.carlettos.five.Problem7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * <p>
 * By replacing the 1<sup>st</sup> digit of the 2-digit number *3, it turns out
 * that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all
 * prime.</p>
 * <p>
 * By replacing the 3<sup>rd</sup> and 4<sup>th</sup> digits of 56**3 with the
 * same digit, this 5-digit number is the first example having seven primes
 * among the ten generated numbers, yielding the family: 56003, 56113, 56333,
 * 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of
 * this family, is the smallest prime with this property.</p>
 * <p>
 * Find the smallest prime which, by replacing part of the number (not
 * necessarily adjacent digits) with the same digit, is part of an eight prime
 * value family.</p>
 *
 * @author Carlos
 */
public class Problem51 extends PERun{
    private final char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
        'u', 'v', 'w', 'x', 'y', 'z'};

    @Override
    protected void run() {
        int digits = 6; //<- can be replaced by a for
        List<String> combinaciones = new ArrayList<>();
        //using the binary representation to generate the structures
        for (long i = 1; i < twoToThe(digits) - 1; i++) {
            combinaciones.add(format(Long.toBinaryString(i), digits));
        }
        
        Map<String, List<String>> combNum = new HashMap<>();
        
        for (String combinacion : combinaciones) {
            List<String> numeros = new ArrayList<>();
            boolean flag = false; //si ha pasado por el primer dígito != *
            //por cada dígito
            for (int i = 0; i < digits; i++) {
                if(combinacion.charAt(i) != '*'){
                    if(!flag){
                        flag = true;
                        for (int j = i == 0 ? 1 : 0; j < 10; j++) {
                            numeros.add(combinacion.replace(letras[i], String.valueOf(j).charAt(0)));
                        }
                    } else {
                        List<String> tmp = new ArrayList<>();
                        for (String numero : numeros) {
                            for (int j = 0; j < 10; j++) {
                                tmp.add(numero.replace(letras[i], String.valueOf(j).charAt(0)));
                            }
                        }
                        numeros = tmp;
                    }
                }
            }
            combNum.put(combinacion, numeros);
        }
        Map<String, List<Long>> primos = new HashMap<>();
        combNum.forEach((combinacion, numeros) -> {
            numeros.forEach(numero -> {
                for (int i = 0; i < 10; i++) {
                    Long num1 = Long.parseLong(numero.replaceAll("\\*", i + ""));
                    if(isPrimo(num1)){
                        if(!primos.containsKey(numero)){
                            List<Long> tmp = new ArrayList<>();
                            tmp.add(num1);
                            primos.put(numero, tmp);
                        } else {
                            primos.get(numero).add(num1);
                        }
                    }
                }
            });
        });
        Map<String, List<Long>> maximos = new HashMap<>();
        StringBuilder k = new StringBuilder(digits);
        List<Long> ps = new ArrayList<>();
        
        primos.forEach((numero, primoss) -> {
            if(primoss.size() > ps.size()){
                k.replace(0, k.length(), numero);
                ps.clear();
                ps.addAll(primoss);
                maximos.clear();
                maximos.put(numero, primoss);
            } else if (primoss.size() == ps.size()){
                maximos.put(numero, primoss);
            }
        });
        maximos.forEach((s, l) -> {
            System.out.println(s + ": " + l);
        });
    }

    /**
     * doesn't include the number 2
     * @see Problem7.isPrimo(long);
     */
    private boolean isPrimo(long num) {
        if(num % 2 == 0){
            return false;
        }
        long sq = (long)Math.sqrt(num) + 1;
        for (long i = 3; i <= sq; i+=2) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    private String format(String longBinary, int digits){
        StringBuilder sb = new StringBuilder(digits);
        for (int i = 0; i < digits - longBinary.length(); i++) {
            sb.append("0");
        }
        sb.append(longBinary);
        for (int i = 0; i < digits; i++) {
            if(sb.charAt(i) == '0'){
                sb.replace(i, i+1, letras[i] + "");
            } else {
                sb.replace(i, i+1, "*");
            }
        }
        return sb.toString();
    }
    
    private long twoToThe(int num){
        long res = 2;
        for (int i = 1; i < num; i++) {
            res *= 2;
        }
        return res;
    }
}

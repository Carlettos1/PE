package com.carlettos.core;

/**
 *
 * @author Carlos
 */
public abstract class PERun {

    public PERun() {
    }

    protected abstract void run();

    public static void run(PERun problem) {
        problem.run();
    }
}

package com.algorithms.generator;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomNumberGenerator implements NumberGenerator {

    private ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public int generate(int from, int to) {
        return threadLocalRandom.nextInt(from, to);
    }
}

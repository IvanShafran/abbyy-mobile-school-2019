package com.example.concurrency;

import java.util.concurrent.TimeUnit;

public class TheMostImportantQuestionSolver {

    public static int solve(long secondsDelay) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(secondsDelay));
            return 42;
        } catch (InterruptedException e) {
            return -1;
        }
    }
}

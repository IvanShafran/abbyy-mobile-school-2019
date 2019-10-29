package tasks;

import org.junit.Assert;
import org.junit.Test;

public class Task01Test {

    @Test
    public void min_01() {
        int[] ints = {3, 1, 2};
        Assert.assertEquals(1, Task01.min(ints));
    }

    @Test
    public void min_02() {
        int[] ints = {1, 3, 2};
        Assert.assertEquals(1, Task01.min(ints));
    }

    @Test
    public void min_03() {
        int[] ints = {2, 3, 1};
        Assert.assertEquals(1, Task01.min(ints));
    }

    private static final float EPS = 0.01f;

    @Test
    public void average_01() {
        int[] ints = {2, 3, 1};
        Assert.assertTrue(floatEquals(Task01.average(ints), 2));
    }

    @Test
    public void average_02() {
        int[] ints = {-2, 3, 1, 3, 12, 0};
        Assert.assertTrue(floatEquals(Task01.average(ints), 17f / 6f));
    }

    private static boolean floatEquals(float a, float b) {
        return Math.abs(a - b) < EPS;
    }
}

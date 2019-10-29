package tasks;

import org.junit.Assert;
import org.junit.Test;

public class Task02Test {

    @Test
    public void work01() {
        Assert.assertEquals("work", Task02.shouldIWork(0));
    }

    @Test
    public void work02() {
        Assert.assertEquals("work", Task02.shouldIWork(1));
    }

    @Test
    public void work03() {
        Assert.assertEquals("work", Task02.shouldIWork(2));
    }

    @Test
    public void work04() {
        Assert.assertEquals("work", Task02.shouldIWork(3));
    }

    @Test
    public void work05() {
        Assert.assertEquals("work", Task02.shouldIWork(4));
    }

    @Test
    public void rest06() {
        Assert.assertEquals("rest", Task02.shouldIWork(5));
    }

    @Test
    public void rest07() {
        Assert.assertEquals("rest", Task02.shouldIWork(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception08() {
        Task02.shouldIWork(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception09() {
        Task02.shouldIWork(7);
    }

}

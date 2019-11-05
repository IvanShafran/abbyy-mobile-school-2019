package tasks;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task02Test {

    @Test
    public void test01() {
        String[] strings = new String[]{"1", "2", "3"};
        Iterator<String> iterator = new ArrayIterator<>(strings);
        for (String s : strings) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(s, iterator.next());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void test02() {
        Iterator<String> iterator = new ArrayIterator<>(new String[0]);
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

}

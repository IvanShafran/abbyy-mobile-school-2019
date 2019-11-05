package tasks;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task01Test {

    @Test
    public void test01() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");

        Collection<String> result = Task01.removeDuplicates(strings);

        Assert.assertThat(result, JUnitMatchers.hasItems("1", "2", "3"));
    }

    @Test
    public void test02() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("2");
        strings.add("3");
        strings.add("3");
        strings.add("3");

        Collection<String> result = Task01.removeDuplicates(strings);

        Assert.assertThat(result, JUnitMatchers.hasItems("1", "2", "3"));
    }

}

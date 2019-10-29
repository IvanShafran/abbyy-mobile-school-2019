package tasks;

import org.junit.Assert;
import org.junit.Test;

public class Task03Test {

    @Test
    public void trueTest() {
        Assert.assertTrue(Task03.booleanDeserialize(Task03.booleanSerialize(true)));
    }

    @Test
    public void falseTest() {
        Assert.assertFalse(Task03.booleanDeserialize(Task03.booleanSerialize(false)));
    }

}

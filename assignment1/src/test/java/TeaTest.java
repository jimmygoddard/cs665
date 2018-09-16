import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TeaTest {

    @Test
    public void getDescriptor() {
        final Tea tea = new Tea();
        Assert.assertEquals("tea", tea.getDescriptor());
    }

    @Test
    public void getTypes() {
        final Tea tea = new Tea();
        Assert.assertEquals(Arrays.asList("black", "green", "yellow"), tea.getTypes());
    }
}
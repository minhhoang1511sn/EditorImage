package ja.P5T2.photoeditor;

import org.junit.Test;

public class EnumTest {

    @Test
    public void testNumberOfViewTypes() {
        assertEquals(ViewType.values().length, 4);
    }

    @Test
    public void testNumberOfPhotoFilterTypes() {
        assertEquals(PhotoFilter.values().length, 24);
    }

}
package ol.control;

import ol.BaseTestCase;
import ol.OLFactory;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class FullScreenTest extends BaseTestCase {

    public void testFullScreen() {

        FullScreen fullScreen = OLFactory.createFullScreen();
        
        assertNotNull(fullScreen);
        assertTrue(fullScreen instanceof Object);
        assertTrue(fullScreen instanceof Control);
        
    }

}

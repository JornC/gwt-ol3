package ol.control;

import ol.BaseTestCase;
import ol.OLFactory;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ZoomToExtentTest extends BaseTestCase {

    public void testZoomToExtent() {

        ZoomToExtent zoomToExtent = OLFactory.createZoomToExtent();
        
        assertNotNull(zoomToExtent);
        assertTrue(zoomToExtent instanceof Object);
        assertTrue(zoomToExtent instanceof Control);
        
    }

}

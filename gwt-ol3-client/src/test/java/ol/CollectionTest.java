package ol;

import ol.BaseTestCase;
import ol.control.Control;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class CollectionTest extends BaseTestCase {

    public void testCollection() {
        
        Collection<Control> controls = OLFactory.createCollection();
        
        assertNotNull(controls);
        assertTrue(controls.getLength() == 0);
        
        assertNotNull(controls.getArray());
        
        controls.push(OLFactory.createAttributionControl());
        
        assertTrue(controls.getLength() == 1);
        
        //assertTrue(controls.getArray().length == 1);
        
        //Control[] controlArray = controls.getArray();
        
    }

}

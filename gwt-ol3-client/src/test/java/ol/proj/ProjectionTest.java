package ol.proj;

import com.google.gwt.core.client.JsArrayNumber;

import ol.BaseTestCase;
import ol.Coordinate;
import ol.Extent;
import ol.OLFactory;
import ol.OLUtil;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class ProjectionTest extends BaseTestCase {

	private static final String EPSG_CODE_4326 = "EPSG:4326";
	private static final String EPSG_CODE_3068 = "EPSG:3068";
	private static final String EPSG_CODE_3857 = "EPSG:3857";
	private static final String EPSG_CODE_21781 = "EPSG:21781";
	private static final String UNIT_METRE = "m";
	private static final String UNIT_DEGREES = "degrees";
	
    public void testProjection() {
    	
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.code(EPSG_CODE_21781)
            .units(UNIT_METRE);
        
        Projection projection = OLFactory.createProjection(projectionOptions);
        
        assertNotNull(projection);
        assertEquals(EPSG_CODE_21781, projection.getCode());
        assertEquals(UNIT_METRE, projection.getUnits());
        
    }
    
    public void testAddProjection() {
    	
    	ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.code(EPSG_CODE_3068)
        	.global(false)
            .units(UNIT_METRE);
        
        Projection projection = OLFactory.createProjection(projectionOptions);
        assertNotNull(projection);
        
        OLUtil.addProjection(projection);
        
        Projection projectionToCompare = OLUtil.getProjection(EPSG_CODE_3068);
        assertNotNull(projectionToCompare);
        
        assertEquals(projection.getCode(), projectionToCompare.getCode());
	assertTrue(OLUtil.equivalent(projection, projectionToCompare));
    }
    
    public void testEquivalent() {
	Projection p1 = OLUtil.getProjection(EPSG_CODE_4326);
	Projection p2 = OLUtil.getProjection(EPSG_CODE_4326);
	Projection p3 = OLUtil.getProjection(EPSG_CODE_3857);
	assertTrue(OLUtil.equivalent(p1, p2));
	assertFalse(OLUtil.equivalent(p1, p3));
    }
    
    public void testGet() {
    	
    	Projection projection = OLUtil.getProjection(EPSG_CODE_4326);
        
        assertNotNull(projection);
        assertEquals(EPSG_CODE_4326, projection.getCode());
        assertTrue(projection.isGlobal());
        assertTrue(projection.getExtent().<JsArrayNumber>cast().length() == 4);
        assertEquals(projection.getUnits(), UNIT_DEGREES);
        
    }
    
    /**
     * Tests coordinate transformation.
     */
    public void testTransform() {
    	
    	double x = -121.1;
    	double y = 47.5;
    	
    	Coordinate centerCoordinate = OLFactory.createCoordinate(x, y);
    	Coordinate transformedCenterCoordinate = OLUtil.transform(centerCoordinate, EPSG_CODE_4326, EPSG_CODE_3857); 
        
        assertTrue(transformedCenterCoordinate.length() == 2);
        assertNotSame(transformedCenterCoordinate.getX(), x);
        assertNotSame(transformedCenterCoordinate.getY(), y);
        
    }
    
    /**
     * Tests extent transformation.
     */
    public void testTransformExtent() {
    	
    	Extent extent = OLUtil.getProjection(EPSG_CODE_4326).getExtent();
    	
    	Extent transformedExtent = OLUtil.transformExtent(extent, EPSG_CODE_4326, EPSG_CODE_3857); 
        
        assertTrue(transformedExtent.<JsArrayNumber>cast().length() == 4);
        assertNotSame(extent.getLowerLeftX(), transformedExtent.getLowerLeftX());
        assertNotSame(extent.getLowerLeftY(), transformedExtent.getLowerLeftY());
        assertNotSame(extent.getUpperRightX(), transformedExtent.getUpperRightX());
        assertNotSame(extent.getUpperRightY(), transformedExtent.getUpperRightY());
        
    }

}

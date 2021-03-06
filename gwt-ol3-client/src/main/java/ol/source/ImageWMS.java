package ol.source;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.source.ImageWMS")
public interface ImageWMS extends Image {
    
    String getUrl();
    
    void setUrl(String url); 
    
}


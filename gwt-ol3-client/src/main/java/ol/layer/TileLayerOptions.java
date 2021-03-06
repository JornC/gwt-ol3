package ol.layer;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Map;

/**
 * Tile layer options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface TileLayerOptions extends LayerOptions {
    /**
     *
     * Sets the layer as overlay on a map. The map will not manage this layer in
     * its layers collection, and the layer will be rendered on top. This is
     * useful for temporary layers. The standard way to add a layer to a map and
     * have it managed by the map is to use {@link ol.Map#addLayer(Base)}.
     *
     * @param map
     *            {@link Map}
     * @return this instance
     */
    @JsProperty
    TileLayerOptions setMap(Map map);

    /**
     * Preload. Load low-resolution tiles up to preload levels. By default
     * preload is 0, which means no preloading.
     * 
     * @param preload
     *            preload levels
     * @return this instance
     */
    @JsProperty
    TileLayerOptions setPreLoad(int preload);

    /**
     * Use interim tiles on error. Default is true.
     * 
     * @param useInterimTilesOnError
     *            use interim tiles on error?
     * @return this instance
     */
    @JsProperty
    TileLayerOptions setUseInterimTilesOnError(boolean useInterimTilesOnError);
}

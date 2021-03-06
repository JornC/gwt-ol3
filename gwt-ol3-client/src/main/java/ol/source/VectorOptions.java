package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Collection;
import ol.Feature;
import ol.gwt.TypedObject;

/**
 * Vector source options.
 *
 * @author sbaumhekel
 */
@JsType
public interface VectorOptions extends SourceOptions {

    /**
     * Set the features. If provided as {@link ol.Collection}, the features in
     * the source and the collection will stay in sync.
     *
     * @param features
     *            features
     * @return this instance
     */
    @JsProperty
    VectorOptions setFeatures(TypedObject<Feature[], Collection<Feature>> features);

    /**
     *
     * By default, an RTree is used as spatial index. When features are removed
     * and added frequently, and the total number of features is low, setting
     * this to false may improve performance. Note that
     * ol.source.Vector#getFeaturesInExtent,
     * ol.source.Vector#getClosestFeatureToCoordinate and
     * ol.source.Vector#getExtent cannot be used when useSpatialIndex is set to
     * false, and ol.source.Vector#forEachFeatureInExtent will loop through all
     * features. When set to false, the features will be maintained in an
     * ol.Collection, which can be retrieved through
     * ol.source.Vector#getFeaturesCollection. The default is true.
     *
     * @param useSpatialIndex
     *            use spatial index?
     * @return this instance
     */
    @JsProperty
    VectorOptions useSpatialIndex(boolean useSpatialIndex);

    /**
     * Wrap the world horizontally. Default is true. For vector editing across
     * the -180° and 180° meridians to work properly, this should be set to
     * false. The resulting geometry coordinates will then exceed the world
     * bounds.
     * 
     * @param wrapX
     *            wrap?
     * @return this instance
     */
    @JsProperty
    VectorOptions wrapX(boolean wrapX);
}

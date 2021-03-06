package ol.layer;

import com.google.gwt.core.client.js.JsType;

/**
 * Vector data that is rendered client-side. Note that any property set in the
 * options is set as a {@link ol.Object} property on the layer object; for
 * example, setting `title: 'My Title'` in the options means that `title` is
 * observable, and has get/set accessors.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.layer.Vector")
public interface Vector extends Layer {

    /**
     * Get the style for features. This returns whatever was passed to the
     * `style` option at construction or to the `setStyle` method.
     * 
     * @return {ol.style.Style|Array.<ol.style.Style>|ol.style.StyleFunction}
     *         Layer style.
     */
    ol.style.Style getStyle();

    /**
     * Set the style for features. This can be a single style object, an array
     * of styles, or a function that takes a feature and resolution and returns
     * an array of styles. If it is `undefined` the default style is used. If it
     * is `null` the layer has no style (a `null` style), so only features that
     * have their own styles will be rendered in the layer. See {@link ol.style}
     * for information on the default style.
     * 
     * @param style
     *            Layer style.
     */
    void setStyle(ol.style.Style style);

}

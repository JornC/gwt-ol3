package ol;

import com.google.gwt.core.client.js.*;

import ol.event.Event;

/**
 * Events emitted as map events are instances of this type. See {@link ol.Map}
 * for which events trigger a map event.
 *
 * @author sbaumhekel
 */
@JsType
public interface MapEvent extends Event {

    /**
     * Triggered after the map is moved.
     */
    static final String MOVEEND = "moveend";

    /**
     * Triggered after a map frame is rendered.
     */
    static final String POSTRENDER = "postrender";

    /**
     * The map where the event occurred.
     *
     * @return {@link ol.Map}
     */
    @JsProperty
    Map getMap();
}

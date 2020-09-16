/**
 *  Json Util
 */
package jp.co.axa.apidemo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class JsonUtil.
 */
class JsonUtil {
    
    /**
     * To json.
     *
     * @param object the object
     * @return the byte[]
     * @throws IOException Signals that an I/O exception has occurred.
     */
    static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
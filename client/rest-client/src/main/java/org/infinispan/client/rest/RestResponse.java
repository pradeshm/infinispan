package org.infinispan.client.rest;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.infinispan.client.rest.configuration.Protocol;
import org.infinispan.commons.util.Experimental;

/**
 * @author Tristan Tarrant &lt;tristan@infinispan.org&gt;
 * @since 10.0
 **/
@Experimental
public interface RestResponse extends RestEntity, AutoCloseable {
   int getStatus();

   Map<String, List<String>> headers();

   /**
    * Returns the value of a header as a String. For multi-valued headers, values are separated by comma.
    */
   String getHeader(String header);

   InputStream getBodyAsStream();

   byte[] getBodyAsByteArray();

   Protocol getProtocol();

   void close();

   boolean usedAuthentication();
}

package com.dpl.order.properties;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author skumar12
 *
 */
public class JsonPropertySourceFactory implements PropertySourceFactory {
   
  /* (non-Javadoc)
   * @see org.springframework.core.io.support.PropertySourceFactory#createPropertySource(java.lang.String, org.springframework.core.io.support.EncodedResource)
   */
  @Override
  public PropertySource<?> createPropertySource(
    String name, EncodedResource resource)
        throws IOException {
    @SuppressWarnings("unchecked")
    Map<String, Object> readValue = new ObjectMapper()
        .readValue(resource.getInputStream(), Map.class);
      return new MapPropertySource("json-property", readValue);
  }
}

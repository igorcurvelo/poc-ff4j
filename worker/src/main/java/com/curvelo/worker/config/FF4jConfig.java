package com.curvelo.worker.config;

import javax.sql.DataSource;
import org.ff4j.FF4j;
import org.ff4j.audit.repository.EventRepository;
import org.ff4j.audit.repository.JdbcEventRepository;
import org.ff4j.core.FeatureStore;
import org.ff4j.property.store.JdbcPropertyStore;
import org.ff4j.property.store.PropertyStore;
import org.ff4j.store.InMemoryFeatureStore;
import org.ff4j.store.JdbcFeatureStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4jConfig {

  @Bean
  public PropertyStore propertyStore(final DataSource dataSource) {
    return new JdbcPropertyStore(dataSource);
  }

  @Bean
  public FeatureStore featureStore(final DataSource dataSource) {
    return new JdbcFeatureStore(dataSource);
  }

  @Bean
  public EventRepository eventRepository(final DataSource dataSource) {
    return new JdbcEventRepository(dataSource);
  }

  @Bean
  public FF4j ff4j(final FeatureStore featureStore, final PropertyStore propertyStore,
      final EventRepository eventRepository) {
    final FF4j ff4j = new FF4j();
    ff4j.setFeatureStore(featureStore);
    ff4j.setPropertiesStore(propertyStore);
    ff4j.setEventRepository(eventRepository);
    ff4j.setAutocreate(true);
    ff4j.setEnableAudit(true);
    return ff4j;
  }

}

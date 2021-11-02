package com.curvelo.worker.schedule;

import org.ff4j.FF4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

  private final FF4j ff4j;

  public Schedule(FF4j ff4j) {
    this.ff4j = ff4j;
  }

  @Scheduled(fixedRate = 10000)
  public void consume() {

    var toggle = ff4j.check("TOGGLE_EMAIL_VALIDATION");

    var properties = ff4j.getFeature("TOGGLE_EMAIL_VALIDATION");

    System.out.println("Schedule:");
    System.out.println("Toggle: TOGGLE_EMAIL_VALIDATION, Value: " + toggle);
    properties.getCustomProperties()
        .forEach((key, value) -> System.out.println("Property: " + key + ", value: " + value.getValue()));
  }
}

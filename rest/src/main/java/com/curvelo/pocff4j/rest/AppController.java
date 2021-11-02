package com.curvelo.pocff4j.rest;

import java.util.HashMap;
import java.util.Map;
import org.ff4j.FF4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class AppController {

  private final FF4j ff4j;

  public AppController(FF4j ff4j) {
    this.ff4j = ff4j;
  }

  @GetMapping
  public Map<String, Object> get() {
    Map<String, Object> response = new HashMap<>();
    response.put("app", "01");

    // example toggle
    ff4j.check("TOGGLE_EMAIL_VALIDATION");
//    response.put("TOGGLE_EMAIL_VALIDATION", toggleEmailValidation);

    // example toggle, custom property
    response.put("custom property", ff4j.getFeature("TOGGLE_EMAIL_VALIDATION").getProperty("ignore").getValue());

    response.put("features", ff4j.getFeatures());
    response.put("properties", ff4j.getProperties());

    return response;
  }

}

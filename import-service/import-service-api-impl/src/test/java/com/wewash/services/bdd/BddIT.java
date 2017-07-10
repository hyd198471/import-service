package com.wewash.services.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.wewash.services.bdd.steps"},
        features = {"classpath:bdd/features"}
)
public class BddIT {
}

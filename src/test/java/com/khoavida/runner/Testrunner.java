package com.khoavida.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features ="src/test/resources/Features",
				  glue = "step_definition",
				  plugin = {"pretty", "html:target/REPORT/Test_report.html"}
				)
public class Testrunner {

}

package com.khoavida.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features ="src/test/resources/Features/Register.feature",
				  glue = {"com.khoavida.step_definition","com.khoavida.hook"},
				  plugin = {"pretty", "html:target/REPORT/Register_report.html"}
				)
public class Testrunner {

}

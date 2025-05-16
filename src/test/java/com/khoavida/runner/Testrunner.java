package com.khoavida.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features ="src/test/resources/Features/Check_valid_account.feature",
				  glue = {"com.khoavida.step_definition","com.khoavida.hook"},
				  plugin = {"pretty", "html:target/REPORT/Test_report.html"}
				)
public class Testrunner {

}

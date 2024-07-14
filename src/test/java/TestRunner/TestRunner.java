package TestRunner;

import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(features= {"src/test/java/source"},
                 glue= {"StepDefinition"},
                 monochrome=true,
                 tags = "@Test",
                 plugin = {"pretty"})
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	@AfterSuite
	public static void afterexecutedthestSuite() {
		
		for(int i=0;i<5;i++) {
			if(i!=2) {
				System.out.println("################################################");
			} else {
				System.out.println("Test Suite is Executed");
				System.out.println("Find the reports in target folder");
			}
		}
	}
	
}

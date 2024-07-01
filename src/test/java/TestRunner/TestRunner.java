package TestRunner;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

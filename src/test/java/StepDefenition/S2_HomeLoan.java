package StepDefenition;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Logger;

import Factory.BaseClass;
import Utilities.WriteExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomeLoan;

public class S2_HomeLoan {
	
	WriteExcel write = new WriteExcel();
	Logger logger = BaseClass.getLogger();

	@Given("the user navigates to HomeLoanPage")
	public void the_user_navigates_to_home_loan_page() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Navigating to Home Loan Page");
		HomeLoan home = new HomeLoan(BaseClass.getDriver());
		home.navigator();
		logger.info("Navigated to Home Loan Page successfully");	
	}

	@When("the user scroll the table")
	public void the_user_scroll_the_table() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Scrolling to the table");
		HomeLoan home = new HomeLoan(BaseClass.getDriver());
		home.scrollToTable();
		logger.info("Scrolled to the table successfully");
	}

	@Then("printing the table")
	public void printing_the_table() throws IOException, InterruptedException
	{
			// Write code here that turns the phrase above into concrete actions
			logger.info("Fetching data from the table");
			HomeLoan home = new HomeLoan(BaseClass.getDriver());
			Thread.sleep(5000);
			String[][] datas = home.getTableData();
			Thread.sleep(5000);
			logger.info("Fetched data from the table successfully");
			
			//Writing the data into the excel sheet
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 	// Timestamp for the excel file
			String fileName = "S2_YearTable_Cucumber" + timeStamp + ".xlsx";
			String path = ".//TestData/" + fileName;
			
			logger.info("Writing data to Excel file: {}", path);
			write.writeExcel(datas, path);
		    home.getTableData();
		    logger.info("Data written to Excel file successfully");
	}
}

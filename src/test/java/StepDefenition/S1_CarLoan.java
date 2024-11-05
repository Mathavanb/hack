package StepDefenition;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.apache.logging.log4j.Logger;
 
import Factory.BaseClass;
import Utilities.ReadData;
import Utilities.WriteExcel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CarLoan;
 
public class S1_CarLoan {
    List<HashMap<String, String>> datamaps;
	WriteExcel write = new WriteExcel();
	Logger logger = BaseClass.getLogger();
	CarLoan obj = new CarLoan(BaseClass.getDriver());
 
		
	@Given("the user navigates to CarLoanPage")
	public void the_user_navigates_to_Car_loan_page() 
	{
		logger.info("Navigating to Car Loan Page");
		obj.navigator();
		obj.clickCarLoan();
		logger.info("Navigated to Car Loan Page successfully");
	}
	@When("the user enters the value of Car Loan Page")
	public void the_user_enters_the_value(DataTable dataTable)  
	{
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		/*--------------| Input from feature file |----------------------*/
		obj.setLoanAmt(dataMap.get("LoanAmt"));
		obj.setInterest(dataMap.get("LoanInt"));
		obj.moveLoanTenureSlider(Integer.parseInt(dataMap.get("LoanTen")));
 
		obj.clickOnYear();
		obj.scrollToTable();
	}

	@Then("enter the values with excel row {string}")
	public void enter_the_values_with_excel_row(String rows) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Entering values from Excel row: {}", rows);
		datamaps = ReadData.data("C:\\Users\\2361432\\Downloads\\hackathon 4\\hackathon\\TestData\\CarLoanInput.xlsx", "Sheet1");
        int index=Integer.parseInt(rows)-1;
        String loanAmount= datamaps.get(index).get("loan_amount");
        String interest= datamaps.get(index).get("interest");
        String tenure= datamaps.get(index).get("tenure");
        logger.info("Loan Amount: {}, Interest: {}, Tenure: {}", loanAmount, interest, tenure);
        System.out.println(loanAmount+" "+interest+" "+tenure);
        obj.setLoanAmt(loanAmount);
        obj.setInterest(interest);
        obj.moveLoanTenureSlider(Integer.parseInt(tenure));
	    logger.info("Values entered successfully");
	}
	@Then("the user clicks on the year button")
	public void the_user_clicks_on_the_year_button() {
		logger.info("Clicking on the year button");
		obj.clickOnYear();
		logger.info("Year button clicked successfully");
	}
	@Then("the user scroll to the table")
	public void the_user_scroll_to_the_table() {
		logger.info("Scrolling to the table");
		obj.scrollToTable();
		logger.info("Scrolled to the table successfully");
	}
	@Then("the user click on the years")
	public void the_user_click_on_the_years() {
		logger.info("Clicking on the years");
		obj.clickOnYears();
	    logger.info("Years clicked successfully");
	}
	 @Then("display the EMI data")
	 public void display_the_emi_data() throws IOException {
	        logger.info("Fetching data from the table");
	        CarLoan obj = new CarLoan(BaseClass.getDriver());
	        obj.clickOnYears();
	        String[][] dataArray = obj.getEMIPaymentTableData();
	        logger.info("Fetched data from the table successfully");
 
	        // Writing the data into the excel sheet
	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Timestamp for the excel file
	        String fileName = "S1_YearTable_Cucumber" + timeStamp + ".xlsx";
	        String path = ".//TestData/" + fileName;
	        logger.info("Writing data to Excel file: {}", path);
	        write.writeExcel(dataArray, path);
	        logger.info("Data written to Excel file successfully");
	    }
//		@Then("display the EMI data")
//		public void display_the_emi_data() {
//		    // Write code here that turns the phrase above into concrete actions
//		   // throw new io.cucumber.java.PendingException();
//			obj.printTheEMIPaymentTable();
//			logger.info("---- TestCase_02_DisplayingTheEMIPaymentTable Ended ----");
//		}
}
 

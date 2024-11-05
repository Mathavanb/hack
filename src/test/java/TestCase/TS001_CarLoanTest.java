package TestCase;




import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import Factory.BaseClass;
import Utilities.ReadData;
import Utilities.WriteExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CarLoan;
import pageObject.HomeLoan;


public class TS001_CarLoanTest extends DriverSetup{
	
	WriteExcel write = new WriteExcel();
	List<HashMap<String, String>> datamaps;
	public Properties p;
	
	
	@Test(priority =1 ,groups = {"smoke"})
	public void validate_carLoanPage() throws IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		CarLoan obj = new CarLoan(driver);
		
		logger.info("Car_Loan_Test");
	    logger.info("01: Navigating to the Car Loan page.");
	    obj.navigator();
	    logger.info("02: Navigated to the Car Loan page.");
	    
	    logger.info("03: Clicking on Car Loan.");
	    obj.clickCarLoan();
	    logger.info("04: Clicked on Car Loan.");
	    
	    String pageTitle = driver.getTitle();
	    
	    if(pageTitle.equals(p.getProperty("CarLoanPage"))) {
	    	logger.info("Smoke Test Successfully Verified - Car Loan Page");
	    }
	    else {
	    	logger.error("Smoke Test Failed - Car Loan Page");
	    	Assert.fail();
	    }
	    
	}

	
	@Test(priority =2, groups= {"regression"})
	public void user_enteringValues_carLoan() throws IOException {
	    
	    // Reading data from Excel
		CarLoan obj = new CarLoan(driver);
		
	    logger.info("05: Reading data from Excel file.");
	    datamaps = ReadData.data(System.getProperty("user.dir") + "\\TestData\\CarLoanInput.xlsx", "Sheet1");
	    int index = 0;
	    String loanAmount = datamaps.get(index).get("loan_amount");
	    String interest = datamaps.get(index).get("interest");
	    String tenure = datamaps.get(index).get("tenure");
	    logger.info("06: Data read from Excel file: Loan Amount = " + loanAmount + ", Interest = " + interest + ", Tenure = " + tenure);
	    
	    logger.info("07: Setting Loan Amount.");
	    obj.setLoanAmt(loanAmount);
	    logger.info("08: Loan Amount set to " + loanAmount);
	    
	    logger.info("09: Setting Interest Rate.");
	    obj.setInterest(interest);
	    logger.info("10: Interest Rate set to " + interest);
	    
	    logger.info("11: Moving Loan Tenure Slider.");
	    obj.moveLoanTenureSlider(-375);
	    logger.info("12: Loan Tenure Slider moved.");
	    
	    logger.info("13: Clicking on Year.");
	    obj.clickOnYear();
	    logger.info("14: Clicked on Year.");
	    
	    logger.info("15: Scrolling to the table.");
	    obj.scrollToTable();
	    logger.info("16: Scrolled to the table.");
	    
	    logger.info("17: Clicking on Years.");
	    obj.clickOnYears();
	    logger.info("18: Clicked on Years.");
	    
	    logger.info("19: Fetching EMI Payment Table Data.");
	    String[][] dataArray = obj.getEMIPaymentTableData();
	    logger.info("20: Fetched EMI Payment Table Data.");
	    
	    // Writing the data into the excel sheet
	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Timestamp for the excel file
	    String fileName = "TS001_YearTable_TestNG" + timeStamp + ".xlsx";
	    String path = ".//TestData/" + fileName;
	    logger.info("21: Writing data to Excel file: " + path);
	    write.writeExcel(dataArray, path);
	    logger.info("22: Data written to Excel file successfully.");
	}


}

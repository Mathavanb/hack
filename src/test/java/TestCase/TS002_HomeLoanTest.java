package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.WriteExcel;
import pageObject.CarLoan;
import pageObject.HomeLoan;

public class TS002_HomeLoanTest extends DriverSetup{
	
	
	WriteExcel write = new WriteExcel();
	
	@Test(priority =1 ,groups = {"smoke"})
	public void validate_HomeLoanPage() throws IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger.info("Home_Loan_Test");
		
	    HomeLoan home = new HomeLoan(driver);
	    logger.info("01.Navigating to the Home Loan page.");
	    home.navigator();
	    logger.info("02.Navigated to the Home Loan page.");
	    
	    String pageTitle = driver.getTitle();
	    
	    if(pageTitle.equals(p.getProperty("HomeLoanPage"))) {
	    	logger.info("Smoke Test Successfully Verified - Home Loan Page");
	    }
	    else {
	    	logger.error("Smoke Test Failed - Home Loan Page");
	    	Assert.fail();
	    }
	    
	}
	
	@Test(priority = 2, groups= {"regression"})
	public void homeloan() throws IOException {
		HomeLoan home = new HomeLoan(driver);

	    logger.info("03.Scrolling to the table.");
	    home.scrollToTable();
	    logger.info("04.Scrolled to the table.");

	    logger.info("05.Fetching table data.");
	    String[][] datas = home.getTableData();
	    logger.info("06.Fetched table data.");

	    // Writing the data into the excel sheet
	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Timestamp for the excel file
	    String fileName = "TS002_YearTable_TestNG" + timeStamp + ".xlsx";
	    String path = ".//TestData/" + fileName;
	    logger.info("07.Writing data to Excel file: " + path);
	    write.writeExcel(datas, path);
	    logger.info("08.Data written to Excel file successfully.");
	}
}

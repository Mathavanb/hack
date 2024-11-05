package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.UIpage;

public class TS003_UI_EMIcalculator extends DriverSetup {
	
	@Test(priority =1 ,groups = {"smoke"})
	public void validate_EMICalPage() throws IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		UIpage Ui = new UIpage(driver);
 
	    logger.info("TS003_Navigating to the EMI Calculator page.");
	    Ui.navigatorForEMICalc();  // Navigate to EMI Calculator page
	    logger.info("TS003_Navigated to the EMI Calculator page.");
	    
	    String pageTitle = driver.getTitle();
	    
	    if(pageTitle.equals(p.getProperty("EMICalculatorPage"))) {
	    	logger.info("Smoke Test Successfully Verified - EMI Calculator Page");
	    }
	    else {
	    	logger.error("Smoke Test Failed - EMI Calculator Page");
	    	Assert.fail();
	    }
	    
	}

	@Test(priority =2 ,groups = {"regression"})
	public void user_validate_EMI_Calculator_functionality() {
	    SoftAssert softAssert = new SoftAssert();
	    UIpage Ui = new UIpage(driver);

	    logger.info("TS003_Validating displayed elements of EMI Calculator.");
	    softAssert.assertTrue(Ui.getLoanAmtTextBox().isDisplayed(), "Loan Amount Text Box is not visible");
	    softAssert.assertTrue(Ui.getLoanAmtSlider().isDisplayed(), "Loan Amount Slider is not visible");
	    softAssert.assertTrue(Ui.getIntRateTextBox().isDisplayed(), "Interest Rate Text Box is not visible");
	    softAssert.assertTrue(Ui.getIntRateSlider().isDisplayed(), "Interest Rate Slider is not visible");
	    softAssert.assertTrue(Ui.getLoanTenureTextBox().isDisplayed(), "Loan Tenure Text Box is not visible");
	    softAssert.assertTrue(Ui.getLoanTenureSlider().isDisplayed(), "Loan Tenure Slider is not visible");
	    softAssert.assertTrue(Ui.getFeesAndChargesTextBox().isDisplayed(), "Fees And Charges Text Box is not visible");
	    softAssert.assertTrue(Ui.getFeesAndChargesSlider().isDisplayed(), "Fees And Charges Slider is not visible");
	    logger.info("TS003_All elements are displayed successfully in EMI Calculator Page.");

	    logger.info("TS003_Validating enabled elements of EMI Calculator Page.");
	    softAssert.assertTrue(Ui.getLoanAmtTextBox().isEnabled(), "Loan Amount Text Box is not enabled");
	    softAssert.assertTrue(Ui.getLoanAmtSlider().isEnabled(), "Loan Amount Slider is not enabled");
	    softAssert.assertTrue(Ui.getIntRateTextBox().isEnabled(), "Interest Rate Text Box is not enabled");
	    softAssert.assertTrue(Ui.getIntRateSlider().isEnabled(), "Interest Rate Slider is not enabled");
	    softAssert.assertTrue(Ui.getLoanTenureTextBox().isEnabled(), "Loan Tenure Text Box is not enabled");
	    softAssert.assertTrue(Ui.getLoanTenureSlider().isEnabled(), "Loan Tenure Slider is not enabled");
	    softAssert.assertTrue(Ui.getFeesAndChargesTextBox().isEnabled(), "Fees And Charges Text Box is not enabled");
	    softAssert.assertTrue(Ui.getFeesAndChargesSlider().isEnabled(), "Fees And Charges Slider is not enabled");
	    logger.info("TS003_All elements are enabled successfully in EMI Calculator Page.");

	    logger.info("TS003_Testing scale change for Loan Amount in EMI Calculator Page.");
	    Ui.moveLoanAmtSlider(0);  // Move the slider to the minimum value
	    Ui.moveLoanAmtSlider(130);  // Move the slider to the maximum value
	    softAssert.assertEquals(Ui.getLoanAmtTextBoxValue(), "50,00,000", "Loan Amount value did not match in EMI Calculator Page.");

	    logger.info("TS003_Testing scale change for Interest Rate.");
	    Ui.moveIntRateSlider(0);  // Move the slider to the minimum value
	    Ui.moveIntRateSlider(112);  // Move the slider to a specific value
	    softAssert.assertEquals(Ui.getIntRateTextBoxValue(), "14.25", "Interest Rate value did not match in EMI Calculator Page.");

	    logger.info("TS003_Testing scale change for Loan Tenure in EMI Calculator Page.");
	    Ui.moveLoanTenureSlider(0);  // Move the slider to the minimum value
	    Ui.moveLoanTenureSlider(105);  // Move the slider to a specific value
	    softAssert.assertEquals(Ui.getLoanTenureTextBoxValue(), "10", "Loan Tenure value did not match in EMI Calculator Page.");

	    logger.info("TS003_Validating Year and Month option in EMI Calculator Page.");
	    Ui.clickYear();  // Click on the "Year" option
	    String yearVal = Ui.getLoanTenureTextBoxValue();  // Get the value in years
	    int yearValInInt = Integer.parseInt(yearVal);  // Convert to integer
	    Ui.clickMonth();  // Click on the "Month" option
	    String monthVal = Ui.getLoanTenureTextBoxValue();  // Get the value in months
	    softAssert.assertEquals(monthVal, Integer.toString(yearValInInt * 12), "Year and Month values did not match in EMI Calculator Page.");

	    logger.info("TS003_Testing scale change for Fees and Charges in EMI Calculator Page.");
	    Ui.moveFeesAndChargesSlider(0);  // Move the slider to the minimum value
	    Ui.moveFeesAndChargesSlider(97);  // Move the slider to a specific value
	    softAssert.assertEquals(Ui.getFeesAndChargesTextBoxValue(), "25,000", "Fees and Charges value did not match in EMI Calculator Page.");

	    // Collect all the assertions and verify the test result
	    softAssert.assertAll();

	    // Log the final result based on the testPassed flag
	    logger.info("TS003_Loan Tenure UI Check validation is successful in EMI Calculator Page.");
	}
}

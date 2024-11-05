package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.UIpage;

public class TS005_UI_LoanTenureCalc extends DriverSetup {

	private boolean testPassed = true;

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
    public void user_validate_Loan_Tenure_Calculator_functionality() {
    	logger.info("UI_LoanTenure_Calculation");
        UIpage UI = new UIpage(driver);
        logger.info("01.Navigating to the Loan Tenure Calculator page.");
        UI.navigatorForLoanTenureCalc();
        logger.info("02.Navigated to the Loan Tenure Calculator page.");

        logger.info("03.Validating displayed elements of Loan Tenure Calculator.");
        try {
            Assert.assertTrue(UI.getLoanAmtTextBox().isDisplayed(), "Loan Amount Text Box is not visible");
            Assert.assertTrue(UI.getLoanAmtSlider().isDisplayed(), "Loan Amount Slider is not visible");
            Assert.assertTrue(UI.getEMITextBox().isDisplayed(), "EMI Text Box is not visible");
            Assert.assertTrue(UI.getEMISlider().isDisplayed(), "EMI Slider is not visible");
            Assert.assertTrue(UI.getIntRateTextBox().isDisplayed(), "Interest Rate Text Box is not visible");
            Assert.assertTrue(UI.getIntRateSlider().isDisplayed(), "Interest Rate Slider is not visible");
            Assert.assertTrue(UI.getFeesAndChargesTextBox().isDisplayed(), "Fees And Charges Text Box is not visible");
            Assert.assertTrue(UI.getFeesAndChargesSlider().isDisplayed(), "Fees And Charges Slider is not visible");
            logger.info("04.All elements are displayed successfully in Loan Tenure Calculator page.");
        } catch (Exception e) {
            logger.error("04.Error validating displayed elements in Loan Tenure Calculator page", e);
            testPassed = false;
            Assert.fail();
        }

        logger.info("05.Validating enabled elements of Loan Tenure Calculator.");
        try {
            Assert.assertTrue(UI.getLoanAmtTextBox().isEnabled(), "Loan Amount Text Box is not enabled");
            Assert.assertTrue(UI.getLoanAmtSlider().isEnabled(), "Loan Amount Slider is not enabled");
            Assert.assertTrue(UI.getEMITextBox().isEnabled(), "EMI Text Box is not enabled");
            Assert.assertTrue(UI.getEMISlider().isEnabled(), "EMI Slider is not enabled");
            Assert.assertTrue(UI.getIntRateTextBox().isEnabled(), "Interest Rate Text Box is not enabled");
            Assert.assertTrue(UI.getIntRateSlider().isEnabled(), "Interest Rate Slider is not enabled");
            Assert.assertTrue(UI.getFeesAndChargesTextBox().isEnabled(), "Fees And Charges Text Box is not enabled");
            Assert.assertTrue(UI.getFeesAndChargesSlider().isEnabled(), "Fees And Charges Slider is not enabled");
            logger.info("06.All elements are enabled successfully in Loan Tenure Calculator page.");
        } catch (Exception e) {
            logger.error("06.Error validating enabled elements in Loan Tenure Calculator page", e);
            testPassed = false;
            Assert.fail();
        }

        logger.info("07.Testing scale change for Loan Amount in Loan Tenure Calculator page.");
        UI.moveLoanAmtSlider(0);
        UI.moveLoanAmtSlider(130);
        if (UI.getLoanAmtTextBoxValue().equals("50,00,000")) {
            logger.info("08.Scale change for Loan Amount validated successfully.");
            Assert.assertTrue(true);
        } else {
            logger.error("08.Scale change for Loan Amount failed in Loan Tenure Calculator page.");
            testPassed = false;
            Assert.fail();
        }

        logger.info("09.Testing scale change for Interest Rate in Loan Tenure Calculator page.");
        UI.moveIntRateSlider(0);
        UI.moveIntRateSlider(112);
        if (UI.getIntRateTextBoxValue().equals("14.25")) {
            logger.info("10.Scale change for Interest Rate validated successfully in Loan Tenure Calculator page.");
            Assert.assertTrue(true);
        } else {
            logger.error("10.Scale change for Interest Rate failed in Loan Tenure Calculator page.");
            testPassed = false;
            Assert.fail();
        }

        logger.info("11.Testing scale change for Fees and Charges in Loan Tenure Calculator page.");
        UI.moveFeesAndChargesSlider(0);
        UI.moveFeesAndChargesSlider(97);
        if (UI.getFeesAndChargesTextBoxValue().equals("25,000")) {
            logger.info("12.Scale change for Fees and Charges validated successfully in Loan Tenure Calculator page.");
            Assert.assertTrue(true);
        } else {
            logger.error("12.Scale change for Fees and Charges failed in Loan Tenure Calculator page.");
            testPassed = false;
            Assert.fail();
        }
        
        if (testPassed) {
            logger.info("13.Loan Tenure UI check validation is successful.");
        } else {
            logger.error("13.Loan Tenure UI check validation failed.");
        }
    }

 }
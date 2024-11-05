package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.UIpage;

public class TS004_UI_LoanAmountCalc extends DriverSetup {
    

    
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
    public void user_validate_Loan_Amount_Calculator_functionality() {
    	logger.info("UI_LoanAmount_Calculation");
        UIpage UI = new UIpage(driver);
        logger.info("01.Navigating to the Loan Amount Calculator page.");
        UI.navigatorForLoanAmountCalc();
        logger.info("02.Navigated to the Loan Amount Calculator page.");

        logger.info("03.Validating that all text boxes and sliders are displayed in Loan Amount Calculator Page.");
        try {
            Assert.assertTrue(UI.getEMITextBox().isDisplayed(), "EMI Text Box is not visible");
            Assert.assertTrue(UI.getIntRateTextBox().isDisplayed(), "Interest Rate Text Box is not visible");
            Assert.assertTrue(UI.getLoanTenureTextBox().isDisplayed(), "Loan Tenure Text Box is not visible");
            Assert.assertTrue(UI.getFeesAndChargesTextBox().isDisplayed(), "Fees And Charges Text Box is not visible");
            Assert.assertTrue(UI.getEMISlider().isDisplayed(), "EMI Slider is not visible");
            Assert.assertTrue(UI.getIntRateSlider().isDisplayed(), "Interest Rate Slider is not visible");
            Assert.assertTrue(UI.getLoanTenureSlider().isDisplayed(), "Loan Tenure Slider is not visible");
            Assert.assertTrue(UI.getFeesAndChargesSlider().isDisplayed(), "Fees And Charges Slider is not visible");
            logger.info("04.All text boxes and sliders are displayed successfully in Loan Amount Calculator Page.");
        } catch (Exception e) {
            logger.error("04.Error validating displayed text boxes and sliders in Loan Amount Calculator Page", e);
            testPassed = false;
            Assert.fail();
        }

        logger.info("05.Validating that all text boxes and sliders are enabled in Loan Amount Calculator Page.");
        try {
            Assert.assertTrue(UI.getEMITextBox().isEnabled(), "EMI Text Box is not enabled");
            Assert.assertTrue(UI.getIntRateTextBox().isEnabled(), "Interest Rate Text Box is not enabled");
            Assert.assertTrue(UI.getLoanTenureTextBox().isEnabled(), "Loan Tenure Text Box is not enabled");
            Assert.assertTrue(UI.getFeesAndChargesTextBox().isEnabled(), "Fees And Charges Text Box is not enabled");
            Assert.assertTrue(UI.getEMISlider().isEnabled(), "EMI Slider is not enabled");
            Assert.assertTrue(UI.getIntRateSlider().isEnabled(), "Interest Rate Slider is not enabled");
            Assert.assertTrue(UI.getLoanTenureSlider().isEnabled(), "Loan Tenure Slider is not enabled");
            Assert.assertTrue(UI.getFeesAndChargesSlider().isEnabled(), "Fees And Charges Slider is not enabled");
            logger.info("06.All text boxes and sliders are enabled successfully in Loan Amount Calculator Page.");
        } catch (Exception e) {
            logger.error("06.Error validating enabled text boxes and sliders in Loan Amount Calculator Page", e);
            testPassed = false;
            Assert.fail();
        }

        logger.info("07.Testing scale change for Interest Rate in Loan Amount Calculator Page.");
        UI.moveIntRateSlider(0);
        UI.moveIntRateSlider(112);
        if (UI.getIntRateTextBoxValue().equals("14.25")) {
            logger.info("08.Scale change for Interest Rate validated successfully in Loan Amount Calculator Page.");
            Assert.assertTrue(true);
        } else {
            logger.error("08.Scale change for Interest Rate did not match in Loan Amount Calculator Page.");
            testPassed = false;
            Assert.fail();
        }

        logger.info("09.Testing scale change for Loan Tenure in Loan Amount Calculator Page.");
        UI.moveLoanTenureSlider(0);
        UI.moveLoanTenureSlider(105);
        if (UI.getLoanTenureTextBoxValue().equals("10")) {
            logger.info("10.Scale change for Loan Tenure validated successfully in Loan Amount Calculator Page.");
            Assert.assertTrue(true);
        } else {
            logger.error("10.Scale change for Loan Tenure did not match in Loan Amount Calculator Page.");
            testPassed = false;
            Assert.fail();
        }

        logger.info("11.Validating Year and Month option in Loan Amount Calculator Page.");
        UI.clickYear();
        String yearVal = UI.getLoanTenureTextBoxValue();
        int yearValInInt = Integer.parseInt(yearVal);
        UI.clickMonth();
        String monthVal = UI.getLoanTenureTextBoxValue();
        if (monthVal.equals(Integer.toString(yearValInInt * 12))) {
            logger.info("12.Year and Month option validated successfully in Loan Amount Calculator Page.");
            Assert.assertTrue(true);
        } else {
            logger.error("12.Year and Month option did not match in Loan Amount Calculator Page.");
            testPassed = false;
            Assert.fail();
        }

        logger.info("13.Testing scale change for Fees and Charges in Loan Amount Calculator Page.");
        UI.moveFeesAndChargesSlider(0);
        UI.moveFeesAndChargesSlider(97);
        if (UI.getFeesAndChargesTextBoxValue().equals("25,000")) {
            logger.info("14.Scale change for Fees and Charges validated successfully in Loan Amount Calculator Page.");
            Assert.assertTrue(true);
        } else {
            logger.error("14.Scale change for Fees and Charges did not match in Loan Amount Calculator Page.");
            testPassed = false;
            Assert.fail();
        }
        
        if (testPassed) {
            logger.info("15.Loan Amount Calculator UI check validation is successful.");
        } else {
            logger.error("15.Loan Amount Calculator UI check validation failed.");
        }
        
    }

}
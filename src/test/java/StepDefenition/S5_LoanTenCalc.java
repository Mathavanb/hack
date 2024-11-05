package StepDefenition;


import org.apache.logging.log4j.Logger;
import Factory.BaseClass;
import Utilities.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UIpage;

public class S5_LoanTenCalc {
	
	Assertions myAssert = new Assertions();
	UIpage UI = new UIpage(BaseClass.getDriver());
	Logger logger = BaseClass.getLogger();
	@Given("user click the loan tenure calculator button of Loan Tenure Page")
	public void user_click_the_loan_tenure_calculator_button() {
		logger.info("Validates user_click_the_loan_tenure_calculator_button");
		//Navigating to the respective page
		UI.navigatorForLoanTenureCalc();
		logger.info("Validates navigatorForLoanTenureCalc");
 
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates loan amount textbox and slider of Loan Tenure Page")
	public void user_validate_loan_amount_textbox_and_slider() {
		logger.info("Validates user_validate_loan_amount_textbox_and_slider");
 
		//Validating if Loan Amount Text Box is visible
		if(UI.getLoanAmtTextBox().isDisplayed())
		{
			logger.info("Validates getLoanAmtTextBox");
 
			myAssert.pass();
		}
		else
		{
			
			System.out.println("TestCase_21_LoanTenureCalculator_ValidatingLoanAmountTextBoxAndSlider got failed, Loan Amount Text Box is not visible.");
			myAssert.fail();
 
		}
		//Validating if Loan Amount Text Box is enabled
		if(UI.getLoanAmtTextBox().isEnabled()) {
			logger.info("Validates getLoanAmtTextBox");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_21_LoanTenureCalculator_ValidatingLoanAmountTextBoxAndSlider got failed, Loan Amount Text Box is not enabled.");
			myAssert.fail();
		}
		//Validating if Loan Amount Slider is visible
		if(UI.getLoanAmtSlider().isDisplayed()) {
			logger.info("Validates getLoanAmtSlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_21_LoanTenureCalculator_ValidatingLoanAmountTextBoxAndSlider got failed, Loan Amount Slider is not visible.");
			myAssert.fail();
		}
		//Validating if Loan Amount Slider is enabled
		if(UI.getLoanAmtSlider().isEnabled()) {
			logger.info("Validates getLoanAmtSlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_21_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
			myAssert.fail();
		}
		}
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates scale change for loan amount textbox and slider of Loan Tenure Page")
	public void user_validate_scale_change_for_loan_amount_textbox_and_slider()
	{
		logger.info("Validates user_validate_scale_change_for_loan_amount_textbox_and_slider");
 
		//Moving the Slider to Initial Position
		UI.moveLoanAmtSlider(0);
		logger.info("Validates moveLoanAmtSlider");
 
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		//myAssert.assertIt(loanCalculatorPageObj.getLoanAmtTextBoxValue(), "10,00,000", "The initial value of the loan amount textbox is not 10,00,000");
		
		//Moving the slider to Desired Position
		UI.moveLoanAmtSlider(130);
		logger.info("Validates moveLoanAmtSlider");
 
		
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(UI.getLoanAmtTextBoxValue().equals("50,00,000")) {
			logger.info("Validates getLoanAmtTextBoxValue");
 
			myAssert.pass();
		}
		else {
			
			System.out.println("TestCase_22_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
		
	}
	/*-------------------------------------------------------------------------------------------------------------*/
 
	@When("user validates emi textbox andslider of Loan Tenure Page")
	public void user_validate_emi_textbox_and_slider() {
		logger.info("Validates user_validate_emi_textbox_and_slider");
 
		//Validating if EMI Text Box is visible		
		if(UI.getEMITextBox().isDisplayed()) {
			logger.info("Validates getEMITextBox");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_23_LoanTenureCalculator_ValidatingEMITextBoxAndSlider got failed, EMI Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if EMI Text Box is enabled
		if(UI.getEMITextBox().isEnabled()) {
			logger.info("Validates getEMITextBox");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_23_LoanTenureCalculator_ValidatingEMITextBoxAndSlider got failed, EMI Text Box is not enabled.");
			myAssert.fail();
		}
		if(UI.getEMISlider().isDisplayed()) {
			logger.info("Validates getEMISlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_23_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
			myAssert.fail();
		}
		//Validating if EMI Slider is enabled
		if(UI.getEMISlider().isEnabled()) {
			logger.info("Validates getEMISlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_23_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
			myAssert.fail();
		}
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates interest rate textbox and slider of Loan Tenure Page")
	public void user_validate_interest_rate_textbox_and_slider() {
		logger.info("Validates user_validate_interest_rate_textbox_and_slider");
 
		//Validating if Interest Rate Text Box is visible
		if(UI.getIntRateTextBox().isDisplayed()) {
			logger.info("Validates getIntRateTextBox");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_24_LoanTenureCalculator_ValidatingInterestRateTextBoxAndSlider got failed, Interest Rate Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if Interest Rate Text Box is enabled
		if(UI.getIntRateTextBox().isEnabled()) {
			logger.info("Validates getIntRateTextBox");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_24_LoanTenureCalculator_ValidatingInterestRateTextBoxAndSlider got failed, Interest Rate Text Box is not enabled.");
			myAssert.fail();
		}
		//Validating if Interest Rate Slider is visible
		if(UI.getIntRateSlider().isDisplayed()) {
			logger.info("Validates getIntRateSlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_24_LoanTenureCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
			myAssert.fail();
		}
		//Validating if Interest Rate Slider is enabled
		if(UI.getIntRateSlider().isEnabled()) {
			logger.info("Validates getIntRateSlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_24_LoanTenureCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
			myAssert.fail();
		}
		
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates scale change for interest rate textbox and slider of Loan Tenure Page")
	public void user_validate_scale_change_for_interest_rate_textbox_and_slider() {
		logger.info("Validates user_validate_scale_change_for_interest_rate_textbox_and_slider");
 
			//Moving the Slider to Initial Position
			UI.moveIntRateSlider(0);
			logger.info("Validates moveIntRateSlider");
 
			//Validating if the value passed to the text box is same as it is showing in the slider
			//myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75", "The initial value of the interest rate textbox is not 10.75");
			
			//Moving the slider to Desired Position
			UI.moveIntRateSlider(112);
			logger.info("Validates moveIntRateSlider");
 
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(UI.getIntRateTextBoxValue().equals("14.25")) {
			logger.info("Validates getIntRateTextBoxValue");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_25_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates fees and charges textbox and slider of Loan Tenure Page")
	public void user_validate_fees_and_charges_textbox_and_slider() {
		logger.info("Validates user_validate_fees_and_charges_textbox_and_slider");
 
		//Validating if Fees And Charges Text Box is visible
		if(UI.getFeesAndChargesTextBox().isDisplayed()) {
			logger.info("Validates getFeesAndChargesTextBox");
 
			myAssert.pass();;
		}
		else {
			System.out.println("TestCase_26_LoanTenureCalculator_ValidatingFeesAndChargesTextBoxAndSlider got failed, Fees And Charges Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if Fees And Charges Text Box is enabled
		if(UI.getFeesAndChargesTextBox().isEnabled()) {
			logger.info("Validates getFeesAndChargesTextBox");
 
			myAssert.pass();;
		}
		else {
			System.out.println("TestCase_26_LoanTenureCalculator_ValidatingFeesAndChargesTextBoxAndSlider got failed, Fees And Charges Text Box is not enabled.");
			myAssert.fail();
		}
		//Validating if Fees And Charges Slider is visible
		if(UI.getFeesAndChargesSlider().isDisplayed()) {
			logger.info("Validates getFeesAndChargesSlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_26_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
			myAssert.fail();
		}
		//Validating if Fees And Charges Slider is enabled
		if(UI.getFeesAndChargesSlider().isEnabled()) {
			logger.info("Validates getFeesAndChargesSlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_26_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
			myAssert.fail();
		}
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates scale change for fees and charges textbox and slider of Loan Tenure Page")
	public void user_validates_scale_change_for_fees_and_charges_textbox_and_slider() {
		logger.info("Validates user_validates_scale_change_for_fees_and_charges_textbox_and_slider");
 
		//Moving the Slider to Initial Position
		UI.moveFeesAndChargesSlider(0);
		logger.info("Validates moveFeesAndChargesSlider");
 
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		//myAssert.assertIt(loanCalculatorPageObj.getFeesAndChargesTextBoxValue(), "10,000", "The initial value of the fees and charges textbox is not 10,000");
		
		//Moving the slider to Desired Position
		UI.moveFeesAndChargesSlider(97);
		logger.info("Validates moveFeesAndChargesSlider");
 
 
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(UI.getFeesAndChargesTextBoxValue().equals("25,000")) {
			logger.info("Validates getFeesAndChargesTextBoxValue");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_27_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	
	@Then("loan tenure ui check validation is successful")
	public void loan_tenure_ui_check_validation_is_successful() {
		logger.info("Validates loan_tenure_ui_check_validation_is_successful");
 
	    System.out.println("Loan Tenure UI Check validation is successful");
	}
}
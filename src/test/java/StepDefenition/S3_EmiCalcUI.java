package StepDefenition;

import org.testng.Assert;
import
org.apache.logging.log4j.Logger;
import Factory.BaseClass;
import Utilities.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UIpage;

public class S3_EmiCalcUI {
	 
	Assertions myAssert = new Assertions();
	UIpage Ui = new UIpage(BaseClass.getDriver());
	Logger logger = BaseClass.getLogger();
	
	@Given("user navigates to EMI Calc Page")
	public void user_navigates_to_EMI_calc_page() {
		logger.info("Navigating to EMI Calc Page");
		//Navigating to the respective page
		UIpage Ui = new UIpage(BaseClass.getDriver());
		Ui.navigatorForEMICalc();
	}
	
	@When("user validates loan amount textbox and slider of EMI Calculator page")
	public void user_validate_interest_amount_textbox_and_slider() {
		logger.info("Validating loan amount textbox and slider");
		//Validating if Loan Amount Text Box is visible
		if(Ui.getLoanAmtTextBox().isDisplayed())
		{
			myAssert.pass();
		}
		else
		{
			System.out.println("TestCase_LoanTenureCalculator_ValidatingLoanAmountTextBoxAndSlider got failed, Loan Amount Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if Loan Amount Text Box is enabled
		if(Ui.getLoanAmtTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_LoanTenureCalculator_ValidatingLoanAmountTextBoxAndSlider got failed, Loan Amount Text Box is not enabled.");
			myAssert.fail();
		}
		//Validating if Loan Amount Slider is visible
		if(Ui.getLoanAmtSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_LoanTenureCalculator_ValidatingLoanAmountTextBoxAndSlider got failed, Loan Amount Slider is not visible.");
			myAssert.fail();
		}
		//Validating if Loan Amount Slider is enabled
		if(Ui.getLoanAmtSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase__LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
			myAssert.fail();
		}
		}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	@When("user validates scale change for loan amount textbox and slider of EMI Calculator page")
	public void user_validate_scale_change_for_loan_amount_textbox_and_slider()
	{
		logger.info("Validating scale change for loan amount textbox and slider");
		//Moving the Slider to Initial Position
		Ui.moveLoanAmtSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		
		//Moving the slider to Desired Position
		Ui.moveLoanAmtSlider(130);
		
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(Ui.getLoanAmtTextBoxValue().equals("50,00,000")) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_22_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	
	@When("user validates interest rate textbox and slider of EMI Calculator page")
	public void user_validates_interest_rate_textbox_and_slider() {
		logger.info("Validating interest rate textbox and slider");
		//Validating if Interest Rate Text Box is visible
		if(Ui.getIntRateTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_14_LoanAmtCalculator_ValidatingInterestRateTextBoxAndSlider got failed, Interest Rate Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if Interest Rate Text Box is enabled
		if(Ui.getIntRateTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_14_LoanAmtCalculator_ValidatingInterestRateTextBoxAndSlider got failed, Interest Rate Text Box is not enabled.");
			myAssert.fail();
		}
		if(Ui.getIntRateSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_14_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
			myAssert.fail();
		}
		//Validating if Interest Rate Slider is enabled
		if(Ui.getIntRateSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_14_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
			myAssert.fail();
		}
	}
 
	/*-------------------------------------------------------------------------------------------------------------*/
	
	@When("user validates scale change for interest rate textbox and slider of EMI Calculator page")
	public void user_validates_scale_change_for_interest_rate_textbox_and_slider()
	{	
		logger.info("Validating scale change for interest rate textbox and slider");
		   //Moving the Slider to Initial Position
			Ui.moveIntRateSlider(0);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			//myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75", "The initial value of the loan amount textbox is not 10.75");
			
			//Moving the slider to Desired Position
			Ui.moveIntRateSlider(112);
			//Validating if the value passed to the text box is same as it is showing in the slider
			
		if(Ui.getIntRateTextBoxValue().equals("14.25")) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_15_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
		
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	@When("user validates loan tenure textbox and slider of EMI Calculator page")
	public void user_validates_loan_tenure_textbox_and_slider() {
		logger.info("Validating loan tenure textbox and slider");
		//Validating if Loan Tenure Text Box is visible
		if(Ui.getLoanTenureTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_16_LoanAmtCalculator_ValidatingLoanTenureTextBoxAndSlider got failed, Loan Tenure Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if Loan Tenure Text Box is enabled
		if(Ui.getLoanTenureTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_16_LoanAmtCalculator_ValidatingLoanTenureTextBoxAndSlider got failed, Loan Tenure Text Box is not enabled.");
			myAssert.fail();
		}
		if(Ui.getLoanTenureSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_11_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
			myAssert.fail();
		}
		//Validating if Loan Tenure Slider is enabled
		if(Ui.getLoanTenureSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_11_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
			myAssert.fail();
		}
	}
 
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates scale change for loan tenure textbox and slider of EMI Calculator page")
	public void user_validates_scale_change_for_loan_tenure_textbox_and_slider()
	{
		logger.info("Validating scale change for loan tenure textbox and slider");
		//Moving the Slider to Initial Position
		Ui.moveLoanTenureSlider(0);	
		//Validating if the value passed to the text box is same as it is showing in the slider
		//myAssert.assertIt(loanCalculatorPageObj.getLoanTenureTextBoxValue(), "5", "The initial value of the loan tenure textbox is not 5");
		//Moving the slider to Desired Position
		Ui.moveLoanTenureSlider(105);
		
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(Ui.getLoanTenureTextBoxValue().equals("10")) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_17_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
 
	@When("user validates year and month option of EMI Calculator page")
	public void user_validates_year_and_month_option() {
		logger.info("Validating year and month option");
		//Clicking on the year button
		Ui.clickYear();
		//Storing the value of year in a string
		String yearVal = Ui.getLoanTenureTextBoxValue();
		//Converting the year value to the month value
		int yearValInInt = Integer.parseInt(yearVal);
		//Clicking on the month Button
		Ui.clickMonth();
		//Storing the value of month in a string
		String monthVal = Ui.getLoanTenureTextBoxValue();
		//Asserting the values
		if(monthVal.equals(Integer.toString(yearValInInt*12))) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_19_LoanAmtCalculator_ValidationForYearAndMonthOption got failed, The data flow between the year and month is not proper in the Loan Amount Calculator Section..");
			myAssert.fail();
		}
		
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	@When("user validates fees and charges textbox and slider of EMI Calculator page")
	public void user_validate_fees_and_charges_textbox_and_slider() {
		 logger.info("Validating fees and charges textbox and slider");
		//Validating if Fees And Charges Text Box is visible
		if(Ui.getFeesAndChargesTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_26_LoanTenureCalculator_ValidatingFeesAndChargesTextBoxAndSlider got failed, Fees And Charges Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Fees And Charges Text Box is enabled
		if(Ui.getFeesAndChargesTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_26_LoanTenureCalculator_ValidatingFeesAndChargesTextBoxAndSlider got failed, Fees And Charges Text Box is not enabled.");
			myAssert.fail();
		}
		//Validating if Fees And Charges Slider is visible
		if(Ui.getFeesAndChargesSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_26_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Fees And Charges Slider is enabled
		if(Ui.getFeesAndChargesSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			
			System.out.println("TestCase_26_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
			myAssert.fail();
		}
		
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates scale change for fees and charges textbox and slider of EMI Calculator page")
	public void user_validates_scale_change_for_fees_and_charges_textbox_and_slider() {
		 logger.info("user_validates_scale_change_for_fees_and_charges_textbox_and_slider");
		//Moving the Slider to Initial Position
		Ui.moveFeesAndChargesSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		//myAssert.assertIt(loanCalculatorPageObj.getFeesAndChargesTextBoxValue(), "10,000", "The initial value of the fees and charges textbox is not 10,000");
		
		//Moving the slider to Desired Position
		Ui.moveFeesAndChargesSlider(97);
 
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(Ui.getFeesAndChargesTextBoxValue().equals("25,000")) {
			myAssert.pass();
		}
		else {
			
			System.out.println("TestCase_27_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
		
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	
 
	/*-------------------------------------------------------------------------------------------------------------*/
	@Then("Emi Calculator ui check validation is successful")
	public void EMI_Calc_ui_check_validation_is_successful() {
	    System.out.println("EMI Calculator UI Check validation is successful");
	}
 
}
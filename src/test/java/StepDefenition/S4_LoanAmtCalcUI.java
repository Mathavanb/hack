package StepDefenition;



import Factory.BaseClass;
import Utilities.Assertions;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UIpage;

public class S4_LoanAmtCalcUI {
	 
	Logger logger = BaseClass.getLogger();
	Assertions myAssert = new Assertions();
	UIpage UI = new UIpage(BaseClass.getDriver());
 
	@Given("user click the loan amount calculator button")
	public void user_click_the_loan_amount_calculator_button() {
		logger.info("user_click_the_loan_amount_calculator_button");
		//Navigating to the respective page
		UI.navigatorForLoanAmountCalc();
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	
	@When("user validates emi textbox and slider of Loan Amount Calculator Page")
	public void user_validates_emi_textbox_and_slider() {
		logger.info("user_validates_emi_textbox_and_slider");
		//Validating if EMI Text Box is visible
		if(UI.getEMITextBox().isDisplayed())
		{
			logger.info("getEMITextBox");
			myAssert.pass();
		}
		else
		{
			System.out.println("TestCase_13_LoanAmtCalculator_ValidatingEMITextBoxAndSlider got failed, EMI Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if EMI Text Box is enabled
		if(UI.getEMITextBox().isEnabled())
		{
			logger.info("getEMITextBox");
			myAssert.pass();
		}
		else
		{
			System.out.println("TestCase_13_LoanAmtCalculator_ValidatingEMITextBoxAndSlider got failed, EMI Text Box is not enabled.");
			myAssert.fail();
		}
		if(UI.getEMISlider().isDisplayed()) {
			logger.info("getEMISlider");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_13_LoanAmtCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
			myAssert.fail();
		}
		//Validating if EMI Slider is enabled
		if(UI.getEMISlider().isEnabled()) {
			logger.info("getEMISlider");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_13_LoanAmtCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
			myAssert.fail();
		}
	}
 
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates interest rate textbox and slider of Loan Amount Calculator Page")
	public void user_validates_interest_rate_textbox_and_slider() {
		logger.info("user_validates_interest_rate_textbox_and_slider");
		
		//Validating if Interest Rate Text Box is visible
		if(UI.getIntRateTextBox().isDisplayed()) {
			logger.info("Validates getIntRateTextBox ");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_14_LoanAmtCalculator_ValidatingInterestRateTextBoxAndSlider got failed, Interest Rate Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if Interest Rate Text Box is enabled
		if(UI.getIntRateTextBox().isEnabled()) {
			logger.info("Validates getIntRateTextBox ");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_14_LoanAmtCalculator_ValidatingInterestRateTextBoxAndSlider got failed, Interest Rate Text Box is not enabled.");
			myAssert.fail();
		}
		if(UI.getIntRateSlider().isDisplayed()) {
			logger.info("Validates getIntRateSlider ");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_14_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
			myAssert.fail();
		}
		//Validating if Interest Rate Slider is enabled
		if(UI.getIntRateSlider().isEnabled()) {
			logger.info("Validates getIntRateSlider ");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_14_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
			myAssert.fail();
		}
	}
 
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates scale change for interest rate textbox and slider of Loan Amount Calculator Page")
	public void user_validates_scale_change_for_interest_rate_textbox_and_slider() {
		logger.info("Validates user_validates_scale_change_for_interest_rate_textbox_and_slider");
		   //Moving the Slider to Initial Position
			UI.moveIntRateSlider(0);
			logger.info("Validates moveIntRateSlider");
			//Validating if the value passed to the text box is same as it is showing in the slider
			//myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75", "The initial value of the loan amount textbox is not 10.75");
			
			//Moving the slider to Desired Position
			UI.moveIntRateSlider(112);
			logger.info("Validates moveIntRateSlider");
			//Validating if the value passed to the text box is same as it is showing in the slider
			
		if(UI.getIntRateTextBoxValue().equals("14.25")) {
			logger.info("Validates getIntRateTextBoxValue");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_15_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
		
	}
 
	
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates loan tenure textbox and slider of Loan Amount Calculator Page")
	public void user_validates_loan_tenure_textbox_and_slider() {
		logger.info("Validates user_validates_loan_tenure_textbox_and_slider");
		//Validating if Loan Tenure Text Box is visible
		if(UI.getLoanTenureTextBox().isDisplayed()) {
			logger.info("Validates getLoanTenureTextBox");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_16_LoanAmtCalculator_ValidatingLoanTenureTextBoxAndSlider got failed, Loan Tenure Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if Loan Tenure Text Box is enabled
		if(UI.getLoanTenureTextBox().isEnabled()) {
			logger.info("Validates getLoanTenureTextBox");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_16_LoanAmtCalculator_ValidatingLoanTenureTextBoxAndSlider got failed, Loan Tenure Text Box is not enabled.");
			myAssert.fail();
		}
		if(UI.getLoanTenureSlider().isDisplayed()) {
			logger.info("Validates getLoanTenureSlider");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_11_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
			myAssert.fail();
		}
		//Validating if Loan Tenure Slider is enabled
		if(UI.getLoanTenureSlider().isEnabled()) {
			logger.info("Validates getLoanTenureSlider");
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_11_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
			myAssert.fail();
		}
	}
 
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates scale change for  loan tenure textbox and slider of Loan Amount Calculator Page")
	public void user_validates_scale_change_for_loan_tenure_textbox_and_slider()
	{
		logger.info("Validates user_validates_scale_change_for_loan_tenure_textbox_and_slider");
		//Moving the Slider to Initial Position
		UI.moveLoanTenureSlider(0);	
		logger.info("Validates moveLoanTenureSlider");
		//Validating if the value passed to the text box is same as it is showing in the slider
		//myAssert.assertIt(loanCalculatorPageObj.getLoanTenureTextBoxValue(), "5", "The initial value of the loan tenure textbox is not 5");
		//Moving the slider to Desired Position
		UI.moveLoanTenureSlider(105);
		logger.info("Validates moveLoanTenureSlider");
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(UI.getLoanTenureTextBoxValue().equals("10")) {
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_17_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
 
	/*-------------------------------------------------------------------------------------------------------------*/
	
	@When("user validates year and month option of Loan Amount Calculator Page")
	public void user_validates_year_and_month_option() {
		logger.info("Validates user validates year and month option of Loan Amount Calculator Page");
		//Clicking on the year button
		UI.clickYear();
		logger.info("Validates clickYear");
 
		//Storing the value of year in a string
		String yearVal = UI.getLoanTenureTextBoxValue();
		logger.info("Validates getLoanTenureTextBoxValue");
 
		//Converting the year value to the month value
		int yearValInInt = Integer.parseInt(yearVal);
		//Clicking on the month Button
		UI.clickMonth();
		logger.info("Validates clickMonth");
 
		//Storing the value of month in a string
		String monthVal = UI.getLoanTenureTextBoxValue();
		logger.info("Validates getLoanTenureTextBoxValue");
 
		//Asserting the values
		if(monthVal.equals(Integer.toString(yearValInInt*12))) {
			logger.info("Validates equals");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_19_LoanAmtCalculator_ValidationForYearAndMonthOption got failed, The data flow between the year and month is not proper in the Loan Amount Calculator Section..");
			myAssert.fail();
		}
		
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates fees and charges textbox and slider of Loan Amount Calculator Page")
	public void user_validates_fees_and_charges_textbox_and_slider() {
		logger.info("Validates user_validates_fees_and_charges_textbox_and_slider");
 
		//Validating if Fees And Charges Text Box is visible
		if(UI.getFeesAndChargesTextBox().isDisplayed()) {
			logger.info("Validates getFeesAndChargesTextBox");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_18_LoanAmtCalculator_ValidatingFeesAndChargesTextBoxAndSlider got failed, Fees And Charges Text Box is not visible.");
			myAssert.fail();
		}
		//Validating if Fees And Charges Text Box is enabled
		if(UI.getFeesAndChargesTextBox().isEnabled()) {
			logger.info("Validates getFeesAndChargesTextBox");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_18_LoanAmtCalculator_ValidatingFeesAndChargesTextBoxAndSlider got failed, Fees And Charges Text Box is not enabled.");
			myAssert.fail();
		}
		if(UI.getFeesAndChargesSlider().isDisplayed()) {
			logger.info("Validates getFeesAndChargesSlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_13_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
			myAssert.fail();
		}
		//Validating if Fees And Charges Slider is enabled
		if(UI.getFeesAndChargesSlider().isEnabled()) {
			logger.info("Validates getFeesAndChargesSlider");
 
			myAssert.pass();
		}
		else {
			System.out.println("TestCase_13_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
			myAssert.fail();
		}
	}
 
 
	/*-------------------------------------------------------------------------------------------------------------*/
	@When("user validates scale change for fees and charges textbox and slider of Loan Amount Calculator Page")
	public void user_validates_scale_change_for_fees_and_charges_textbox_and_slider()
	{
		//Moving the Slider to Initial Position
		logger.info("Validates user_validates_scale_change_for_fees_and_charges_textbox_and_slider");
 
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
			System.out.println("TestCase_20_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
 
 
	/*-------------------------------------------------------------------------------------------------------------*/
	@Then("loan amount calculator ui check validation is successful")
	public void loan_amount_calculator_ui_check_validation_is_successful() {
		logger.info("Validates loan_amount_calculator_ui_check_validation_is_successful");
 
		System.out.println("Loan Amount Calculator UI check validation is successful");
	}
}
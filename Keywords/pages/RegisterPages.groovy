package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import global.ObjectGlobalPages
import internal.GlobalVariable

public class RegisterPages {
	ObjectGlobalPages ObjectGlobal = new ObjectGlobalPages()

	private TestObject createAccount
	private TestObject firstName
	private TestObject lastName
	private TestObject emailField
	private TestObject passwordField
	private TestObject confirmPassword
	private TestObject btnSubmit

	def RegisterPages() {
		createAccount = ObjectGlobal.getTestObject("(//a[contains(text(),'Create')])[1]")
		firstName = ObjectGlobal.getTestObject("//input[@title='First Name']")
		lastName = ObjectGlobal.getTestObject("//input[@title='Last Name']")
		emailField = ObjectGlobal.getTestObject("//input[@id='email_address']")
		passwordField = ObjectGlobal.getTestObject("//input[@id='password']")
		confirmPassword = ObjectGlobal.getTestObject("//input[@id='password-confirmation']")
		btnSubmit = ObjectGlobal.getTestObject("//button[@title='Create an Account']")
	}

	def PersonalInfo(String firstname, String lastname) {
		//Assert
		assert firstname && !firstname.isEmpty() : "ERROR: First Name is Required"
		assert lastname && !lastname.isEmpty() : "ERROR: Last Name is Required"

		WebUI.verifyElementPresent(createAccount, 5)
		WebUI.click(createAccount)

		WebUI.setText(firstName, firstname)
		WebUI.setText(lastName, lastname)
	}

	def SignIn(String email, String password, String confirm) {
		//Assert
		assert emailField && passwordField && confirmPassword && btnSubmit : "ERROR: Invalid credentials"
		assert email && !email.isEmpty() : "ERROR: Email is Required"
		assert password && !password.isEmpty() : "ERROR: Password is Required"
		assert confirm && !confirm.isEmpty() : "ERROR: Confirm Password is Required"

		WebUI.setText(emailField, email)
		WebUI.setText(passwordField, password)
		WebUI.setText(confirmPassword, confirm)
		WebUI.click(btnSubmit)
		WebUI.delay(2)
	}
}

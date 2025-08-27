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

public class LoginPages {
	ObjectGlobalPages ObjectGlobal = new ObjectGlobalPages()

	private TestObject loginButton
	private TestObject emailField
	private TestObject passwordField
	private TestObject btnSignin

	def Login() {
		loginButton = ObjectGlobal.getTestObject("//a[@class='action my-account']")
		emailField = ObjectGlobal.getTestObject("//input[@id='email' and @type='email']")
		passwordField = ObjectGlobal.getTestObject("//input[@id='pass' and @type='password']")
		btnSignin = ObjectGlobal.getTestObject("//form[@id='login-form']//button[@id='send2']")
	}

	def loginInfo(String email, String password) {
		assert emailField && !emailField.isEmpty() : "ERROR: Email is Required"
		assert password && !password.isEmpty() : "ERROR: Password is Required"

		WebUI.verifyElementPresent(loginButton, 5)
		WebUI.click(loginButton)

		WebUI.setText(emailField, email)
		WebUI.setText(passwordField, password)
		WebUI.click(btnSignin)
		WebUI.delay(2)
	}
}

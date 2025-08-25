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

public class CheckoutPages {
	ObjectGlobalPages ObjectGlobal = new ObjectGlobalPages()

	private TestObject StreetAddress
	private TestObject cityField
	private TestObject postCode
	private TestObject phoneField
	private TestObject radioTableRate
	private TestObject radioFixed
	private TestObject countryList
	private TestObject countryOption
	private TestObject checkBox
	private TestObject placeOrder
	private TestObject printReceipt
	private TestObject btnNext

	def  CheckoutPages() {
		StreetAddress = ObjectGlobal.getTestObject("//input[@type='text'])[4]")
		cityField = ObjectGlobal.getTestObject("//input[@type='text'])[7]")
		postCode = ObjectGlobal.getTestObject("//input[@type='text'])[9]")
		phoneField = ObjectGlobal.getTestObject("//input[@type='text'])[10]")
		radioTableRate = ObjectGlobal.getTestObject("//input[@type='radio'])[1]")
		radioFixed = ObjectGlobal.getTestObject("//input[@type='radio'])[2]")
		countryList = ObjectGlobal.getTestObject("//select[@name='country_id']")
		countryOption = ObjectGlobal.getTestObject("//option[@data-title='Indonesia']")
		checkBox = ObjectGlobal.getTestObject("//input[@type='checkbox' and @name='billing-address-same-as-shipping']")
		placeOrder = ObjectGlobal.getTestObject("//button[@title='Place Order']")
		printReceipt = ObjectGlobal.getTestObject("//a[contains(@class,'action print')]")
		btnNext = ObjectGlobal.getTestObject("//button[@data-role='opc-continue']")
	}

	def shippingAddress(String Address, String city, String code, String phone) {
		WebUI.takeFullPageScreenshot()
		WebUI.waitForElementPresent(StreetAddress, 5)
		WebUI.verifyElementPresent(StreetAddress, 5)
		WebUI.setText(StreetAddress, Address)
		WebUI.delay(2)
		WebUI.verifyElementPresent(cityField, 5)
		WebUI.setText(cityField, city)
		WebUI.delay(2)
		WebUI.verifyElementPresent(countryList, 5)
		WebUI.click(countryList)
		WebUI.verifyElementPresent(countryOption, 5)
		WebUI.click(countryOption)
		WebUI.delay(2)
		WebUI.verifyElementPresent(postCode, 5)
		WebUI.setText(postCode, code)
		WebUI.delay(2)
		WebUI.verifyElementPresent(phoneField, 5)
		WebUI.setText(phoneField, Address)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}


	def shippingMethods() {
		WebUI.verifyElementPresent(radioTableRate, 5)
		WebUI.click(radioTableRate)
		WebUI.verifyElementPresent(btnNext, 5)
		WebUI.click(btnNext)
		WebUI.delay(2)
	}

	def reviewPayment() {
		WebUI.verifyElementPresent(placeOrder, 5)
		WebUI.click(placeOrder)
		WebUI.delay(2)
		WebUI.verifyElementPresent(printReceipt, 5)
		WebUI.click(printReceipt)
		WebUI.delay(2)
	}
}

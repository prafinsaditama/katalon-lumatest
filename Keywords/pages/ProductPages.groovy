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

public class ProductPages {
	ObjectGlobalPages ObjectGlobal = new ObjectGlobalPages()

	private TestObject productName
	private TestObject sizeProduct
	private TestObject colorProduct
	private TestObject quantity
	private TestObject AddtoCart

	def  ProductPages(String name, String size, String color) {
		productName = ObjectGlobal.getTestObject("//strong[@class='product name product-item-name']/a[contains(text(), '${name}')]")
		sizeProduct = ObjectGlobal.getTestObject("//div[@class='swatch-option text' and text()='${size}']")
		colorProduct = ObjectGlobal.getTestObject("//div[@class='swatch-option color' and @option-label='${color}']")
		quantity = ObjectGlobal.getTestObject("//input[@id='qty']")
		AddtoCart = ObjectGlobal.getTestObject("//button[span[text()='Add to Cart']]")
	}

	def menu() {
		WebUI.takeFullPageScreenshot()
		WebUI.waitForElementPresent(menuField, 5)
		WebUI.verifyElementPresent(menuField, 5)
		WebUI.click(menuField)
		WebUI.delay(2)
		WebUI.takeFullPageScreenshot()
	}
}

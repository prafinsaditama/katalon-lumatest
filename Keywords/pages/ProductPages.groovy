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
	private TestObject shopCart
	private TestObject proceedCheckout

	def ProductPages(String name, String size, String color) {
		productName = ObjectGlobal.getTestObject("//strong[@class='product name product-item-name']/a[contains(text(), '${name}')]")
		sizeProduct = ObjectGlobal.getTestObject("//div[@class='swatch-option text' and text()='${size}']")
		colorProduct = ObjectGlobal.getTestObject("//div[@class='swatch-option color' and @option-label='${color}']")
		quantity = ObjectGlobal.getTestObject("//input[@id='qty']")
		AddtoCart = ObjectGlobal.getTestObject("//button[span[text()='Add to Cart']]")
		shopCart = ObjectGlobal.getTestObject("//a[@class='action showcart']")
		proceedCheckout = ObjectGlobal.getTestObject("//button[normalize-space(text())='Proceed to Checkout']")
	}

	def productAdd() {
		WebUI.takeFullPageScreenshot()
		WebUI.waitForElementPresent(productName, 5)
		WebUI.verifyElementPresent(productName, 5)
		WebUI.click(productName)
		WebUI.delay(2)
		WebUI.verifyElementPresent(sizeProduct, 5)
		WebUI.click(sizeProduct)
		WebUI.verifyElementPresent(colorProduct, 5)
		WebUI.click(colorProduct)
		WebUI.verifyElementPresent(AddtoCart, 5)
		WebUI.click(AddtoCart)
		WebUI.delay(10)
		WebUI.takeFullPageScreenshot()
	}

	def checkOutflow() {
		WebUI.takeScreenshot()
		WebUI.waitForElementPresent(shopCart, 5)
		WebUI.verifyElementPresent(shopCart, 5)
		WebUI.click(shopCart)
		WebUI.delay(2)
		WebUI.verifyElementPresent(proceedCheckout, 5)
		WebUI.click(proceedCheckout)
		WebUI.delay(10)
		WebUI.takeScreenshot()
	}
}

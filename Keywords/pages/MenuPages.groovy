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

public class MenuPages {
	ObjectGlobalPages ObjectGlobal = new ObjectGlobalPages()

	private TestObject menuField

	def  MenuPages(String menu) {
		menuField = ObjectGlobal.getTestObject("//a[.//span[text()='${menu}']]")
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

public class SubMenuPages{
	ObjectGlobalPages ObjectGlobal = new ObjectGlobalPages()

	private TestObject subMenuField

	def SubMenuPages(String subMenu) {
		subMenuField = ObjectGlobal.getTestObject("//a[contains(text(), '${subMenu}')]")
	}

	def submenu() {
		WebUI.takeScreenshot()
		boolean isElementVisible = WebUI.verifyElementVisible(subMenuField, FailureHandling.OPTIONAL)
		if (!isElementVisible) {
			WebUI.executeJavaScript('window.scrollBy(0, 250);', null)
			WebUI.scrollToElement(subMenuField, 10, FailureHandling.OPTIONAL)
		}
		WebUI.waitForElementPresent(subMenuField, 5)
		WebUI.verifyElementPresent(subMenuField, 5)
		WebUI.click(subMenuField)
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}
}
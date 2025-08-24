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

public class LogoutPages {
	ObjectGlobalPages ObjectGlobal = new ObjectGlobalPages()

	private TestObject profileField
	private TestObject btnLogout

	def Logout() {
		profileField = ObjectGlobal.getTestObject("//span[contains(@class, 'oxd-userdropdown-tab')]")
		btnLogout = ObjectGlobal.getTestObject("//li//a[text()='Logout']")
	}

	def logout() {
		WebUI.click(profileField)
		WebUI.click(btnLogout)
	}
}

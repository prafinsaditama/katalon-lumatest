import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext

import internal.GlobalVariable
import pages.RegisterPages
import pages.LogoutPages

class LoginLogout {

    @BeforeTestCase
    def beforeTestCase(TestCaseContext testCaseContext) {
        // Optional log output
        println "Running test case: ${testCaseContext.getTestCaseId()}"

        // Start browser and login
        WebUI.openBrowser('')
        WebUI.maximizeWindow()
        WebUI.navigateToUrl(GlobalVariable.URL)

        RegisterPages registerPage = new RegisterPages()
        registerPage.login(GlobalVariable.Username, GlobalVariable.Password)
    }

    @AfterTestCase
    def afterTestCase(TestCaseContext testCaseContext) {
        // Optional log output
        println "Finished test case: ${testCaseContext.getTestCaseId()} with status: ${testCaseContext.getTestCaseStatus()}"

        // Perform logout and close browser
        LogoutPages logoutPage = new LogoutPages()
        logoutPage.logout()

        WebUI.closeBrowser()
    }
}

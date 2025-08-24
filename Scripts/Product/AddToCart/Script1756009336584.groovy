import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import pages.ProductPages

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import pages.ProductPages

// Test Case: Add Product to Cart Successfully
// Data: pilih produk "Radiant Tee", size "M", color "Blue"

// Step 1: Buka browser dan navigate ke halaman produk
WebUI.openBrowser('')
WebUI.navigateToUrl('https://magento.softwaretestingboard.com/') // ganti sesuai URL aplikasi

// Step 2: Buat instance dari ProductPages dengan parameter (name, size, color)
ProductPages productPage = new ProductPages("Radiant Tee", "M", "Blue")

// Step 3: Verify produk tampil
WebUI.verifyElementPresent(productPage.productName, 10)

// Step 4: Klik produk
productPage.selectProduct()

// Step 5: Pilih size
productPage.selectSize()

// Step 6: Pilih warna
productPage.selectColor()

// Step 7: Isi quantity
productPage.setQuantity("2")

// Step 8: Klik Add to Cart
productPage.addProductToCart()

// Step 9: Verifikasi notifikasi sukses muncul
TestObject successMsg = findTestObject('Object Repository/ProductPages/msg_success')
WebUI.verifyElementPresent(successMsg, 10)

// Step 10: Tutup browser
WebUI.closeBrowser()




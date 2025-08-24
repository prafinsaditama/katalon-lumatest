package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import global.ObjectGlobalPages

public class ProductPages {
    ObjectGlobalPages ObjectGlobal = new ObjectGlobalPages()

    private TestObject productName
    private TestObject sizeProduct
    private TestObject colorProduct
    private TestObject quantity
    private TestObject addToCart
    private TestObject menuMen
    private TestObject menuTops
    private TestObject menuTees
    private TestObject successMsg   // ✅ tambahan untuk verifikasi notifikasi sukses

    // ✅ Constructor untuk product detail
    public ProductPages(String name, String size, String color) {
        // Lokator menu navigasi
        menuMen   = ObjectGlobal.getTestObject("//span[text()='Men']")
        menuTops  = ObjectGlobal.getTestObject("//a[@id='ui-id-17']//span[text()='Tops']")
        menuTees  = ObjectGlobal.getTestObject("//a[@id='ui-id-20']//span[text()='Tees']")

        // Lokator produk dan atributnya
        productName  = ObjectGlobal.getTestObject("//a[@class='product-item-link' and normalize-space(text())='${name}']")
        sizeProduct  = ObjectGlobal.getTestObject("//div[contains(@class,'swatch-option text') and normalize-space(text())='${size}']")
        colorProduct = ObjectGlobal.getTestObject("//div[contains(@class,'swatch-option color') and @option-label='${color}']")
        quantity     = ObjectGlobal.getTestObject("//input[@id='qty']")
        addToCart    = ObjectGlobal.getTestObject("//form[@id='product_addtocart_form']//button[@type='submit']")

        // ✅ Lokator notifikasi sukses
        successMsg   = ObjectGlobal.getTestObject("//div[@role='alert']//div[contains(text(),'You added')]")
    }

    // Navigasi ke kategori Tees (Men > Tops > Tees)
    public void goToTeesCategory() {
        WebUI.waitForElementClickable(menuMen, 10)
        WebUI.click(menuMen)

        WebUI.waitForElementClickable(menuTops, 10)
        WebUI.click(menuTops)

        WebUI.waitForElementClickable(menuTees, 10)
        WebUI.click(menuTees)

        WebUI.delay(2)
        WebUI.takeFullPageScreenshot()
    }

    // Action: pilih produk di halaman kategori
    public void selectProduct() {
        WebUI.verifyElementPresent(productName, 10)
        WebUI.waitForElementClickable(productName, 10)
        WebUI.click(productName)
    }

    // Action: pilih size
    public void selectSize() {
        WebUI.waitForElementClickable(sizeProduct, 10)
        WebUI.click(sizeProduct)
    }

    // Action: pilih warna
    public void selectColor() {
        WebUI.waitForElementClickable(colorProduct, 10)
        WebUI.click(colorProduct)
    }

    // Action: isi quantity
    public void setQuantity(String qty) {
        WebUI.clearText(quantity)
        WebUI.setText(quantity, qty)
    }

    // Action: klik Add to Cart
    public void addProductToCart() {
        WebUI.waitForElementClickable(addToCart, 10)
        WebUI.click(addToCart)
    }

    // ✅ Verifikasi notifikasi sukses setelah add to cart
    public void verifyAddToCartSuccess() {
        WebUI.verifyElementPresent(successMsg, 10)
        WebUI.takeScreenshot()
    }
}

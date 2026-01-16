package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import Utilities.ExtentManager;

/*
 * @author
 * @version 1.0
 */
public class BasePage {
    // =====================================
    // PROPERTIES AND CONFIGURATIONS
    // =====================================
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;
    private static final int DEFAULT_TIMEOUT = 15;

    public BasePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("El WebDriver pasado a BasePage no puede ser null.");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // =====================================
    // AUXILIARES
    // =====================================
    private String getElementDescription(WebElement element) {
        try {
            String id = element.getAttribute("id");
            if (id != null && !id.isEmpty()) return "element with id='" + id + "'";

            String name = element.getAttribute("name");
            if (name != null && !name.isEmpty()) return "element with name='" + name + "'";

            return element.toString();
        } catch (Exception e) {
            return "element";
        }
    }

    // =====================================
    //  WAITS
    // =====================================
    public void waitForClassChange(WebElement element, String expectedClass, long timeout) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            customWait.until((ExpectedCondition<Boolean>) d -> {
                String currentClass = element.getAttribute("class");
                return currentClass != null && currentClass.contains(expectedClass);
            });
            ExtentManager.getTest().pass("Class changed to contain: " + expectedClass);
        } catch (Exception e) {
            String currentClass = element.getAttribute("class");
            ExtentManager.getTest().fail("Class did not change. Expected: '" + expectedClass + "', Current: '" + currentClass + "'");
            throw e;
        }
    }

    public void waitForElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            ExtentManager.getTest().info("Element is now visible: " + getElementDescription(element));
        } catch (Exception e) {
            ExtentManager.getTest().fail("Element not visible within timeout: " +
                    getElementDescription(element));
            throw e;
        }
    }

    public void waitForElementClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            ExtentManager.getTest().info("Element is now clickable: " + getElementDescription(element));
        } catch (Exception e) {
            ExtentManager.getTest().fail("Element not clickable within timeout: " +
                    getElementDescription(element));
            throw e;
        }
    }

    // =====================================
    // VERIFICATION METHODS
    // =====================================
    public boolean isElementDisplayedWithWait(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            ExtentManager.getTest().warning("Element not displayed within timeout: " + getElementDescription(element));
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            ExtentManager.getTest().warning("Element is not displayed: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementNotVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            ExtentManager.getTest().warning("Element is still visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            ExtentManager.getTest().warning("Element is not enabled: " + e.getMessage());
            return false;
        }
    }

    // =====================================
    // CLICKS METHODS
    // =====================================
    public void clickWithJs(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
            jsExecutor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.err.println("No se pudo realizar el clic JS en el elemento: " + e.getMessage());
            throw e;
        }
    }

    public void doubleClick(WebElement element) {
        try {
            waitForElementClickable(element);
            actions.doubleClick(element).perform();
            ExtentManager.getTest().pass("Double clicked on: " + getElementDescription(element));
        } catch (Exception e) {
            ExtentManager.getTest().fail("Double click failed: " + e.getMessage());
            throw e;
        }
    }

    public void rightClick(WebElement element) {
        try {
            waitForElementClickable(element);
            actions.contextClick(element).perform();
            ExtentManager.getTest().pass("Right clicked on: " + getElementDescription(element));
        } catch (Exception e) {
            ExtentManager.getTest().fail("Right click failed: " + e.getMessage());
            throw e;
        }
    }

    // =====================================
    // INPUT METHODS
    // =====================================

    public void type(WebElement element, String text) {
        try {
            WebElement visibleElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            visibleElement.clear();
            visibleElement.sendKeys(text);
            ExtentManager.getTest().info("Entered text: '" + text + "' in " + getElementDescription(element));
        } catch (Exception e) {
            ExtentManager.getTest().fail("Failed to type in element: " + e.getMessage());
            throw e;
        }
    }

    public void typeSlowly(WebElement element, String text) {
        try {
            WebElement visibleElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            visibleElement.clear();
            for (char c : text.toCharArray()) {
                visibleElement.sendKeys(String.valueOf(c));
                sleep(100);
            }
            ExtentManager.getTest().info("Successfully typed text slowly");
        } catch (Exception e) {
            ExtentManager.getTest().fail("Failed to type slowly: " + e.getMessage());
            throw e;
        }
    }

    public String getText(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String text = element.getText().trim();
            if (text.isEmpty()) {
                ExtentManager.getTest().warning("The element was found, but the text is empty.");
            }
            ExtentManager.getTest().info("Text obtained successfully: " + text);
            return text;
        } catch (Exception e) {
            ExtentManager.getTest().fail("Failed to get text from element. Error: " + e.getMessage());
            throw e;
        }
    }

    public String forceGetText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            return (String) jsExecutor.executeScript(
                    "return (arguments[0].textContent || arguments[0].innerText || '').trim();",
                    element
            );
        } catch (Exception e) {
            System.err.println("Error al obtener texto: " + e.getMessage());
            return "";
        }
    }

    public String getAttribute(WebElement element, String attributeName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String value = element.getAttribute(attributeName);
            ExtentManager.getTest().info("Attribute '" + attributeName + "': '" + value + "' from " + getElementDescription(element));
            return value;
        } catch (Exception e) {
            ExtentManager.getTest().fail("Failed to get attribute '" + attributeName + "': " + e.getMessage());
            throw e;
        }
    }

    // =====================================
    // SCROLL AND NAVEGATION METHODS
    // =====================================

    public void scrollToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            jsExecutor.executeScript(
                    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                    element);
            ExtentManager.getTest().info("Scrolled to: " + getElementDescription(element));
        } catch (Exception e) {
            ExtentManager.getTest().fail("Failed to scroll to element: " + e.getMessage());
            throw e;
        }
    }
    // =====================================
    // WINDOWS AND TABS METHODS
    // =====================================

    public void switchToNewWindow() {
        String currentTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        ExtentManager.getTest().info("Switching to a new window");
    }

    public void closeCurrentTabAndSwitchBack() {
        driver.close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void refreshPage() {
        ExtentManager.getTest().info("Refrescando página");
        driver.navigate().refresh();
    }

    // =====================================
    // FRAMES METHODS
    // =====================================

    public void switchToFrame(WebElement frameElement) {
        ExtentManager.getTest().info("Cambiando a frame");
        driver.switchTo().frame(frameElement);
    }

    public void switchToDefaultContent() {
        ExtentManager.getTest().info("Volviendo al contenido principal");
        driver.switchTo().defaultContent();
    }

    // =====================================
    // ALERT METHODS
    // ===========getAlertText==========================
    private Alert waitForAlert() {
        try {
            return wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            ExtentManager.getTest().fail("La alerta no apareció dentro del tiempo esperado.");
            throw e;
        }
    }

    public void acceptAlert() {
        waitForAlert().accept();
        ExtentManager.getTest().info("Alerta aceptada con éxito.");

    }

    public void dismissAlert() {
        waitForAlert().dismiss();
        ExtentManager.getTest().info("Alerta rechazada/cancelada.");

    }

    public String getAlertText() {
        String text = waitForAlert().getText();
        ExtentManager.getTest().info("Texto capturado de la alerta: " + text);
        return text;
    }

    public void typeInAlert(String text) {
        waitForAlert().sendKeys(text);
        ExtentManager.getTest().info("Texto enviado a la alerta: " + text);
    }

    // =====================================
    // UTILITY METHODS
    // =====================================
    public void sleep(int milliseconds) {
        try {
            java.util.concurrent.TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura el estado de interrupción
            ExtentManager.getTest().fail("El hilo de espera fue interrumpido: " + e.getMessage());
        }
    }
    /*
    public void
    sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     */

    public String getCurrentUrl() {
        try {
            String url = driver.getCurrentUrl();
            ExtentManager.getTest().info("URL actual capturada: " + url);
            return url;
        } catch (Exception e) {
            ExtentManager.getTest().warning("No se pudo obtener la URL actual.");
            return "";
        }
    }

    public Object executeJS(String script, Object... args) {
        try {
            return jsExecutor.executeScript(script, args);
        } catch (Exception e) {
            ExtentManager.getTest().fail("Error al ejecutar JavaScript: " + e.getMessage());
            throw e;
        }
    }

    public void waitForPageLoad() {
        try {
            wait.until(webDriver -> jsExecutor.executeScript("return document.readyState").equals("complete"));
            ExtentManager.getTest().pass("Página cargada completamente.");
        } catch (TimeoutException e) {
            ExtentManager.getTest().warning("La página no terminó de cargar en el tiempo esperado.");
        }
    }

}


package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverWaits {

    WebDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    public DriverWaits(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement esperarElementoCarregar(By ByElement){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));
    }

    public void esperarElementoClicar(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement tentarLocalizarElemento(By byElement){
        return fluentWait.until(driver -> driver.findElement(byElement));
    }
}

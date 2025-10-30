package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverWaits;

public class MelhoresAtacantesLutadorPage {

    WebDriver driver;
    DriverWaits driverWaits;

    //Seletores
    private By pageTitle = By.cssSelector("header[style^='background: var(--type']");

    public MelhoresAtacantesLutadorPage(WebDriver driver) {
        this.driver = driver;
        driverWaits = new DriverWaits(driver);
    }

    public String pegarTituloTexto(){
        return driverWaits.esperarElementoCarregar(pageTitle).getText();
    }
}

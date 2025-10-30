package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverWaits;

import java.util.List;

public class PokemonStatusPage {

    WebDriver driver;
    DriverWaits driverWaits;

    //PageFactory
    @FindBy(css = "ul[class^='MovesetCard_moves'] a")
    List<WebElement> listaGolpes;
    @FindBy(id = "max-cp-chart")
    WebElement tabelaPcMax;


    public PokemonStatusPage(WebDriver driver) {
        this.driver = driver;
        driverWaits = new DriverWaits(driver);
        PageFactory.initElements(driver,this);
    }

    public String pegarPrimeiroGolpe(){
        return listaGolpes.get(0).getText();
    }

    public String  pegarSegundoGolpe() {
        Actions actions = new Actions(driver);

        //Mover mouse para o segundo golpe
//        actions.moveToElement(listaGolpes.get(1)).click().perform();

        //Scroll até o elemento
//        actions.scrollToElement(tabelaPcMax).perform();

        //Utilizando Teclado
//        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        return listaGolpes.get(1).getText();

    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverWaits;

public class TelaPrincipalPage {

    WebDriver driver;
    DriverWaits driverWaits;

    //PageFactory
    @FindBy(linkText = "Melhores Atacantes do tipo Lutador")
    private WebElement menuMelhoresAtacantesLutador;
    @FindBy(linkText = "Melhores Atacantes do tipo Voador")
    private WebElement menuMelhoresAtacantesVoador;
    @FindBy(css = "input[placeholder='Search...']")
    private WebElement campoPesquisaPokemon;

    public TelaPrincipalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driverWaits = new DriverWaits(driver);
    }

    public void clickMelhoresAtacantes(String tipo){
        if(tipo.equals("lutador")){
            driverWaits.esperarElementoClicar(menuMelhoresAtacantesLutador);
            menuMelhoresAtacantesLutador.click();
        }else{
            driverWaits.esperarElementoClicar(menuMelhoresAtacantesVoador);
            menuMelhoresAtacantesVoador.click();
        }
    }

    public void pesquisarPokemon(String pokemonNome){
        campoPesquisaPokemon.sendKeys(pokemonNome);
        driver.findElement(By.partialLinkText(pokemonNome)).click();
    }

}

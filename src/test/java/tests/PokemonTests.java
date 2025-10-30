package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MelhoresAtacantesLutadorPage;
import pages.PokemonStatusPage;
import pages.TelaPrincipalPage;
import utils.DriverFactory;

public class PokemonTests {

    WebDriver driver;

    TelaPrincipalPage telaPrincipalPage;

    @Before
    public void preparar(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getChromeDriver();
        driver.get("https://db.pokemongohub.net/pt");
    }

    @Test
    public void acessarMelhoresAtacantesLutador(){
        telaPrincipalPage = new TelaPrincipalPage(driver);
        telaPrincipalPage.clickMelhoresAtacantesLutador();

        MelhoresAtacantesLutadorPage melhoresAtacantesLutadorPage = new MelhoresAtacantesLutadorPage(driver);
        melhoresAtacantesLutadorPage.pegarTituloTexto();
        Assert.assertEquals("Melhores Atacantes do tipo Lutador em Pokémon GO",melhoresAtacantesLutadorPage.pegarTituloTexto());
    }

    @Test
    public void pesquisarPokemon(){
        telaPrincipalPage = new TelaPrincipalPage(driver);
        telaPrincipalPage.pesquisarPokemon();

        PokemonStatusPage pokemonStatusPage = new PokemonStatusPage(driver);
        Assert.assertEquals("Trovoada de Choques", pokemonStatusPage.pegarPrimeiroGolpe());
    }

    @After
    public void fechar(){
        driver.quit();
    }

}

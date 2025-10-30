package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.MelhoresAtacantesLutadorPage;
import pages.PokemonStatusPage;
import pages.TelaPrincipalPage;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class PokemonSteps {

    WebDriver driver;

    @Dado("que eu acesse a página do Pokemon")
    public void que_eu_acesse_a_página_do_pokemon() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getChromeDriver();
        driver.get("https://db.pokemongohub.net/pt");
    }

    @Quando("eu acessar a tela de melhores atacantes do tipo {string}")
    public void eu_acessar_a_tela_de_melhores_atacantes_do_tipo_lutador(String tipo) {
        TelaPrincipalPage telaPrincipalPage = new TelaPrincipalPage(driver);
        telaPrincipalPage.clickMelhoresAtacantes(tipo);
    }

    @Quando("eu pesquisar {string}")
    public void eu_pesquisar(String pokemonNome) {
        TelaPrincipalPage telaPrincipalPage = new TelaPrincipalPage(driver);
        telaPrincipalPage.pesquisarPokemon(pokemonNome);
    }

    @Então("o título deve ser {string}")
    public void oTítuloDeveSer(String expectedTitle) {
        MelhoresAtacantesLutadorPage melhoresAtacantesLutadorPage = new MelhoresAtacantesLutadorPage(driver);
        Assert.assertEquals(expectedTitle,
                melhoresAtacantesLutadorPage.pegarTituloTexto());
    }

    @Então("o usuário deve ser encaminhado para uma nova url")
    public void oUsuárioDeveSerEncaminhadoParaUmaNovaUrl(Map<String, String> mapLista) throws InterruptedException {
        String url = "https://db.pokemongohub.net/pt/pokemon-list/best-per-type/" + mapLista.get("url");
        Assert.assertEquals(url, driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    @Então("os movimentos do pokemon serão apresentados")
    public void osMovimentosDoPokemonSerãoApresentados(Map<String, String> mapGolpes) {
        PokemonStatusPage pokemonStatusPage = new PokemonStatusPage(driver);
        Assert.assertEquals(mapGolpes.get("Primeiro Golpe"), pokemonStatusPage.pegarPrimeiroGolpe());
        Assert.assertEquals(mapGolpes.get("Segundo Golpe"), pokemonStatusPage.pegarSegundoGolpe());
    }

    @After
    public void fechar(Scenario scenario) throws IOException {
        //Screenshot
        String imageName = scenario.getName().replace(" ", "_") + scenario.getLine() + ".png";
        var camera = (TakesScreenshot) driver;
        byte[] screenshot = camera.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", imageName);
        Path path = Path.of("target/screenshots");
        if (Files.exists(path)) {
            File image = camera.getScreenshotAs(OutputType.FILE);
            Files.move(image.toPath(), Path.of("target/screenshots/" + imageName), REPLACE_EXISTING);
        }

        driver.quit();
    }
}

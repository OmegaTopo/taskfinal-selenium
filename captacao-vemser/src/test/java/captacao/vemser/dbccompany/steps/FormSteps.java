package captacao.vemser.dbccompany.steps;

import captacao.vemser.dbccompany.pages.FormPage;
import captacao.vemser.dbccompany.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class FormSteps extends BaseSteps {
    HomePage homePage = new HomePage();
    FormPage formPage = new FormPage();

    @Test
    public void preencheRGCorretamente() {
        homePage.clicarBtnInscricao();

        formPage.preencherRGValido();
        formPage.clicarEmProximo();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroRG();

        Assert.assertFalse(campoExiste);
    }
}

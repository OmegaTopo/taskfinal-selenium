package captacao.vemser.dbccompany.steps;

import captacao.vemser.dbccompany.pages.InfoPage;
import captacao.vemser.dbccompany.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;


public class InfoSteps extends BaseSteps {
    HomePage homePage = new HomePage();
    InfoPage infoPage = new InfoPage();

    @Test
    public void preencheRGCorretamente() {
        homePage.clicarBtnInscricao();

        infoPage.preencherRGValido();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroRG();

        Assert.assertFalse(campoExiste);
    }
}

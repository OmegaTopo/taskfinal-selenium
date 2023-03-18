package captacao.vemser.dbccompany.steps;

import captacao.vemser.dbccompany.pages.HomePage;
import org.junit.Test;

public class HomeSteps extends BaseSteps {
    HomePage homePage = new HomePage();

    @Test
    public void clicarEmInscricao(){
        homePage.clicarBtnInscricao();
    }
}

package captacao.vemser.dbccompany.steps;

import captacao.vemser.dbccompany.pages.BasePage;
import captacao.vemser.dbccompany.pages.FormPage;
import captacao.vemser.dbccompany.pages.HomePage;
import captacao.vemser.dbccompany.pages.InfoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class FormSteps extends BaseSteps{

    HomePage homePage = new HomePage();
    InfoPage infoPage = new InfoPage();
    FormPage formPage = new FormPage();

    @Before
    public void acessarFormulario(){
        homePage.clicarBtnInscricao();
        infoPage.preencherNomeValido();
        infoPage.preencherEmailValido();
        infoPage.preencherRGValido();
        infoPage.preencherCPFValido();
        infoPage.preencherCampoCelularValido();
        infoPage.preencherCampoDataDeNascimentoValido();
        infoPage.preencherCampoCidadeValido();
        infoPage.selecionarEstadoPA();
        infoPage.clicarEmProximo();
    }

    @Test
    public void marcarTurnoNoite(){
        formPage.marcarTurnoNoite();
    }
    @Test
    public void marcarTurnoATarde(){
        formPage.marcarTurnoTarde();
    }

    @Test
    public void preencherInstituicaoCorretamente(){
        formPage.preencherCampoInstituicao();
        formPage.clicarEnviar();

        Boolean campoExiste = formPage.verificaExistenciaErroInstituicao();
        Assert.assertFalse(campoExiste);
    }

    @Test
    public void preencherInstituicaoIncorretamente(){
        formPage.preencherCampoInstituicaoIncorretamente();
        formPage.clicarEnviar();

        Boolean campoExiste = formPage.verificaExistenciaErroInstituicao();
        Assert.assertTrue(campoExiste);
}

    @Test
    public void campoInstituicaoEmBranco(){
        formPage.clicarEnviar();

        String validador = formPage.verificaTextoCampoErroInstituicao();
        Assert.assertEquals("A Instituição de ensino deve ter apenas letras e espaços", validador);
    }

    @Test
    public void selecionarUmaOpcaoEspanhol(){
        String corLabelEspanholAntes = formPage.corCaixaEspanhol();
        formPage.clicarEspanhol();
        formPage.clicarEspanholNenhum();

        String corLabelEspanholDepois = formPage.corCaixaEspanhol();
        Assert.assertNotEquals(corLabelEspanholAntes, corLabelEspanholDepois);
    }



}

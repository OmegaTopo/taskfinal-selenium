package captacao.vemser.dbccompany.steps;

import captacao.vemser.dbccompany.pages.FormPage;
import captacao.vemser.dbccompany.pages.HomePage;
import captacao.vemser.dbccompany.pages.InfoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void preencherMatriculadoComRespostaPositiva() {

        formPage.marcarCampoMatriculadoSim();
        formPage.clicarEmEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroMatriculado();

        Assert.assertFalse(campoExiste);
    }
    @Test
    public void preencherMatriculadoComRespostaNegativa() {
        String msgErroMatriculado = "Devido as restrições impostas pelas leis brasileiras, somente alunos que possuem vínculo" +
                " com uma instituição de ensino podem se candidatar às vagas de estágio.";

        formPage.marcarCampoMatriculadoNao();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroMatriculado();
        Boolean btnExiste = formPage.verificaExistenciaBotaoEnviar();
        String textoExtraido = formPage.extraiTextoCampoErroMatriculado();

        Assert.assertTrue(campoExiste);
        Assert.assertEquals(msgErroMatriculado, textoExtraido);
        Assert.assertFalse(btnExiste);
    }
    @Test
    public void opcaoSimDoCampoMatriculadoEMarcadaPorPadrao() {

        Boolean campoSelecionado = formPage.verificaOpcaoSimCampoMatriculadoEstaMarcada();

        Assert.assertTrue(campoSelecionado);
    }
}

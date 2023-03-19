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
        infoPage.preencherCampoNeurodiversidadeNao();
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
    public void marcarFluenteEmIngles(){
        formPage.marcarInglesFluente();

        String validador = formPage.validarCampoIngles();
        Assert.assertEquals("Fluente",validador);
    }
    @Test
    public void marcarGeneroHomemCis(){
        formPage.selecionarGeneroHomemCis();
        String validador = formPage.validarCampoGenero();
        Assert.assertEquals("Homem cisgênero",validador);
    }
    @Test
    public void marcarGeneroNaoBinario(){
        formPage.selecionarGeneroNaoBinario();
        String validador = formPage.validarCampoGenero();
        Assert.assertEquals("Não binário",validador);
    }
    @Test
    public void selecionarDeficienciaSurdez(){
        formPage.selecionarDeficiencia();
        formPage.selecionarDeficienciaSim();
        formPage.definirDeficienciaSurdez();

        String validador = formPage.validarCampoDeficiencia();
        Assert.assertEquals("Surdez",validador);
    }
    @Test
    public void selecionarDeficienciaNao(){
        formPage.selecionarDeficiencia();
        formPage.selecionarDeficienciaNao();
    }
    @Test
    public void selecionarProvaTecnicaSim(){
        formPage.selecionarSimProvaTecnica();
    }
    @Test
    public void selecionarProvaTecnicaNao(){
        formPage.selecionarNaoProvaTecnica();
    }

    @Test
    public void enviarGitHub(){
        formPage.digitarLinkGitHub();
    }
    @Test
    public void enviarGitHubEmBranco(){
        formPage.digitarLinkGitHubEmBranco();
        formPage.enviarFormulario();
    }
    @Test
    public void enviarPrintConfiguracao(){
        formPage.enviarPrintConfiguracoes();
        formPage.enviarFormulario();
    }

    @Test
    public void avancar(){
        formPage.marcarTurnoNoite();
        formPage.marcarInglesFluente();
        formPage.selecionarGeneroNaoBinario();
        formPage.selecionarDeficiencia();
        formPage.selecionarDeficienciaNao();
        formPage.selecionarSimProvaTecnica();
        formPage.digitarLinkGitHub();
//        formPage.enviarPrintConfiguracoes();
        formPage.enviarFormulario();
    }







}

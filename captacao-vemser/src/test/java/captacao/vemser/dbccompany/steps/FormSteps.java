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

    @Test
    public void selecionarUmaLinguagemProgramacao(){
        formPage.clicarBtnLinguagemInteresse();
        formPage.clicarEmJava();
        formPage.clicarBtnLinguagemInteresseSair();
        formPage.clicarEnviar();

        String validador = formPage.verificaTextoErroLinguagem();
        Assert.assertEquals("", validador);
    }

    @Test
    public void deixarLinguagememBranco(){
        formPage.clicarEnviar();

        String validador = formPage.verificaTextoErroLinguagem();
        Assert.assertEquals("Pelo menos uma linguagem deve ser selecionada", validador);
    }

    @Test
    public void preencherMotivoInteresse(){
        formPage.preencheCampoMotivo();
        formPage.clicarEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroMotivo();
        Assert.assertFalse(campoExiste);
    }

    @Test
    public void preencherMotivoInteresseInsuficiente(){
        formPage.preencheCampoMotivoInsuficiente();
        formPage.clicarEnviar();

        String validador = formPage.extraiTextoCampoErroMotivo();
        Assert.assertEquals("São necessários 10 caracteres, no mínimo", validador);
    }

    @Test
    public void preencherMotivoInteresseInvalido(){
        formPage.preencheCampoMotivoInvalido();
        formPage.clicarEnviar();

        String validador = formPage.extraiTextoCampoErroMotivo();
        Assert.assertEquals("A resposta deve ter apenas letras e espaços", validador);
    }

    @Test
    public void deixarMotivoInteresseEmBranco(){
        formPage.clicarEnviar();

        String validador = formPage.extraiTextoCampoErroMotivo();
        Assert.assertEquals("Campo obrigatório", validador);
    }

    @Test
    public void preencherLinkedIn(){
        String classeErroLinkAntes = formPage.extrairClasseAvisoLinkedIn();
        formPage.preencheCampoLinkedIn();
        formPage.clicarEnviar();

        String classeErroLinkDepois = formPage.extrairClasseAvisoLinkedIn();
        Assert.assertNotEquals(classeErroLinkAntes, classeErroLinkDepois);
    }

    @Test
    public void preencherLinkedInInvalido(){
        formPage.preencheCampoLinkedInInvalido();
        formPage.clicarEnviar();

        Boolean campoExiste = formPage.verificaPaginaAtual();
        Assert.assertTrue(campoExiste);
    }

    @Test
    public void preencherLinkedInOutroLink(){
        String classeErroLinkAntes = formPage.extrairClasseAvisoLinkedIn();
        formPage.preencheCampoLinkedInOutroSite();
        formPage.clicarEnviar();

        String classeErroLinkDepois = formPage.extrairClasseAvisoLinkedIn();
        Assert.assertNotEquals(classeErroLinkAntes, classeErroLinkDepois);
    }

    @Test
    public void concordarTratamento(){
        formPage.clicarConcordarTratamento();
        formPage.clicarEnviar();

        String validador = formPage.verificaTextoErroConcordar();
        Assert.assertEquals("", validador);
    }

    @Test
    public void naoConcordarTratamento(){
        formPage.clicarEnviar();

        String validador = formPage.verificaTextoErroConcordar();
        Assert.assertEquals("É necessário aceitar os termos para prosseguir", validador);
    }

    @Test
    public void clicarBotaoVoltar(){
        formPage.clicarBtnVoltar();

        Boolean paginaForm = formPage.verificaPaginaAtual();
        Assert.assertFalse(paginaForm);
    }
}

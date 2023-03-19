package captacao.vemser.dbccompany.steps;

import captacao.vemser.dbccompany.pages.InfoPage;
import captacao.vemser.dbccompany.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InfoSteps extends BaseSteps {
    HomePage homePage = new HomePage();
    InfoPage infoPage = new InfoPage();

    @Before
    public void acessarInfo(){
        homePage.clicarBtnInscricao();
    }
    @Test
    public void preencheRGCorretamente(){

        infoPage.preencherRGValido();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroRG();

        Assert.assertFalse(campoExiste);
    }
    @Test
    public void preeencherNomeCorretamente(){
        infoPage.preencherNomeValido();
    }
    @Test
    public void preencherNomeCurto(){
        infoPage.preencherNomeCurto();
        infoPage.clicarEmProximo();
        String validador = infoPage.verificaCampoErroNome();
        Assert.assertEquals("O nome deve ter no mínimo 3 letras", validador);
    }
    @Test
    public void preencherNomeEmBranco(){
        infoPage.preencherNomeEmBranco();
        infoPage.clicarEmProximo();
        String validador = infoPage.verificaCampoErroNome();
        Assert.assertEquals("O nome é obrigatório", validador);
    }
    @Test
    public void preencherNomeSemSobrenome(){
        infoPage.preencherNomeSemSobrenome();
        infoPage.clicarEmProximo();
        String validador = infoPage.verificaCampoErroNome();
        Assert.assertEquals("O nome deve ter no mínimo sobrenome", validador);
    }
    @Test
    public void preencherNomeComNumeros(){
        infoPage.preencherNomeComNumero();
        infoPage.clicarEmProximo();
        String validador = infoPage.verificaCampoErroNome();
        Assert.assertEquals("O nome deve ter apenas letras e espaços" , validador);
    }
    @Test
    public void preencherCPFValido(){
        infoPage.preencherCPFValido();
        infoPage.clicarEmProximo();
    }
    @Test
    public void preencherCPFInvalido(){
        infoPage.preencherCPFInvalido();
        infoPage.clicarEmProximo();
        String validador = infoPage.verificaCampoErroCPF();
        Assert.assertEquals("O CPF deve ser válido", validador);
    }
    @Test
    public void preencherCPFCurto(){
        infoPage.preencherCPFCurto();
        infoPage.clicarEmProximo();
        String validador = infoPage.verificaCampoErroCPF();
        Assert.assertEquals("O CPF deve ser um número válido", validador);
    }
    @Test
    public void selecionarEstadoPara(){
        infoPage.selecionarEstadoPA();

        String validador = infoPage.verificarCampoEstado();
        Assert.assertEquals("Pará",validador);
    }
    @Test
    public void selecionarEstadoRS(){
        infoPage.selecionarEstadoRS();

        String validador = infoPage.verificarCampoEstado();
        Assert.assertEquals("Rio Grande do Sul",validador);
    }
    @Test
    public void avancarParaFormularioComSucesso(){
        infoPage.preencherNomeValido();
        infoPage.preencherEmailValido();
        infoPage.preencherRGValido();
        infoPage.preencherCPFValido();
        infoPage.preencherCampoCelularValido();
        infoPage.preencherCampoDataDeNascimentoValido();
        infoPage.preencherCampoCidadeValido();
        infoPage.selecionarEstadoPA();
        infoPage.preencherCampoNeurodiversidade();
        infoPage.clicarEmProximo();
    }




}

package captacao.vemser.dbccompany.steps;

import captacao.vemser.dbccompany.pages.BasePage;
import captacao.vemser.dbccompany.pages.FormPage;
import captacao.vemser.dbccompany.pages.InfoPage;
import captacao.vemser.dbccompany.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.LocalDateTime;


public class InfoSteps extends BaseSteps {
    HomePage homePage = new HomePage();
    InfoPage infoPage = new InfoPage();
    FormPage formPage = new FormPage();

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
    public void tentaAvancarSemPreencherRG() {
        String textoErroRG = "O RG é obrigatório";

        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroRG();

        String textoExtraido = "";

        if (campoExiste) {
            textoExtraido = infoPage.extraiTextoCampoErroRG();
        }

        Assert.assertTrue(campoExiste);
        Assert.assertEquals(textoErroRG, textoExtraido);
    }
    @Test
    public void tentaAvancarPreenchendoRGInvalido() {

        infoPage.preencherRGInvalido();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroRG();

        Assert.assertTrue(campoExiste);
    }
    @Test
    public void tentaPreencherRGComCaracteresNãoLetrasOuNumeros() {

        infoPage.preencherRGComCaracteresInvalidos();

        String textoExtraido = infoPage.extraiTextoCampoRG();
        String stringVazia = "";

        Assert.assertEquals(stringVazia, textoExtraido);
    }
    @Test
    public void preencherDataDeNascimentoCorretamente() {

        infoPage.preencherCampoDataDeNascimentoValido();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroDataDeNascimento();

        Assert.assertFalse(campoExiste);
    }
    @Test
    public void preencherDataDeNascimentoComDataInvalida() {
        String textoErroDataDeNascimento1 = "A data de nascimento deve ser uma data válida";
        String textoErroDataDeNascimento2 = "A data de nascimento deve ser anterior a data atual";

        infoPage.preencherCampoDataDeNascimentoComDataInvalida();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroDataDeNascimento();
        String textoExtraido = infoPage.extraiTextoCampoErroDataDeNascimento();

        Boolean contemTextoErroDataDeNascimento =
                (textoExtraido.contains(textoErroDataDeNascimento1)) || (textoExtraido.contains(textoErroDataDeNascimento2))
                        ? true
                        : false;

        Assert.assertTrue(campoExiste);
        Assert.assertTrue(contemTextoErroDataDeNascimento);
    }
    @Test
    public void preencherDataDeNascimentoComDataFutura() {
        String textoErroDataDeNascimento = "A data de nascimento deve ser anterior a data atual";

        infoPage.preencherCampoDataDeNascimentoComDataFutura();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroDataDeNascimento();
        String textoExtraido = infoPage.extraiTextoCampoErroDataDeNascimento();

        Assert.assertTrue(campoExiste);
        Assert.assertEquals(textoErroDataDeNascimento, textoExtraido);
    }
    @Test
    public void preencherDataDeNascimentoComIdadeAbaixoDeDezesseisAnos() {
        String textoErroDataDeNascimento = "A data de nascimento deve ter no mínimo 16 anos";

        infoPage.preencherCampoDataDeNascimentoComIdadeAbaixoDezesseisAnos();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroDataDeNascimento();
        String textoExtraido = infoPage.extraiTextoCampoErroDataDeNascimento();

        Assert.assertTrue(campoExiste);
        Assert.assertEquals(textoErroDataDeNascimento, textoExtraido);
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

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroCPF();
        Assert.assertFalse(campoExiste);
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
    public void preencherEmailCorretamente(){
        infoPage.preencherEmailValido();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroEmail();
        Assert.assertFalse(campoExiste);
    }

    @Test
    public void preencherEmailIncorretamente(){
        infoPage.preencherEmailInvalido();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroEmail();
        Assert.assertTrue(campoExiste);
    }

    @Test
    public void deixarEmailEmBranco(){
        infoPage.clicarEmProximo();

        String validador = BasePage.extraiTexto(By.cssSelector("[id=step-1-email-helper-text]"));
        Assert.assertEquals("O email é obrigatório", validador);
    }

    @Test
    public void preencheCelularCorretamente(){
        infoPage.preencherCampoCelularValido();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroCelular();
        Assert.assertFalse(campoExiste);
    }

    @Test
    public void preenceCelularIncorretamente(){
        infoPage.preencheCampoTelefoneInvalido();
        infoPage.clicarEmProximo();

        String validador = BasePage.extraiTexto(By.cssSelector("[id=step-1-telefone-helper-text]"));
        Assert.assertEquals("O telefone deve ser um número válido no formato (99)99999-9999", validador);
    }

    @Test
    public void deixarTelefoneEmBranco(){
        infoPage.clicarEmProximo();

        String validador = BasePage.extraiTexto(By.cssSelector("[id=step-1-telefone-helper-text]"));
        Assert.assertEquals("O celular é obrigatório", validador);
    }

    @Test
    public void preencheCampoCidadeCorretamente(){
        infoPage.preencherCampoCidadeValido();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoErroCidade();
        Assert.assertFalse(campoExiste);
    }

    @Test
    public void preencheCampoCidadeIncorretamente(){
        infoPage.preencherCampoCidadeInvalido();
        infoPage.clicarEmProximo();

        String validador = BasePage.extraiTexto(By.cssSelector("[id=step-1-cidade-helper-text]"));
        Assert.assertEquals("A Cidade deve ter apenas letras e espaços", validador);
    }

    @Test
    public void deixaCampoCidadeEmBranco(){
        infoPage.clicarEmProximo();

        String validador = BasePage.extraiTexto(By.cssSelector("[id=step-1-cidade-helper-text]"));
        Assert.assertEquals("A cidade é obrigatória", validador);
    }

    @Test
    public void neurodiversidadeNao(){
        infoPage.preencherCampoNeurodiversidadeNao();
        infoPage.clicarEmProximo();

        Boolean campoExiste = infoPage.verificaExistenciaCampoNeuro();
        Assert.assertFalse(campoExiste);
    }

    @Test
    public void neurodiversidadeSim(){
        infoPage.preencherCampoNeurodiversidadeSim();
        infoPage.preencherCampoNeurodiversidadeValido();
        infoPage.clicarEmProximo();

        Boolean proximoSite = infoPage.verificaExistenciaProximaPagina();
        Assert.assertFalse(proximoSite);
    }

    @Test
    public void neurodiversidadeSimInvalido(){
        infoPage.preencherCampoNeurodiversidadeSim();
        infoPage.preencherCampoNeurodiversidadeInvalido();
        infoPage.clicarEmProximo();

        Boolean proximoSite = infoPage.verificaExistenciaProximaPagina();
        Assert.assertFalse(proximoSite);
    }

    @Test
    public void verificaSeCampoInformacoesEstaEmDestaque() {
        String classeElementoAtivo = "Mui-active";

        String classesCampoInformacoes = infoPage.listaDeClassesDeElementosDaBarraDeStatus().get(0);

        Assert.assertTrue(classesCampoInformacoes.contains(classeElementoAtivo));
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
        infoPage.preencherCampoNeurodiversidadeNao();
        infoPage.clicarEmProximo();

        Boolean campoExiste = formPage.verificaPaginaAtual();
        Assert.assertTrue(campoExiste);
    }
}

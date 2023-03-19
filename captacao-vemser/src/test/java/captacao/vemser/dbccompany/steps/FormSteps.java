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
    @Test
    public void preencherCursoComStringValida() {

        formPage.preencheCampoCursoComStringValida();
        formPage.clicarEmEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroCurso();

        Assert.assertFalse(campoExiste);
    }
    @Test
    public void enviarFormularioComCursoVazio() {
        String msgErroCampoCurso = "O Curso deve ter apenas letras e espaços";

        formPage.clicarNoCampoCurso();
        formPage.clicarEmEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroCurso();
        String textoExtraido = formPage.extraiTextoCampoErroCurso();

        Assert.assertTrue(campoExiste);
        Assert.assertEquals(msgErroCampoCurso, textoExtraido);
    }
    @Test
    public void preencherCursoComCaracteresInvalidos() {
        String msgErroCampoCurso = "O Curso deve ter apenas letras e espaços";

        formPage.clicarNoCampoCurso();
        formPage.preencherCampoCursoComCaracteresInvalidos();
        formPage.clicarEmEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroCurso();
        String textoExtraido = formPage.extraiTextoCampoErroCurso();

        Assert.assertTrue(campoExiste);
        Assert.assertEquals(msgErroCampoCurso, textoExtraido);
    }
    @Test
    public void preencherCursoComStringDeMaisDe255Caracteres() {

        formPage.clicarNoCampoCurso();
        formPage.preencherCampoCursoComStringDeMaisDe255Caracteres();
        formPage.clicarEmEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroCurso();

        Assert.assertTrue(campoExiste);
    }
    @Test
    public void marcarCampoOrientacaoSexualComOpcaoPansexual() {
        String textoPansexual = "Pansexual";

        formPage.clicarNoCampoOrientacaoSexual();
        formPage.clicarNaOpcaoOrientacaoPansexual();

        String textoExtraido = formPage.extraiTextoCampoOrientacaoSexual();

        Assert.assertTrue(textoExtraido.contains(textoPansexual));
    }
    @Test
    public void marcarCampoOrientacaoSexualComOpcaoOutro() {
        String textoOutro = "Outro";

        formPage.clicarNoCampoOrientacaoSexual();
        formPage.clicarNaOpcaoOrientacaoOutro();

        String textoExtraido = formPage.extraiTextoCampoOrientacaoSexual();

        Assert.assertTrue(textoExtraido.contains(textoOutro));
    }
    @Test
    public void marcarAOpcaoTrilhaBackendComSucesso() {

        formPage.clicaOpcaoTrilhaBackend();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroTrilha();
        Boolean campoMarcado = formPage.verificaSeOpcaoTrilhaBackendEstaMarcada();

        Assert.assertFalse(campoExiste);
        Assert.assertTrue(campoMarcado);
    }
    @Test
    public void marcarAOpcaoTrilhaQaComSucesso() {

        formPage.clicaOpcaoTrilhaQa();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroTrilha();
        Boolean campoMarcado = formPage.verificaSeOpcaoTrilhaQaEstaMarcada();

        Assert.assertFalse(campoExiste);
        Assert.assertTrue(campoMarcado);
    }
    @Test
    public void marcarAOpcaoTrilhaFrontendComSucesso() {

        formPage.clicaOpcaoTrilhaFrontend();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroTrilha();
        Boolean campoMarcado = formPage.verificaSeOpcaoTrilhaFrontendEstaMarcada();

        Assert.assertFalse(campoExiste);
        Assert.assertTrue(campoMarcado);
    }
    @Test
    public void marcarTodasAsTrilhasComSucesso() {

        formPage.clicaOpcaoTrilhaBackend();
        formPage.clicaOpcaoTrilhaQa();
        formPage.clicaOpcaoTrilhaFrontend();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroTrilha();
        Boolean campoMarcadoBackend = formPage.verificaSeOpcaoTrilhaFrontendEstaMarcada();
        Boolean campoMarcadoQa = formPage.verificaSeOpcaoTrilhaQaEstaMarcada();
        Boolean campoMarcadoFrontend = formPage.verificaSeOpcaoTrilhaFrontendEstaMarcada();

        Assert.assertFalse(campoExiste);
        Assert.assertTrue(campoMarcadoBackend);
        Assert.assertTrue(campoMarcadoQa);
        Assert.assertTrue(campoMarcadoFrontend);
    }
    @Test
    public void tentaAvancarSemMarcarNenhumaTrilha() {
        String msgErroCampoTrilha = "A escolha de uma trilha é obrigatória";

        formPage.clicarEmEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroTrilha();
        String textoExtraido = formPage.extraiTextoCampoErroTrilha();

        Assert.assertTrue(campoExiste);
        Assert.assertEquals(msgErroCampoTrilha, textoExtraido);
    }
    @Test
    public void preencheCampoImportanteParaAVidaComSucesso() {

        formPage.clicarNoCampoImportanteParaAVida();
        formPage.preencherCampoImportanteParaAVida();
        formPage.clicarEmEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroImportanteParaAVida();

        Assert.assertFalse(campoExiste);
    }
    @Test
    public void tentaAvancarSemPreencherCampoImportanteParaAVida() {
        String msgErroImportanteParaAVida = "Campo obrigatório";

        formPage.clicarNoCampoImportanteParaAVida();
        formPage.clicarEmEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroImportanteParaAVida();
        String textoExtraido = formPage.extraiTextoCampoErroImportanteParaAVida();

        Assert.assertTrue(campoExiste);
        Assert.assertEquals(msgErroImportanteParaAVida, textoExtraido);
    }
    @Test
    public void tentaAvancarPreenchendoCampoImportanteParaAVidaComMenosDeDezCaracteres() {
        String msgErroImportanteParaAVida = "São necessários 10 caracteres, no mínimo";

        formPage.clicarNoCampoImportanteParaAVida();
        formPage.preencherCampoImportanteParaAVidaComTextoPequeno();
        formPage.clicarEmEnviar();

        Boolean campoExiste = formPage.verificaExistenciaCampoErroImportanteParaAVida();
        String textoExtraido = formPage.extraiTextoCampoErroImportanteParaAVida();

        Assert.assertTrue(campoExiste);
        Assert.assertEquals(msgErroImportanteParaAVida, textoExtraido);
    }
}

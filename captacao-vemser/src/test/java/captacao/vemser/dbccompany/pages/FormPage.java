package captacao.vemser.dbccompany.pages;

import net.datafaker.Faker;
import org.openqa.selenium.By;

import java.util.Locale;

public class FormPage extends BasePage{
    private Faker faker = new Faker(new Locale("pt-BR"));

    private static final By campoTurnoNoite = By.cssSelector("#turno-noite > span.MuiButtonBase-root.MuiRadio-root.MuiRadio-colorPrimary.PrivateSwitchBase-root.MuiRadio-root.MuiRadio-colorPrimary.MuiRadio-root.MuiRadio-colorPrimary.css-kf7w3t > input");
    private static final By campoTurnoTarde = By.cssSelector("#turno-tarde > span.MuiButtonBase-root.MuiRadio-root.MuiRadio-colorPrimary.PrivateSwitchBase-root.MuiRadio-root.MuiRadio-colorPrimary.MuiRadio-root.MuiRadio-colorPrimary.css-kf7w3t > input");
    private static final By campoInglesFluente = By.cssSelector("li:nth-child(5)");
    private static final By campoNivelIngles = By.cssSelector("[id=s2-nivel-ingles-candidato]");
    private static final By campoGenero = By.cssSelector("[id=s2-select-genero-candidato]");
    private static final By campoGeneroHomemCis = By.cssSelector("li.MuiButtonBase-root.MuiMenuItem-root.MuiMenuItem-gutters.Mui-selected.MuiMenuItem-root.MuiMenuItem-gutters.Mui-selected.css-12kak8r");
    private static final By campoGeneroNaoBinario = By.cssSelector("li:nth-child(5)");
    private static final By selecaoDeficiencia = By.cssSelector("[id=s2-select-deficiencia-candidato]");
    private static final By selecaoDeficienciaSim = By.cssSelector("li:nth-child(2)");
    private static final By selecaoDeficienciaNao = By.cssSelector("li.MuiButtonBase-root.MuiMenuItem-root.MuiMenuItem-gutters.Mui-selected.MuiMenuItem-root.MuiMenuItem-gutters.Mui-selected.css-12kak8r");
    private static final By campoDeficiencia = By.cssSelector("[id=s2-candidato-deficiencia-descricao]");
    private static final By selecionarProvaTecnicaSim = By.cssSelector("#s2-candidato-prova-sim > span.MuiButtonBase-root.MuiRadio-root.MuiRadio-colorPrimary.PrivateSwitchBase-root.MuiRadio-root.MuiRadio-colorPrimary.MuiRadio-root.MuiRadio-colorPrimary.css-kf7w3t > input");
    private static final By selecionarProvaTecnicaNao = By.cssSelector("#s2-candidato-prova-nao > span.MuiButtonBase-root.MuiRadio-root.MuiRadio-colorPrimary.PrivateSwitchBase-root.MuiRadio-root.MuiRadio-colorPrimary.Mui-checked.MuiRadio-root.MuiRadio-colorPrimary.css-kf7w3t > input");
    private static final By campoGitHub = By.cssSelector("[id=s2-candidato-github]");
    private static final By btnPrintConfiguracao = By.cssSelector("[id=botao-configuracoes]");
    private static final By btnEnviar = By.cssSelector("[id=s2-botao-submit]");
    private static final By campoMatriculadoSim = By.cssSelector("#matriculado-sim span:nth-child(1)");
    private static final By campoMatriculadoNao = By.cssSelector("#matriculado-nao span:nth-child(1)");
    private static final By btnEnviar = By.cssSelector("[id=\"s2-botao-submit\"]");
    private static final By campoErroMatriculado = By.cssSelector("[id=\"erro-não-matriculado\"]");
    private static final By campoMatriculadoSimVerificacaoMarcado = By.cssSelector("input[name=\"matriculado\"][value=\"T\"]");
    private static final By campoCurso = By.cssSelector("[id=curso-candidato]");
    private static final By campoErroCurso = By.cssSelector("[id=\"curso-candidato-helper-text\"]");
    private static final By campoOrientacaoSexual = By.cssSelector("[id=\"orientacao-sexual-candidato\"]");
    private static final By opcaoOrientacaoPansexual = By.cssSelector("li[data-value=\"pansexual\"]");
    private static final By opcaoOrientacaoOutro = By.cssSelector("li[data-value=\"outro\"]");
    private static final By campoErroTrilha = By.cssSelector("div:nth-child(10) > p");
    private static final By opcaoTrilhaBackend = By.cssSelector("input[value=\"BACKEND\"]");
    private static final By opcaoTrilhaQa = By.cssSelector("input[value=\"QA\"]");
    private static final By opcaoTrilhaFrontend = By.cssSelector("input[value=\"FRONTEND\"]");
    private static final By campoImportanteParaAVida = By.cssSelector("[id=textarea-importante-candidato]");
    private static final By campoErroImportanteParaAVida = By.cssSelector("[id=\"textarea-importante-candidato-helper-text\"]");

    public void marcarTurnoNoite(){
        clicar(campoTurnoNoite);
    }
    public void marcarTurnoTarde(){
        clicar(campoTurnoTarde);
    }
    public void marcarInglesFluente(){
        clicar(campoNivelIngles);
        clicar(campoInglesFluente);
    }
    public String validarCampoIngles(){
        String texto = extraiTexto(campoNivelIngles);
        return texto;
    }
    public void selecionarGeneroHomemCis(){
        clicar(campoGenero);
        clicar(campoGeneroHomemCis);
    }
    public void selecionarGeneroNaoBinario(){
        clicar(campoGenero);
        clicar(campoGeneroNaoBinario);
    }
    public String validarCampoGenero(){
        String texto = extraiTexto(campoGenero);
        return texto;
    }
    public void selecionarDeficiencia(){
        clicar(selecaoDeficiencia);
    }
    public void selecionarDeficienciaSim(){
        clicar(selecaoDeficienciaSim);
    }
    public void selecionarDeficienciaNao(){
        clicar(selecaoDeficienciaNao);
    }
    public void definirDeficienciaSurdez(){
        preencheCampo(campoDeficiencia, "Surdez");
    }
    public String validarCampoDeficiencia(){
        String texto = extraiTexto(campoDeficiencia);
        return texto;
    }
    public void selecionarSimProvaTecnica(){
        clicar(selecionarProvaTecnicaSim);
    }
    public void selecionarNaoProvaTecnica(){
        clicar(selecionarProvaTecnicaNao);
    }
    public void digitarLinkGitHub(){
        preencheCampo(campoGitHub, "https://github.com/");
    }
    public void digitarLinkGitHubEmBranco(){
        preencheCampo(campoGitHub, " ");
    }
    public void enviarPrintConfiguracoes(){
        clicar(btnPrintConfiguracao);
    }
    public void enviarFormulario(){
        clicar(btnEnviar);
    }
    public void marcarCampoMatriculadoSim() {
        clicar(campoMatriculadoSim);
    }
    public void marcarCampoMatriculadoNao() {
        clicar(campoMatriculadoNao);
    }
    public void clicarEmEnviar() {
        clicar(btnEnviar);
    }
    public Boolean verificaExistenciaCampoErroMatriculado() {
        return verificaExistenciaElemento(campoErroMatriculado);
    }
    public String extraiTextoCampoErroMatriculado() {
        return extraiTexto(campoErroMatriculado);
    }
    public Boolean verificaOpcaoSimCampoMatriculadoEstaMarcada() {
        return verificaSeElementoEstaSelecionado(campoMatriculadoSimVerificacaoMarcado);
    }
    public Boolean verificaExistenciaBotaoEnviar() {
        return verificaExistenciaElemento(btnEnviar);
    }
    public void preencheCampoCursoComStringValida() {
        String cursoValido = "Ciência da computação";

        preencheCampo(campoCurso, cursoValido);
    }
    public Boolean verificaExistenciaCampoErroCurso() {
        return verificaExistenciaElemento(campoErroCurso);
    }
    public String extraiTextoCampoErroCurso() {
        return extraiTexto(campoErroCurso);
    }
    public void clicarNoCampoCurso() {
        clicar(campoCurso);
    }
    public void preencherCampoCursoComCaracteresInvalidos() {
        String caracteresInvalidos = "-*/-5-*5-654-..";

        preencheCampo(campoCurso, caracteresInvalidos);
    }
    public void preencherCampoCursoComStringDeMaisDe255Caracteres() {
        String stringComMaisDe255Caracteres = "ESTA SRTRING POSSUI MAIS DE DUZENTOS E CINQUENTA E CINCO CARACTERES" +
                " xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        preencheCampo(campoCurso, stringComMaisDe255Caracteres);
    }
    public void clicarNoCampoOrientacaoSexual() {

        clicar(campoOrientacaoSexual);
    }
    public void clicarNaOpcaoOrientacaoPansexual() {

        clicar(opcaoOrientacaoPansexual);
    }
    public void clicarNaOpcaoOrientacaoOutro() {

        clicar(opcaoOrientacaoOutro);
    }
    public String extraiTextoCampoOrientacaoSexual() {
        return extraiTexto(campoOrientacaoSexual);
    }
    public void clicaOpcaoTrilhaBackend() {

        clicar(opcaoTrilhaBackend);
    }
    public Boolean verificaSeOpcaoTrilhaBackendEstaMarcada() {
        return verificaSeElementoEstaSelecionado(opcaoTrilhaBackend);
    }
    public Boolean verificaExistenciaCampoErroTrilha() {
        return verificaExistenciaElemento(campoErroTrilha);
    }
    public String extraiTextoCampoErroTrilha() {
        return extraiTexto(campoErroTrilha);
    }

    public void clicaOpcaoTrilhaQa() {

        clicar(opcaoTrilhaQa);
    }

    public Boolean verificaSeOpcaoTrilhaQaEstaMarcada() {
        return verificaSeElementoEstaSelecionado(opcaoTrilhaQa);
    }

    public void clicaOpcaoTrilhaFrontend() {

        clicar(opcaoTrilhaFrontend);
    }

    public Boolean verificaSeOpcaoTrilhaFrontendEstaMarcada() {
        return verificaSeElementoEstaSelecionado(opcaoTrilhaFrontend);
    }

    public void clicarNoCampoImportanteParaAVida() {

        clicar(campoImportanteParaAVida);
    }

    public void preencherCampoImportanteParaAVida() {

        preencheCampo(campoImportanteParaAVida, faker.lorem().paragraph());
        preencheCampo(campoImportanteParaAVida, faker.lorem().characters(100));
    }

    public Boolean verificaExistenciaCampoErroImportanteParaAVida() {
        return verificaExistenciaElemento(campoErroImportanteParaAVida);
    }

    public String extraiTextoCampoErroImportanteParaAVida() {
        return extraiTexto(campoErroImportanteParaAVida);
    }

    public void preencherCampoImportanteParaAVidaComTextoPequeno() {
        String textoComQuatroCaracteres = "Nada";

        preencheCampo(campoImportanteParaAVida, textoComQuatroCaracteres);
    }
}

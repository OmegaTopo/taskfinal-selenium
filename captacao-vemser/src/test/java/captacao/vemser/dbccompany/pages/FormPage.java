package captacao.vemser.dbccompany.pages;

import net.datafaker.Faker;
import org.openqa.selenium.By;

import java.util.Locale;

public class FormPage extends BasePage{
    private Faker faker = new Faker(new Locale("pt-BR"));


    private static final By campoTurnoNoite = By.cssSelector("#turno-noite > span.MuiButtonBase-root.MuiRadio-root.MuiRadio-colorPrimary.PrivateSwitchBase-root.MuiRadio-root.MuiRadio-colorPrimary.MuiRadio-root.MuiRadio-colorPrimary.css-kf7w3t > input");
    private static final By campoTurnoTarde = By.cssSelector("#turno-tarde > span.MuiButtonBase-root.MuiRadio-root.MuiRadio-colorPrimary.PrivateSwitchBase-root.MuiRadio-root.MuiRadio-colorPrimary.MuiRadio-root.MuiRadio-colorPrimary.css-kf7w3t > input");
    private static final By campoInglesFluente = By.cssSelector("li:nth-child(5)");
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


    public void marcarTurnoNoite(){
        clicar(campoTurnoNoite);
    }
    public void marcarTurnoTarde(){
        clicar(campoTurnoTarde);
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
}

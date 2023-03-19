package captacao.vemser.dbccompany.pages;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.util.Locale;

public class FormPage extends BasePage{
    private Faker faker = new Faker(new Locale("pt-BR"));


    private static final By campoTurnoNoite = By.cssSelector("#turno-noite > span.MuiButtonBase-root.MuiRadio-root.MuiRadio-colorPrimary.PrivateSwitchBase-root.MuiRadio-root.MuiRadio-colorPrimary.MuiRadio-root.MuiRadio-colorPrimary.css-kf7w3t > input");
    private static final By campoTurnoTarde = By.cssSelector("#turno-tarde > span.MuiButtonBase-root.MuiRadio-root.MuiRadio-colorPrimary.PrivateSwitchBase-root.MuiRadio-root.MuiRadio-colorPrimary.MuiRadio-root.MuiRadio-colorPrimary.css-kf7w3t > input");
    private static final By campoInglesFluente = By.cssSelector("li:nth-child(5)");
    private static final By campoInstituicaoEnsino = By.cssSelector("[id=instituicao-de-ensino-candidato]");
    private static final By btnSelecaoEspanhol = By.cssSelector("div:nth-child(6) > div > div");
    private static final By btnEspanholNenhum = By.cssSelector("#menu-espanhol li:nth-child(1)");
    private static final By btnEspanholIniciante = By.cssSelector("#menu-espanhol li:nth-child(2)");
    private static final By btnEspanholIntermediario = By.cssSelector("#menu-espanhol li:nth-child(3)");
    private static final By btnEspanholAvancado = By.cssSelector("#menu-espanhol li:nth-child(4)");
    private static final By btnEspanholFluente = By.cssSelector("#menu-espanhol li:nth-child(5)");
    private static final By btnLinguagemInteresse = By.cssSelector("div:nth-child(9) > div > div");
    private static final By btnLinguagemInteresseSair = By.cssSelector("#menu- > div.MuiBackdrop-root.MuiBackdrop-invisible.css-esi9ax");
    private static final By btnCSharp = By.cssSelector("#menu- li:nth-child(1) .MuiButtonBase-root");
    private static final By btnJavaScript = By.cssSelector("#menu- li:nth-child(2) .MuiButtonBase-root");
    private static final By btnKotlin = By.cssSelector("#menu- li:nth-child(3) .MuiButtonBase-root");
    private static final By btnJava = By.cssSelector("#menu- li:nth-child(4) .MuiButtonBase-root");
    private static final By btnCmaismais = By.cssSelector("#menu- li:nth-child(5) .MuiButtonBase-root");
    private static final By btnPHP = By.cssSelector("#menu- li:nth-child(6) .MuiButtonBase-root");
    private static final By btnRuby = By.cssSelector("#menu- li:nth-child(7) .MuiButtonBase-root");
    private static final By btnPython = By.cssSelector("#menu- li:nth-child(8) .MuiButtonBase-root");
    private static final By btnSwift = By.cssSelector("#menu- li:nth-child(9) .MuiButtonBase-root");
    private static final By btnC = By.cssSelector("#menu- li:nth-child(10) .MuiButtonBase-root");
    private static final By btnOutras = By.cssSelector("#menu- li:nth-child(11) .MuiButtonBase-root");
    private static final By campoMotivoInteresse = By.cssSelector("[id=s2-candidato-motivo]");
    private static final By btnDisponibilidadeEfetivacaoSim = By.cssSelector("#s2-candidato-efetivacao-sim .css-hyxlzm");
    private static final By btnDisponobilidadeEfetivacaoNao = By.cssSelector("#s2-candidato-efetivacao-nao .css-hyxlzm");
    private static final By campoLinkLinkedIn = By.cssSelector("[id=s2-candidato-linkedin]");
    private static final By campoLabelLinkedIn = By.cssSelector("#s2-candidato-linkedin-label");
    private static final By btnConcordarDados = By.cssSelector("#s2-candidato-lgpd span:nth-child(1)");
    private static final By btnIrParaInscricao = By.cssSelector("div > button");
    private static final By btnEnviar = By.cssSelector("[id=s2-botao-submit]");
    private static final By campoErroInstituicao = By.cssSelector("#instituicao-de-ensino-candidato-helper-text");
    private static final By campoLabelEspanhol = By.cssSelector("div:nth-child(6) > div > label");
    private static final By campoErroLinguagem = By.cssSelector("div:nth-child(9) > div > p");
    private static final By campoTextoFormulario = By.cssSelector("div:nth-child(3) > span > span.MuiStepLabel-labelContainer.css-h2cmlr > span > div > p");
    private static final By campoErroMotivo = By.cssSelector("#s2-candidato-motivo-helper-text");
    private static final By campoPaginaAtual = By.cssSelector("form > div:nth-child(1) > label");
    private static final By campoErroConcordar = By.cssSelector("#mensagem-erro-lgpd");

    public void marcarTurnoNoite(){
        clicar(campoTurnoNoite);
    }
    public void marcarTurnoTarde(){
        clicar(campoTurnoTarde);
    }
    public void preencherCampoInstituicao(){
        preencheCampo(campoInstituicaoEnsino, faker.university().name());
    }
    public void preencherCampoInstituicaoIncorretamente(){ preencheCampo(campoInstituicaoEnsino, faker.lorem().sentence(50));}
    public void clicarEnviar(){ clicar(btnEnviar);}
    public Boolean verificaExistenciaErroInstituicao(){ return verificaExistenciaElemento(campoErroInstituicao);}
    public String verificaTextoCampoErroInstituicao(){
        return extraiTexto(campoErroInstituicao);
    }
    public void clicarEspanhol(){
        clicar(btnSelecaoEspanhol);
    }
    public void clicarEspanholNenhum(){
        clicar(btnEspanholNenhum);
    }
    public void clicarEspanholFluente(){
        clicar(btnEspanholFluente);
    }
    public String corCaixaEspanhol(){
        return extraiCores(campoLabelEspanhol);
    }
    public void clicarBtnLinguagemInteresse() {
        clicar(btnLinguagemInteresse);
    }
    public void clicarBtnLinguagemInteresseSair(){
        clicar(btnLinguagemInteresseSair);
    }
    public void clicarEmJava() {
        clicar(btnJava);
    }
    public String verificaTextoErroLinguagem(){
        return extraiTexto(campoErroLinguagem);
    }
    public void preencheCampoMotivo(){
        preencheCampo(campoMotivoInteresse, faker.lorem().sentence(20));
    }
    public void preencheCampoMotivoInsuficiente(){
        preencheCampo(campoMotivoInteresse, "abcdefghi");
    }
    public void preencheCampoMotivoInvalido(){
        preencheCampo(campoMotivoInteresse, "98734^!#$253462$%");
    }
    public Boolean verificaExistenciaCampoErroMotivo(){
        return verificaExistenciaElemento(campoErroMotivo);
    }
    public String extraiTextoCampoErroMotivo(){
        return extraiTexto(campoErroMotivo);
    }
    public void preencheCampoLinkedIn(){
        preencheCampo(campoLinkLinkedIn, "https://www.linkedin.com/in/giovanne-lopes-16289b215/");
    }
    public void preencheCampoLinkedInOutroSite(){
        preencheCampo(campoLinkLinkedIn, "https://google.com/");
    }
    public void preencheCampoLinkedInInvalido(){
        preencheCampo(campoLinkLinkedIn, "nfq39784fgnoia");
    }
    public Boolean verificaPaginaAtual(){
        return verificaExistenciaElemento(campoPaginaAtual);
    }
    public String extrairClasseAvisoLinkedIn(){
        return extraiClasses(campoLabelLinkedIn);
    }
    public void clicarConcordarTratamento(){
        clicar(btnConcordarDados);
    }
    public String verificaTextoErroConcordar(){
        return extraiTexto(campoErroConcordar);
    }
    public void clicarBtnVoltar(){
        clicar(btnIrParaInscricao);
    }

}

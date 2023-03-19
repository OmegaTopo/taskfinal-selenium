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




}

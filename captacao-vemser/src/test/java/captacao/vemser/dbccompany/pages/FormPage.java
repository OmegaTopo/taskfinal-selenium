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
    public void selecionarGeneroHomemCis(){
        clicar(campoGenero);
        clicar(campoGeneroHomemCis);
    }
    public void selecionarGeneroNaoBinario(){
        clicar(campoGenero);
        clicar(campoGeneroNaoBinario);
    }




}

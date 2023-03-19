package captacao.vemser.dbccompany.pages;

import net.datafaker.Faker;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class InfoPage extends BasePage {

    private Faker faker = new Faker(new Locale("pt-BR"));
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private static final By campoNome = By.cssSelector("[id=step-1-nome]");
    private static final By campoEmail = By.cssSelector("[id=step-1-email]");
    private static final By campoRG = By.cssSelector("[id=step-1-rg]");
    private static final By campoCPF = By.cssSelector("[id=step-1-cpf]");
    private static final By campoCelular = By.cssSelector("[id=step-1-telefone]");
    private static final By campoDataDeNascimento = By.cssSelector("[id=step-1-dataNascimento]");
    private static final By campoCidade = By.cssSelector("[id=step-1-cidade]");
    private static final By campoEstado = By.cssSelector("[id=step-1-estado]");
    private static final By campoEstadoPA = By.cssSelector("li:nth-child(14)");
    private static final By campoNeurodiversidade = By.cssSelector("div:nth-child(9) > div > div > svg");
    private static final By btnProximo = By.cssSelector("[id=step-1-enviar]");
    private static final By campoErroRG = By.cssSelector("p[id=\"step-1-rg-helper-text\"]");
    private static final By campoErroNome = By.cssSelector("#step-1-nome-helper-text");
    private static final By campoErroCPF = By.cssSelector("#step-1-cpf-helper-text");
    private static final By opcaoNeurodiversidadeNao = By.cssSelector("#menu-neurodiversidadeBoolean li:nth-child(1)");

    public void preencherNomeValido() {
        preencheCampo(campoNome, faker.name().nameWithMiddle());
    }
    public void preencherNomeSemSobrenome() {
        preencheCampo(campoNome, "Nome");
    }
    public void preencherNomeComNumero() {
        preencheCampo(campoNome, "123456789");
    }
    public void preencherNomeCurto() {
        preencheCampo(campoNome, "a");
    }
    public void preencherNomeEmBranco() {
        preencheCampo(campoNome, "");
    }

    public void preencherEmailValido() {
        preencheCampo(campoEmail, faker.internet().emailAddress());
    }

    public void preencherRGValido() {

        String rgValido = "14.274.429-3";

        clicar(campoRG);
        preencheCampo(campoRG, rgValido);
    }

    public void preencherRGEmBranco() {

    }

    public void preencherCPFValido() {
        clicar(campoCPF);
        preencheCampo(campoCPF, faker.cpf().toString());
    }
    public void preencherCPFInvalido() {
        clicar(campoCPF);
        preencheCampo(campoCPF, faker.cpf().invalid());
    }
    public void preencherCPFCurto(){
        clicar(campoCPF);
        preencheCampo(campoCPF, "123");
    }

    public void preencherCampoCelularValido() {
        preencheCampo(campoCelular, faker.phoneNumber().toString());
    }

    public void preencherCampoDataDeNascimentoValido() {
        preencheCampo(campoDataDeNascimento, dateFormat.format(faker.date().birthday()));
    }

    public void preencherCampoCidadeValido() {
        String cidadeValida = "Tailândia";
        preencheCampo(campoCidade, cidadeValida);
    }
    public void selecionarEstadoPA() {
        clicar(campoEstado);
        clicar(campoEstadoPA);
    }
    public void preencherCampoNeurodiversidade() {
        clicar(campoNeurodiversidade);
        clicar(opcaoNeurodiversidadeNao);
    }
    public void clicarEmProximo() {
        clicar(btnProximo);
    }
    public Boolean verificaExistenciaCampoErroRG() {

        return verificaExistenciaElemento(campoErroRG);
    }
    public String verificaCampoErroNome(){
        String texto = extraiTexto(campoErroNome);
        return texto;
    }
    public String verificaCampoErroCPF(){
        String texto = extraiTexto(campoErroCPF);
        return texto;
    }
}

package captacao.vemser.dbccompany.pages;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
    private static final By campoEstadoRS = By.cssSelector("li:nth-child(21)");
    private static final By campoNeurodiversidade = By.cssSelector("div:nth-child(9) > div > div");
    private static final By campoDescricaoNeuro = By.cssSelector("[id=step-1-neurodiversidade]");
    private static final By btnProximo = By.cssSelector("[id=step-1-enviar]");
    private static final By campoErroRG = By.cssSelector("p[id=\"step-1-rg-helper-text\"]");
    private static final By campoErroNome = By.cssSelector("#step-1-nome-helper-text");
    private static final By campoErroCPF = By.cssSelector("#step-1-cpf-helper-text");
    private static final By campoErroEmail = By.cssSelector("p[id=\"step-1-email-helper-text\"]");
    private static final By campoErroCelular = By.cssSelector("p[id=\"step-1-telefone-helper-text\"]");
    private static final By campoErroCidade = By.cssSelector("p[id=\"step-1-cidade-helper-text\"]");
    private static final By opcaoNeurodiversidadeNao = By.cssSelector("#menu-neurodiversidadeBoolean li:nth-child(1)");
    private static final By opcaoNeurodiversidadeSim = By.cssSelector("#menu-neurodiversidadeBoolean li:nth-child(2)");
    private static final By campoProximaPagina = By.cssSelector("form > div:nth-child(1) > label");
    private static final By campoErroDataDeNascimento = By.cssSelector("p[id=\"step-1-dataNascimento-helper-text\"]");
    private static final By itensBarraDeStatus = By.cssSelector("div:nth-child(1) span[class*=\"MuiStepLabel-iconContainer\"]");

    public void preencherNomeValido() {
        preencheCampo(campoNome, faker.name().nameWithMiddle().replaceAll("[-+.^:,]",""));
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
    public void preencherEmailInvalido(){
        preencheCampo(campoEmail, "giovanne@pao4ferfseg.ovo5w");
    }
    public void preencherRGValido() {

        String rgValido = "14.274.429-3";

        clicar(campoRG);
        preencheCampo(campoRG, rgValido);
    }
    public void preencherRGInvalido() {
        String rgInvalido = "rgInvalido";

        clicar(campoRG);
        preencheCampo(campoRG, rgInvalido);
    }
    public void preencherRGComCaracteresInvalidos() {
        String caracteresInvalidos = "++--*/*";

        clicar(campoRG);
        preencheCampo(campoRG, caracteresInvalidos);
    }
    public String extraiTextoCampoRG() {

        return extraiTexto(campoRG);
    }
    public String extraiTextoCampoErroRG() {

        return extraiTexto(campoErroRG);
    }
    public void preencherCPFValido() {
        clicar(campoCPF);
        preencheCampo(campoCPF, faker.cpf().valid());
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
        preencheCampo(campoCelular, faker.phoneNumber().cellPhone());
    }
    public void preencherCampoDataDeNascimentoValido() {
        preencheCampo(campoDataDeNascimento, dateFormat.format(faker.date().birthday()));
    }
    public void preencherCampoDataDeNascimentoComDataInvalida() {
        String dataInvalida = "14/02/199348";

        preencheCampo(campoDataDeNascimento, dataInvalida);
    }
    public void preencherCampoDataDeNascimentoComDataFutura() {
        preencheCampo(campoDataDeNascimento, faker.date().future(60, TimeUnit.DAYS).toString());
    }
    public void preencherCampoDataDeNascimentoComIdadeAbaixoDezesseisAnos() {
        Date dataDeNascimentoMenosDoze = Date.from(LocalDateTime.now().minusYears(12).toInstant(ZoneId.systemDefault().getRules().getOffset(Instant.now())));

        preencheCampo(campoDataDeNascimento, dateFormat.format(dataDeNascimentoMenosDoze));
    }
    public Boolean verificaExistenciaCampoErroDataDeNascimento() {
        return verificaExistenciaElemento(campoErroDataDeNascimento);
    }
    public String extraiTextoCampoErroDataDeNascimento() {
        return extraiTexto(campoErroDataDeNascimento);
    }
    public void preencherCampoCidadeValido() {
        String cidadeValida = "Tailândia";
        preencheCampo(campoCidade, cidadeValida);
    }
    public void preencherCampoCidadeInvalido(){
        String cidadeInvalida = "@@##$$55";

        preencheCampo(campoCidade, cidadeInvalida);
    }
    public void selecionarEstadoPA() {
        clicar(campoEstado);
        clicar(campoEstadoPA);
    }
    public void selecionarEstadoRS() {
        clicar(campoEstado);
        clicar(campoEstadoRS);
    }
    public String verificarCampoEstado(){
        String texto = extraiTexto(campoEstado);
        return texto;
    }
    public void preencherCampoNeurodiversidadeNao() {
        clicar(campoNeurodiversidade);
        clicar(opcaoNeurodiversidadeNao);
    }
    public void preencherCampoNeurodiversidadeSim() {
        clicar(campoNeurodiversidade);
        clicar(opcaoNeurodiversidadeSim);
    }
    public void preencherCampoNeurodiversidadeValido(){
        preencheCampo(campoDescricaoNeuro, "Ansiedade");
    }
    public void preencherCampoNeurodiversidadeInvalido(){
        preencheCampo(campoDescricaoNeuro, "12#$56");
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
    public Boolean verificaExistenciaCampoErroEmail(){

        return verificaExistenciaElemento(campoErroEmail);
    }
    public Boolean verificaExistenciaCampoErroCelular(){

        return verificaExistenciaElemento(campoErroCelular);
    }
    public void preencheCampoTelefoneInvalido(){

        preencheCampo(campoCelular, faker.phoneNumber().toString());
    }
    public Boolean verificaExistenciaCampoErroCidade(){

        return verificaExistenciaElemento(campoErroCidade);
    }
    public Boolean verificaExistenciaCampoNeuro(){
        return verificaExistenciaElemento(campoDescricaoNeuro);
    }
    public Boolean verificaExistenciaProximaPagina(){
        return verificaExistenciaElemento(campoProximaPagina);
    }

    public Boolean verificaExistenciaCampoErroCPF(){
        return verificaExistenciaElemento(campoErroCPF);
    }
    public List<String> listaDeClassesDeElementosDaBarraDeStatus() {
        List<WebElement> elementos = buscaElementos(itensBarraDeStatus);
        List<String> listaDeClasses = new ArrayList<>();

        for (int i = 0; i < elementos.size(); i++) {
            listaDeClasses.add(extraiClassesElemento(elementos.get(i)));
        }
        return listaDeClasses;
    }
}

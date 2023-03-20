package captacao.vemser.dbccompany.pages;

import org.openqa.selenium.By;

public class SendPage extends BasePage {

    private static final By campoInscricaoSucesso = By.cssSelector("div.MuiAlert-message.css-1xsto0d > div");

    public Boolean verificaExistenciaCampoSucessoInscricao() {
        return verificaExistenciaElemento(campoInscricaoSucesso);
    }

    public String extraiTextoCampoSucessoInscricao() {
        return extraiTexto(campoInscricaoSucesso);
    }
}

package captacao.vemser.dbccompany.pages;

import captacao.vemser.dbccompany.util.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BasePage extends Elements {
    public static void clicar (By seletor){
        aguardaCarregamentoElemento(seletor);

        buscaElemento(seletor).click();
    }
    public static void preencheCampo(By seletor, String texto){
        aguardaCarregamentoElemento(seletor);

        buscaElemento(seletor).sendKeys(texto);
    }
    public static String extraiTexto(By seletor){
        aguardaCarregamentoElemento(seletor);

        return buscaElemento(seletor).getText();
    }

    public static String extraiClasses(By seletor) {
        aguardaCarregamentoElemento(seletor);

        return buscaElemento(seletor).getAttribute("class");
    }

    public static String extraiCores(By seletor) {
        aguardaCarregamentoElemento(seletor);

        return buscaElemento(seletor).getCssValue("color");
    }

    public static Boolean verificaSeElementoApareceNaTela(By seletor) {
        aguardaCarregamentoElemento(seletor);

        return buscaElemento(seletor).isDisplayed();
    }

    public static Boolean verificaSeElementoEstaAtivo(By seletor) {
        aguardaCarregamentoElemento(seletor);

        return verificaSeElementoApareceNaTela(seletor);
    }

    public static Boolean verificaExistenciaElemento(By seletor) {
        try {
            buscaElemento(seletor);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

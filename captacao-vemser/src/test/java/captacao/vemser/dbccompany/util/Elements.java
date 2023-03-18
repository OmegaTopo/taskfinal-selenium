package captacao.vemser.dbccompany.util;

import captacao.vemser.dbccompany.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elements extends BaseSteps {
    public static WebElement buscaElemento(By seletor){
        return driver.findElement(seletor);
    }
    public static void aguardaCarregamentoElemento(By seletor){
        wait.until(ExpectedConditions.presenceOfElementLocated(seletor));
    }

    public static Boolean vefificaElementoAtivo(By seletor) {
        return driver.findElement(seletor).isEnabled();
    }
}

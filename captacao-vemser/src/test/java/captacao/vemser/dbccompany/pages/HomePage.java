package captacao.vemser.dbccompany.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private static final By btnInscricao = By.cssSelector("div > button");


    public void clicarBtnInscricao(){
        clicar(btnInscricao);
    }
}

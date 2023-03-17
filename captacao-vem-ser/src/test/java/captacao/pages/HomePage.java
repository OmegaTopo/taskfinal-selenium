package captacao.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private static final By btnInscricao = By.cssSelector("div > button");


    public void clicarBtnInscricao(){
        click(btnInscricao);
    }
}

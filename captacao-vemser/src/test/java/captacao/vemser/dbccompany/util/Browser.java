package captacao.vemser.dbccompany.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void abrirONavegador(String url){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,40);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }
    public void fecharONavegador(){
        driver.quit();
    }

}

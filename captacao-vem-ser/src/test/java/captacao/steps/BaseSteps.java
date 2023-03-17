package captacao.steps;

import captacao.util.Browser;
import org.junit.After;
import org.junit.Before;

public class BaseSteps extends Browser {
    @Before
    public void abrirNavegador(){
        abrirONavegador("http://vemser-dbc.dbccompany.com.br:39000/vemser/captacao-front");
    }
    @After
    public void fecharNavegador(){
        fecharONavegador();
    }
}

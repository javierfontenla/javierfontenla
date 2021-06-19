package Examen;

import org.testng.annotations.Factory;

public class factoryExamen {

    @Factory
    public Object[] factoryExamen(){
        return new Object[] {
                new prueba_mailchimp(),
                new prueba_mailchimp()
        };
    }





}

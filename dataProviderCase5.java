package Examen;

import org.testng.annotations.DataProvider;

public class dataProviderCase5 {

    @DataProvider(name = "emailsExamen")
    public Object[][] emailTest() {
        return new Object[][]{
                {"testqa@gmail.com", "Holamundo2021!"},
                {"qatest@yahoo.com", "Holamundo2021!"},
                {"qatest@hotmail.com", "Holamundo2021!"},


        };
    }


}

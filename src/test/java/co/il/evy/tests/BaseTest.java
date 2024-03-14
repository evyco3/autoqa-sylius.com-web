package co.il.evy.tests;


import co.il.evy.framework.drivers.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {


    @BeforeMethod
    public void setup() {
        Driver.init();


    }

    @AfterMethod
    public void tearDown() {
        Driver.quit();

    }

}




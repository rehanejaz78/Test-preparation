import Pages.NewUser;
import Pages.LoginHrm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class test {

    static WebDriver driver= null;

    @BeforeClass
    public void setup () {

        System.setProperty("webdriver.chrome.driver","D:\\movies\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


    }

    @Test(priority = 1)
    public void LoginHRM(){

        LoginHrm obj = new LoginHrm(driver);
        obj.enterEmail();
        obj.enterPassword();
        obj.ClickLogin();

    }


    public void newUser(){

        NewUser obj = new NewUser(driver);
        obj.clickAdmin();
        obj.clickAdduser();
        obj.setDropdownClick();
        obj.Addename();
        obj.uname();
        obj.setPassword();
        obj.ClickSaveBtn();

        System.out.println("Done");
    }

    @Test(priority = 2)
    public void EditUserTest() throws InterruptedException {
        NewUser obj2 = new NewUser(driver);


        //obj2.search();
        obj2.Edit();
        Thread.sleep(3000);



    }



    @AfterClass
    public void tear(){

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }
}

import Pages.CMSLogin;
import Pages.LMS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CMS_Tests {

    WebDriver driver;

    @BeforeClass
    public void setup(){

        System.setProperty("webdriver.chrome.driver","D:\\movies\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://cms.bahria.edu.pk/Logins/Student/Login.aspx");

        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void LoginCms(){

        CMSLogin obj = new CMSLogin(driver);

        obj.enterEnrollment();
        obj.enterpassword();
        obj.instituteSelect();
        obj.clickLogin();

    }

    @Test(priority = 2)
    public void GetResultTest(){

        CMSLogin obj2 = new CMSLogin(driver);
        obj2.clickResultProviosnal();
        obj2.getResult();
    }

    @Test(priority = 3)
    public void LmsAssignment() throws InterruptedException {
        LMS obj = new LMS(driver);
        obj.ClickLMS();
        obj.ClickAssignmnet();
        obj.semesterDropDown();
        obj.selectCourse();
    }
    @AfterClass
    public void tear(){
        driver.quit();
    }

}

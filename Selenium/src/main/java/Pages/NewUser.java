package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class NewUser  {

    By admin = By.id("menu_admin_viewAdminModule");
    By adduser = By.id("btnAdd");

    By name = By.id("systemUser_employeeName_empName");
    By uname = By.id("systemUser_userName");
    By password = By.id("systemUser_password");
    By c_password = By.id("systemUser_confirmPassword");
    By saveBtn = By.id("btnSave");
    WebDriver driver;
    By dropdownClick = By.id("systemUser_userType");
    By myuser = By.linkText("helloworld3");
    By searchbar = By.name("searchSystemUser[userName]");
    By searchBtn = By.className("searchbutton");


    public NewUser(WebDriver drivver){

        this.driver = drivver;}

    public void clickAdmin(){
                driver.findElement(admin).click();

    }
    public void clickAdduser(){
        driver.findElement(adduser).click();
    }
    public void setDropdownClick(){

        WebElement dd = driver.findElement(dropdownClick);
        Select option = new Select(dd);
        option.selectByVisibleText("Admin");
    }

    public void Addename(){driver.findElement(name).sendKeys("Cecil Bonaparte");}
    public void uname(){driver.findElement(uname).sendKeys("helloworld3");}
    public void setPassword()
    {
        driver.findElement(password).sendKeys("Rehan@1234");
        driver.findElement(c_password).sendKeys("Rehan@1234");
    }

    public void ClickSaveBtn(){driver.findElement(saveBtn).click();}


    public void Edit() throws InterruptedException {

        driver.findElement(admin).click();
        WebElement user =  driver.findElement(myuser);
        Actions action = new Actions(driver);
        action.moveToElement(user).perform();

        user.click();

        driver.findElement(saveBtn).click();
        driver.findElement(uname).sendKeys("helloworld3");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        setPassword();
        driver.findElement(saveBtn).click();

        Thread.sleep(5000);

    }

    public void search() throws InterruptedException {

        driver.findElement(admin).click();

        driver.findElement(searchbar).sendKeys("helloworld3");
        driver.findElement(searchBtn).click();

        Thread.sleep(3000);



         String text =  driver.findElement(By.linkText("helloworld3")).getText();

        Assert.assertEquals("helloworld3",text);






    }

}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;



public class LMS {

    WebDriver driver;
    By lms = By.linkText("Go To LMS");
    By assignment = By.linkText("Assignments");
    By semesterdropdown = By.name("semesterName");
    By courseName = By.name("courseName");
    By assignmentLink = By.xpath("//tbody/tr[2]/td[6]/a[1]");


    public LMS(WebDriver driver){
        this.driver = driver;
    }



    public void ClickLMS(){
        driver.findElement(lms).click();

       Set<String> windowHandles  =  driver.getWindowHandles();

        Iterator <String> iterator= windowHandles.iterator();

        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);
    }

    public void ClickAssignmnet(){
        driver.findElement(assignment).click();
    }
    public void semesterDropDown() throws InterruptedException {

        WebElement drop = driver.findElement(semesterdropdown);
        Select dropdown = new Select(drop);
        Thread.sleep(3000);
        dropdown.selectByVisibleText("Fall-2021");


    }
    public void selectCourse() throws InterruptedException {
        WebElement course = driver.findElement(courseName);
        Select dropdown = new Select(course);
        dropdown.selectByVisibleText("Software Quality Assurance");

        Thread.sleep(3000);
        driver.findElement(assignmentLink).sendKeys(Keys.RETURN);
    }



}

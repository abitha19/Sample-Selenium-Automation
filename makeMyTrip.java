import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class makeMyTrip {

    public static void main (String args[]) throws InterruptedException {
        //Path of chrome driver
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        String baseURL="https://www.makemytrip.com/";
        driver.get(baseURL);
        driver.navigate();


        WebDriverWait wait=new WebDriverWait(driver, 10);

        // Select from
        driver.findElement(By.id("hp-widget__sfrom")).click();
        WebElement departureTextArea=driver.findElement(By.id("hp-widget__sfrom"));
        departureTextArea.sendKeys("Hyderabad");

        // Select to
        driver.findElement(By.id("hp-widget__sTo")).click();
        WebElement arrivalTextArea=driver.findElement(By.id("hp-widget__sTo"));
        arrivalTextArea.sendKeys("Chennai");

       // Departure Date ( 28 hard coded by default )
       WebElement dateDep= driver.findElement(By.xpath("//*[@id=\"hp-widget__depart\"]"));
       dateDep.click();



      /*  List<WebElement> columns = dateDep.findElements(By.tagName("td"));
        for(WebElement cell : columns){
            if (cell.getText().equals("28"))
            {
                cell.click();
                break;

            }
        } */

        // Pick 3 adults
        driver.findElement(By.id("hp-widget__paxCounter")).click();
        driver.findElement(By.xpath("//*[@id=\"js-adult_counter\"]/li[3]")).click();

        // Click Search
        driver.findElement(By.id("searchBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"chf_header\"]/div[2]/div/ul/li[2]/a/span[1]")));

        System.out.println("Success");

        driver.close();
        driver.quit();

    }
}

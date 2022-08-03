package Components;

import Forms.Webforms;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


public class Alerts
{

    WebDriver driver;

    public static String browser,driverPath,browserUrl;
    File file;
    FileInputStream fis;
    Properties prop;

    WebDriverWait wait;

    WebElement iframe,body;

    public void fileLoading() {

        try {



            // File fl = new File();
            // FileInputStream fis = new FileInputStream()
            file= new File("C:/Users/abhat357/Automation/ODS-QA-Automation-serenity-framework/Selenium\\resource\\config.properties");
            fis = new FileInputStream(file);
            prop = new Properties();

            prop.load(fis);

            browser = prop.getProperty("_browserName");
            driverPath = prop.getProperty("_driverPath");
            browserUrl = prop.getProperty("_browserUrl");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invokeBrowser() {
        try {


            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
                driver.navigate().to(browserUrl);
                driver.manage().window().maximize();
                // Thread.sleep(10000);

            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.firefox.driver", driverPath);
                driver = new FirefoxDriver();
                driver.navigate().to(browserUrl);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void check() throws InterruptedException {

       /* driver.findElement(By.id("alertButton")).click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();
*/

        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(6000);

        Alert alert = driver.switchTo().alert();

        alert.accept();
         // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")))

        driver.close();
        driver.quit();




    }

    public void frames()
    {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame2")));
        driver.switchTo().frame(iframe);
        body = driver.findElement(By.id("sampleHeading"));
        System.out.println(body.getText().toString());


    }

    public void flipkart()
    {

    }


    public static void main (String[]args) throws InterruptedException
    {

        Alerts al = new Alerts();
        al.fileLoading();
        al.invokeBrowser();
        al.frames();


    }
}

package selenium.main;

import Utils.Dateutils;
import org.apache.commons.io.FileUtils;
import selenium.main.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Base
{

    static WebDriver driver;
    public static String browser,driverPath,browserUrl;
    static File file;
    static FileInputStream fis;
    static Properties prop;



    public WebDriverWait wait;


    public static void fileLoading() {

        try {

            file= new File("C:/Users/abhat357/Automation/ODS-QA-Automation-serenity-framework/Selenium\\resource\\config.properties");
            fis = new FileInputStream(file);
            prop = new Properties();

            //wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            prop.load(fis);

            browser = prop.getProperty("_browserName");
            driverPath = prop.getProperty("_driverPath");
            browserUrl = prop.getProperty("_browserUrl");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void invokeBrowser() {
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




    public void screenshot(){

        TakesScreenshot ts = (TakesScreenshot) driver;

        File pic = ts.getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(pic,new File("C:\\Users\\abhat357\\Automation\\ODS-QA-Automation-serenity-framework" +
                    "\\Selenium\\results\\"+ Dateutils.timestamp()+".png"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

}

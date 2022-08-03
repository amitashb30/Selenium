package Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.main.Facebook;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


public class Webforms
{

    WebDriver driver;
    public static String browser,driverPath,browserUrl;
    File file;
    FileInputStream fis;
    Properties prop;

    WebDriverWait wait;

    WebElement Fullname,email,ph_number,address,gender,subject,hobbies,dob,day,month,year,dobtable,male,female,others;



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


    public void form() {
        try {
            Fullname = driver.findElement(By.id("firstName"));
            Fullname.sendKeys("test1");
            email = driver.findElement(By.id("userEmail"));
            email.sendKeys("abc@gmail.com");
            address = driver.findElement(By.id("lastName"));
            address.sendKeys("lastname");


           /* male = driver.findElement(By.id("gender-radio-1"));

            female = driver.findElement(By.id("gender-radio-2"));

            if(male.isDisplayed())
            {
                male.click();
                System.out.println("Male is selected");

            }

            else if(female.isEnabled())
            {
                female.click();
                System.out.println();
            }

            */
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,200)","");

            dob = driver.findElement(By.id("dateOfBirthInput"));
            dob.click();

            month = driver.findElement(By.className("react-datepicker__month-select"));

            Select months = new Select(month);
            months.selectByVisibleText("July");

            year = driver.findElement(By.className("react-datepicker__year-select"));
            Select years = new Select(year);
            years.selectByValue("2024");

            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]"))).click();

            Thread.sleep(2000);

            js.executeScript("window.scrollBy(0,200)","");


            wait.until(ExpectedConditions.elementToBeClickable(By.id("hobbies-checkbox-1"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();

            driver.quit();

            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("state"))).sendKeys("Haryana");
            //statebox = css-1hwfws3
            //ncr =  css-1uccc91-singleValue
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


        public static void main (String[]args) throws InterruptedException
        {
            Webforms wb = new Webforms();
            wb.fileLoading();
            wb.invokeBrowser();
            wb.form();


        }
    }
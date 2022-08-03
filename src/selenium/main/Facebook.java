package selenium.main;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Facebook extends Base
{
    WebElement Fullname,click,div,fashion,bw,ft,button1,button2,button3,checkbox1,upload;

        public void drapanddrop() throws InterruptedException {


            try {
                Actions act = new Actions(driver);

                WebElement from = driver.findElement(By.id("draggable"));
                WebElement to = driver.findElement(By.id("droppable"));

                screenshot();

                Thread.sleep(3000);

                act.dragAndDrop(from, to).perform();
                screenshot();

                Thread.sleep(3000);
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        public void TextBox()
        {
            Fullname = driver.findElement(By.id("userName"));
            Fullname.sendKeys("test");
            WebElement email = driver.findElement(By.id("userEmail"));
            email.sendKeys("abc@gmail.com");
            WebElement address = driver.findElement(By.id("currentAddress"));
            address.sendKeys("test");

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,200)","");

            WebElement submit = driver.findElement(By.id("submit"));
            submit.click();






        }

        public void flipkart()  {

            try {
                Actions action = new Actions(driver);
                /*click = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
                click.click();
                screenshot();

                Thread.sleep(3000);



                fashion = driver.findElement(By.xpath("//*[@id=\"product-menu-toggle\"]"));


                action.moveToElement(fashion).build().perform();

                bw = driver.findElement(By.xpath("//*[@id=\"product-menu-dropdown\"]/div[1]/ul[1]/li[2]/a/div[2]"));



                action.moveToElement(bw).build().perform();

                 */

                ft = driver.findElement(By.xpath("//a[@id='free-trial-link-anchor']"));

                action.doubleClick(ft).perform();

                driver.navigate().to(browserUrl);


                Thread.sleep(3000);

            }

            catch(Exception e){
                    e.printStackTrace();
                }
            }


            public void radiobutton(){

            try{


                button1 = driver.findElement(By.id("vfb-7-1"));
                button2 = driver.findElement(By.id("vfb-7-2"));
                button3 = driver.findElement(By.id("vfb-7-3"));
                button1.click();


                if(button1.isSelected()) {
                    System.out.println("button1 is selected");

                }
               button2.click();

                if(button2.isSelected()){
                    System.out.println("button2 is selected");
                }


                checkbox1 = driver.findElement(By.id("vfb-6-0"));
                checkbox1.click();


            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            }



            public void dropdown(){

                Select country = new Select(driver.findElement(By.name("country")));
                country.selectByVisibleText("INDIA");


            }

            public void upload(){

               driver.findElement(By.xpath("//*[@id=\"uploadFile\"]"));
               upload.sendKeys("C:/Users/abhat357/Pictures/snap1.png");

            }


        public void closeBrowser()  {
            try{
                Thread.sleep(3000);
                driver.close();
                driver.quit();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        public static void main(String[] args) throws InterruptedException {
            Facebook fb = new Facebook();
            fileLoading();
            invokeBrowser();
            fb.upload();
            fb.closeBrowser();


        }
    }





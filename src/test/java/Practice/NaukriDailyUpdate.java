package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

public class NaukriDailyUpdate {

    WebDriver driver;

    @Test (priority = 1)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.naukri.com/");
    }

    @Test (priority = 2)
    public void accountLogin(){
        String loginId = "luckychandra15071998@gmail.com";
        String password = "Naukri@15071998";
        driver.findElement(By.id("login_Layer")).click();
        driver.findElement(By.xpath("//div[@class='login-layer']//label[contains(.,'E')]/following-sibling::input")).sendKeys(loginId , Keys.TAB , password);
        driver.findElement(By.xpath("//div[@class='login-layer']//button")).click();
    }

    @Test (priority = 3, dependsOnMethods = "accountLogin")
    public void updateProfile() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='view-profile-wrapper']/a")).click();

        try {
            WebElement chatBotNavCloseBtn = driver.findElement(By.xpath("//div[@class='chatbot_Nav']/div"));
            if (chatBotNavCloseBtn.isDisplayed()){
                chatBotNavCloseBtn.click();
            }
        } catch (Exception e) {
            Reporter.log("[WARNING] Chat page is not displayed.." , true);
        }

        WebElement editDetailsBtn = driver.findElement(By.xpath("//div[@class='hdn']/em"));
        editDetailsBtn.click();
        WebElement nameValue = driver.findElement(By.id("name"));
        nameValue.clear();
        boolean firstCheck = true;
        while (firstCheck){
            if (nameValue.getText().isEmpty()){
                nameValue.sendKeys("Chandrakanta N");
                firstCheck = false;
            }else {
                nameValue.clear();
            }
        }
        WebElement saveBtn = driver.findElement(By.id("saveBasicDetailsBtn"));
        saveBtn.click();

        editDetailsBtn.click();
        nameValue.clear();
        boolean secondCheck = true;
        while (secondCheck){
            if (nameValue.getText().isEmpty()){
                nameValue.sendKeys("Chandrakanta Nayak");
                secondCheck = false;
            }else {
                nameValue.clear();
            }
        }
        saveBtn.click();
    }

    @Test (priority = 4, dependsOnMethods = "updateProfile")
    public void verifyUpdate(){
        String updatedName = driver.findElement(By.cssSelector("[class='hdn']>span[class='fullname']")).getText();
        String actualName = "Chandrakanta Nayak";
        if (updatedName.equals(actualName)){
            Reporter.log("Lucky.. Your profile is updated successfully.." , true);
            String lastUpdatedDate = driver.findElement(By.xpath("//div[@class='mod-date']//span[contains(@class,'typ-14M')]")).getText();
            Reporter.log("Profile last updated - " + lastUpdatedDate , true);
        }
        driver.quit();
    }

}

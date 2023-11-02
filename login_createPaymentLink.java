package SeerBit.Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login_createPaymentLink {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seerbit.com/");
		WebElement loginLink=driver.findElement(By.linkText("Login"));
		loginLink.click();
		
		WebElement loginEmail=driver.findElement(By.id("email"));
		loginEmail.sendKeys("mluther@yopmail.com");
		WebElement loginPassword=driver.findElement(By.id("password"));
		loginPassword.sendKeys("password");
		WebElement eyeSlash=driver.findElement(By.cssSelector(".fa.fa-eye-slash"));
		eyeSlash.click();
		WebElement submitBtn=driver.findElement(By.xpath("//button[@type='submit']"));
		submitBtn.click();
		
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement closePopup=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.reactour__close")));
		 closePopup.click();
		 
		 
		WebElement payment=driver.findElement(By.id("payments"));
		payment.click();
		
		
		WebElement paymentLinks=driver.findElement(By.linkText("Payment Links"));
		paymentLinks.click();
		
		WebElement createPaymentLink=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".brand-btn.btn.btn-xdh")));
		createPaymentLink.click();
		
		
		WebElement pageName=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='paymentLinkName']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageName);
		pageName.sendKeys("TestPaymentLink");
		
	    WebElement selectCurrency=	driver.findElement(By.cssSelector("select[name='currency']"));
	    selectCurrency.click();
	    
	    WebElement nairaOption = driver.findElement(By.xpath("//option[@value='NGN' and normalize-space()='Naira']"));
        nairaOption.click();
        
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(-0, 500)");
        
         WebElement createBtn=driver.findElement(By.cssSelector("button[type='submit']"));
         createBtn.click();
         
       WebElement copyPaymentLink=  driver.findElement(By.xpath("(//img)[14]"));
       copyPaymentLink.click();
	

}
}

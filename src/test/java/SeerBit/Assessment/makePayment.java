package SeerBit.Assessment;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makePayment {

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
		
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement closePopup=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.reactour__close")));
		 closePopup.click();
		 
		 
		WebElement payment=driver.findElement(By.id("payments"));
		payment.click();
		
		WebElement paymentLinks = driver.findElement(By.linkText("Payment Links"));
		paymentLinks.click();

		WebElement copyPaymentLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='cursor-pointer'])[3]")));
		copyPaymentLink.click();
		
		// Set clipboard content with the URL
		String url= "https://pay.seerbitapi.com/77297179";
		StringSelection stringSelection = new StringSelection(url);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		
		

		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location.href='" + url + "'");

		// Verify that the URL is in the address bar
		String currentUrl = (String) js.executeScript("return window.location.href;");
		System.out.println("Current URL: " + currentUrl);
		
		
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
	
		
		WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://checkout.seerbitapi.com']")));
		driver.switchTo().frame(iframeElement);
		
		
		
		WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
		firstName.sendKeys("Tanigororo");
		
		WebElement lastName=driver.findElement(By.id("lastName"));
		lastName.sendKeys("Banigororo");
	       
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("tanibani@yopmail.com");
		
		WebElement amount= driver.findElement(By.id("amount"));
		amount.sendKeys("10000");
		
		
		WebElement payButton=driver.findElement(By.cssSelector(".pay-button"));
		
		payButton.click();
		
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
	
		  
		
		WebElement displayCardsParagraph = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p[class='text-black payment-option-label mb-1 mt-2 text-center cursor-pointer']")));
		displayCardsParagraph.click();
		
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
		
		WebElement testCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'test-card') and div[text()='5123 4500 0000 0008']]")));
		testCard.click();
		
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
		
		WebElement pay= wait.until(ExpectedConditions.elementToBeClickable(By.id("trigger")));
		pay.click();
		
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
		
		WebElement authorizePay=  wait.until(ExpectedConditions.elementToBeClickable(By.id("trigger")));
		authorizePay.click();
		
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
		
		WebElement submit=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='sc-brKeYL cYreDs']")));
		submit.click();
		//driver.quit();
	       
	     
	
		
	}

}

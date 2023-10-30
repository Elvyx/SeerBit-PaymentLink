package SeerBit.Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class signUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seerbit.com/");
		
		WebElement signUp=driver.findElement(By.cssSelector(".button-copy.w-button"));
		signUp.click();
		
		WebElement acceptCookies=driver.findElement(By.xpath("//a[@id='hs-eu-confirmation-button']"));
		acceptCookies.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement countrySelection=driver.findElement(By.xpath("//div[@class='basic-single css-2b097c-container']"));
		countrySelection.click();
		String desiredCountry = "Nigeria";
		WebElement countryInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-2-input")));
		countryInput.sendKeys(desiredCountry);
		countryInput.sendKeys(Keys.ENTER);
		
		WebElement businessName=driver.findElement(By.xpath("//input[@name='business_name']"));
		businessName.sendKeys("Teebd's place");
	
		
		WebElement firstName=driver.findElement(By.cssSelector("input[name='first_name']"));
		firstName.sendKeys("Teniola");
		
		WebElement lastName=driver.findElement(By.cssSelector("input[name='last_name']"));
		lastName.sendKeys("Badmus");
		
		WebElement email= driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("teebd@yopmail.com");
		
		WebElement phoneNumber= driver.findElement(By.xpath("//input[@name='phone_number']"));
		phoneNumber.sendKeys("08065789001");
		
		WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
		
		password.sendKeys("password");
		
		WebElement submitButton= driver.findElement(By.cssSelector("button[type='submit']"));
		submitButton.click();
		
		
		
		WebElement confirmEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[normalize-space()='Confirm Your Email'])[1]")));;
		String confirmEmailText=confirmEmail.getText();
		System.out.println(confirmEmailText);
		
		Assert.assertEquals("Confirm Your Email", confirmEmailText);
		
		
		
	}

}

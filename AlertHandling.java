package learnAlert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://buythevalue.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@class,'product-title')])[1]")).click();
		//driver.findElement(By.id("wk_zipcode")).sendKeys("560076");
		//driver.findElement(By.xpath("//input[@value='Check']")).click();
		driver.findElement(By.xpath("(//span[text()='Add to Cart'])[1]")).click();
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//span[text()='View Cart'])[1]")).click();
		driver.findElement(By.id("checkout")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.xpath("//input[@id='agree']")).click();
		driver.findElement(By.id("checkout")).click();
		
	}

}

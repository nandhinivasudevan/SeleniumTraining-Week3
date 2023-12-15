package learnAlert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAndFrameHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(1000);
		driver.switchTo().frame(1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frameeg = driver.findElement(By.xpath("//button[text()='Try it']"));
		frameeg.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Nandhini");
		Thread.sleep(1000);
		alert.accept();
		frameeg.getText();
		System.out.println(frameeg.getText());

	}

}

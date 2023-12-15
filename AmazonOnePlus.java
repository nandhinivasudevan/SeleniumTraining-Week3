package learnAlert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonOnePlus {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("OnePlus 9 Pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		String priceText = driver.findElement(By.xpath("(//span[contains(@class,'a-price-whole')])[1]")).getText();
		System.out.println(priceText);
		String ratingText = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base s-underline-text')])[1]")).getText();
		System.out.println(ratingText);
		driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base a-text-normal')])[1]")).click();
		Thread.sleep(2000);
		
		//Move to the new window
		Set<String> winHandles = driver.getWindowHandles();
		List<String> childwindows = new ArrayList<String>(winHandles);
		for(int i=0;i<childwindows.size();i++) {
			String title = driver.switchTo().window(childwindows.get(1)).getTitle();
		}
		//get the screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/product.png");
		FileUtils.copyFile(source, dest);
		driver.findElement(By.id("submit.add-to-cart")).click();
		
		//move to the frame
		WebElement frameeg = driver.findElement(By.xpath("//span[contains(@id,'attach-accessory-cart-subtotal')]"));
		String finalAmt = frameeg.getText();
		System.out.println(finalAmt);
		frameeg.click();
		
		driver.quit();
	}

}

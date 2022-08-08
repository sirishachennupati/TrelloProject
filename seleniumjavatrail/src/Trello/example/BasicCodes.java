package Trello.example;
import java.time.Duration;
import org.openqa.selenium.Keys;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BasicCodes {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));				
		driver.get("https://trello.com/en/login");
		WebElement email = driver.findElement(By.xpath("//input[@id='user']"));
		email.sendKeys("sirisha.chennapati@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'login\']")).click();		
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("S.ch@143");
		WebElement login=driver.findElement(By.xpath("//*[@id=\'login-submit\']/span"));
		login.click();
		driver.findElement(By.xpath("//*[@id=\'password\']"));
		WebElement create_board=driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li/div"));
			create_board.click();
		Set <String> board_window=driver.getWindowHandles();
		for (String window : board_window) {
			driver.switchTo().window(window);			
			WebElement board_title=	driver.findElement(By.xpath("/html/body/div[3]/div/section/div/form/div[1]/label/input"));			
			board_title.sendKeys("sirisha_board");
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("/html/body/div[3]/div/section/div/form/button")));			
			driver.findElement(By.xpath("/html/body/div[3]/div/section/div/form/button")).click();
			driver.findElement(By.xpath("//*[@id=\"board\"]/div[1]/div/div[2]/div/div[2]/div[1]/a")).click();
			driver.findElement(By.linkText("Add another list")).click();
			WebElement list_A =	driver.findElement(By.xpath("//*[@id=\'board\']/div[4]/form/input"));
			list_A.click();		
			list_A.sendKeys("list A");
		driver.findElement(By.xpath("//*[@id=\'board\']/div[4]/form/div/input")).click();
		WebElement list_B =	driver.findElement(By.xpath("//*[@id=\"board\"]/div[5]/form/input"));
		list_B.sendKeys("list B");
		driver.findElement(By.xpath("//*[@id=\'board\']/div[5]/form/div/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'board\']/div[6]/form/div/a")).click();
		WebElement create_card= driver.findElement(By.xpath("//*[@id='board']/div[4]/div/div[3]/a/span[2]"));
		create_card.click();
		
		driver.findElement(By.xpath("//*[@id=\'board\']/div[4]/div/div[2]/div/div[1]/div/textarea")).sendKeys("Card_List:A" + "\n");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'board\']/div[4]/div/div[2]/div/div[2]/div[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='board']/div[4]/div/div[1]/div[2]/a")).click();
		Thread.sleep(3000);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.findElement(By.className("js-move-cards")).click();
		driver.findElement(By.xpath("//*[@id='chrome-container']/div[4]/div/div[2]/div/div/div/form/ul/li[5]/a")).click();
		WebElement n = driver.findElement(By.xpath("//*[@id=\"board\"]/div[5]/div/div[2]/a/div[3]/span"));
		Point p =n.getLocation();
		int X=p.getX();
		int Y=p.getY();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(" + X +", "+ Y +")");
		System.out.println("Coordinates are:" + X + Y);
		driver.findElement(By.xpath("//*[@id='header']/div[3]/button[3]/div/span")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div/section/div/nav/ul/li[8]/button")).click();
		driver.quit();																													
		}
	}

}

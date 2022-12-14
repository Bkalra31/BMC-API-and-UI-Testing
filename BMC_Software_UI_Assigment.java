package selenium.maven;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BMC_Software_UI_Assigment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
		searchBox.sendKeys("amazon");
		Thread.sleep(3000);
		WebElement searchBtn = driver.findElement(By.xpath("//input[@name='btnK']"));
		searchBtn.click();
		
		//Print URLS
		List<WebElement> searchResults = driver.findElements(By.xpath("//a"));
		for(WebElement result : searchResults)
		{
			System.out.println(result.getAttribute("href"));
		}
		
		//Print Titles
		List<WebElement> titlesOnpage = driver.findElements(By.xpath("//div[@id='search']//following::h3"));
		for(WebElement result : titlesOnpage)
		{
			System.out.println(result.getText());					
		}
		
		
		//Print Main Links
		List<WebElement> linksOnpage = driver.findElements(By.xpath("//div[@id='search']//following::h3//following::div/cite"));
		for(WebElement result : linksOnpage)
		{
			System.out.println(result.getText());
		}
		
		
		WebElement amazonPage = driver.findElement(By.xpath("//a[@href='https://www.amazon.in/']"));
		amazonPage.click();
		Thread.sleep(5000);
		WebElement loginSection = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(loginSection);
		
		WebElement signIn = driver.findElement(By.xpath("//a[@class='nav-action-button']//following::span[@class='nav-action-inner']"));
		signIn.click();
		WebElement emailTxtBox = driver.findElement(By.xpath("//input[@id='ap_email']"));
		emailTxtBox.sendKeys("8875344453");
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();
		WebElement pswdTxtBox = driver.findElement(By.xpath("//input[@id='ap_password']"));
		pswdTxtBox.sendKeys("N@me789puf");
		WebElement signInBtn = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		signInBtn.click();
		Thread.sleep(5000);
		WebElement drpdownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select s = new Select(drpdownElement);
		s.selectByVisibleText("Electronics");
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBar.sendKeys("dell computers");
		WebElement searchlink = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchlink.click();
		WebElement setLowPrice = driver.findElement(By.xpath("//input[@id='low-price']"));
		setLowPrice.sendKeys("30000");
		WebElement setHighPrice = driver.findElement(By.xpath("//input[@id='high-price']"));
		setHighPrice.sendKeys("50000");
		WebElement golink = driver.findElement(By.xpath("//span[@id='a-autoid-1']"));
		golink.click();
		
		int i=0;
		
		List<WebElement> price = driver.findElements(By.xpath("//span[@data-a-size='xl']"));
		for(WebElement cost : price)
		{
			String wholePrice1 = cost.getText().replaceAll("[^a-zA-Z0-9]", ""); 
			if(Integer.parseInt(wholePrice1)>30000 && Integer.parseInt(wholePrice1)<50000 ) 
			{
				
			}
			else
			{
				i++;
			}
		}
		
		WebElement gotoPage2 = driver.findElement(By.xpath("//a[@aria-label='Go to page 2']"));
		gotoPage2.click();
		Thread.sleep(5000);
		List<WebElement> priceOnPage2 = driver.findElements(By.xpath("//span[@data-a-size='xl']"));
		for(WebElement cost : priceOnPage2)
		{
			

				String wholePrice2 = cost.getText().replaceAll("[^a-zA-Z0-9]", ""); 
				if(Integer.parseInt(wholePrice2)>30000 && Integer.parseInt(wholePrice2)<50000 ) 
				{
					
				}
				else
				{
					i++;
				}
			
		}
		if(i==0)
		{
			System.out.println("Products are within the desired Range");
		}
		else
		{
			System.out.println("Products are not within the desired Range");
		}
		
		List<WebElement> ratings = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal' or contains(@aria-label, '5.0 out of 5 stars')]"));
//		List<WebElement> fiveStarRatings = ratings.stream().filter(a -> Integer.parseInt(a.getText().replaceAll("\\p{P}", ""))==5).collect(Collectors.toList());
		
		for (WebElement rating: ratings)
		{
			String s1 = rating.getAttribute("aira-label");
			System.out.println(s1);
			
//            String sexy = rating.getAttribute("aria-label") ;
//            if(sexy == "5.0 out of 5 stars")
//            {
//            	System.out.println(rating.getAttribute("href"));
//            }
			
//			String regex = rating.getText().replaceAll("\\p{P}", "");
//			int r  = Integer.parseInt(regex)/10;
//			
//			if(r==5)
//			{
//				System.out.println(rating.getAttribute("href"));
//				
//			}	
		}
		

	}

}

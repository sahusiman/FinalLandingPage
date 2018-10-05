package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjs {
public WebDriver driver;


By UserName=By.name("loginfmt");

public LandingPageObjs(WebDriver driver) {
	this.driver=driver;
}

public WebElement getUserName() {
	
	return driver.findElement(UserName);
}

By Nextbtn=By.xpath(".//*[@id='idSIButton9']");

public WebElement Nextbtnclick()
{
	
	return driver.findElement(Nextbtn);

}
By password=By.id("passwordInput");

public WebElement Password()
{
	
	return driver.findElement(password);

}

By sign=By.id("submitButton");

public WebElement signin()
{
	
	return driver.findElement(sign);

}
}

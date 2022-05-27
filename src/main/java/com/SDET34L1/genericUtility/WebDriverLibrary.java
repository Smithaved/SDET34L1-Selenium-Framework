package com.SDET34L1.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class is used to maintain webdriver common methods
 * @author USER
 *
 */
public class WebDriverLibrary {
	static WebDriverWait wait;
	static Select s1;
	static JavascriptExecutor js;
	/**
	 * This method used to launch application
	 * @param url
	 * @throws IOException
	 */
	public static void launchApplication(String url,WebDriver driver) 
	{
		driver.get(url);
	}
	/**
	 * this method is used to maximize the browser
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to Implicitly wait
	 * @param longtimeout
	 */
	public static void waitTillBrowserLaunch(long longtimeout,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to close browser
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	/**
	 * This method is used to do mouse hover action
	 * @param driver
	 * @param adm
	 */
	public static void mouseHoverOnElement(WebDriver driver, WebElement adm)
	{
		Actions act= new Actions(driver);
		act.moveToElement(adm).perform();
	}
	/**
	 * This function is used to switch the windows
	 * @param driver
	 * @param partialTitle
	 * @param longtimeout 
	 */
	public static void switchToWindow(WebDriver driver, String partialTitle)
	{
		Set<String> windows = driver.getWindowHandles();
		for(String win:windows)
		{
			driver.switchTo().window(win);
			if(driver.getTitle().contains(partialTitle))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to create the object for explicitwait
	 * @param longtimeout
	 * @param driver
	 */
	public static void driverExplicitWait(long longtimeout, WebDriver driver)
	{
		wait = new WebDriverWait(driver, longtimeout);
	}
	/**
	 * This method is used to wait till the element is clickable
	 * @param element
	 */
	public static void explicitWaitUntilElementisClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to wait till the frame is available
	 * @param index
	 */
	public static void explicitWaitUntilSwitchToFrame(int index)
	{
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	/**
	 * This method is used to select the dropdown value
	 * @param value
	 * @param element 
	 */
	public static void dropdownSelectByValue(String value, WebElement element)
	{
		s1=new Select(element);
		s1.selectByValue(value);
	}
	/**
	 * This method is used to switch to frame using index
	 * @param driver
	 * @param index
	 */
	public static void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame using name or id
	 * @param driver
	 * @param nameorid
	 */
	public static void switchToFrame(WebDriver driver,String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	/**
	 * This method is used to switch to frame using element
	 * @param driver
	 * @param element
	 */
	public static void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch back to main frame
	 * @param driver
	 */
	public static void switchBack(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to initialize the javascriptexceutor object
	 * @param driver
	 */
	public static void initializeJs(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	/**
	 * This method is used to navigate to application through javascriptexceuter
	 * @param url
	 */
	public static void navigateThroughJs(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	/**
	 * This method is used to send data to textbox
	 * @param element
	 * @param data
	 */
	public static void sendDataThroughJs(WebElement element, String data)
	{
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	/**
	 * This method is used to click on element
	 * @param element
	 */
	public static void clickThroughJs(WebElement element)
	{
		js.executeScript("arguments[0].click()",element);
	}
	/**
	 * This method is used to scroll browser to bottom
	 */
	public static void scroolToBottomHeight()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * This method is used to scroll browser to particular height
	 * @param hieght
	 */
	public static void scroolToSpecificFieldHeight(String hieght)
	{
		js.executeScript("window.scrollBy(0,"+hieght+")");
	}
	/**
	 * This method is used to scroll to element
	 * @param element
	 */
	public static void scroolTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * This method is used to take screenshots
	 * @param driver
	 * @param fileName
	 * @return 
	 */
	public static String takeScreenShorts(WebDriver driver, String fileName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dateTime=JavaLibrary.dateFormat();
		File dst=new File("./screenshot/"+fileName+"_"+dateTime+".png");
	    try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Eroor while coping the file from source to destination");
		}
	    return dst.getAbsolutePath();
	}
	/**
	 * This method is used to handle accept method of alert
	 * @param driver
	 */
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to handle dismiss method of alert
	 * @param driver
	 */
	public static void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to get text of alert
	 * @param driver
	 * @return
	 */
	public static String getAlertText(WebDriver driver)
	{
		return(driver.switchTo().alert().getText());
	}
	/**
	 * This method is used to send data to alert
	 * @param driver
	 * @param data
	 */
	public static void sendAlertData(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method is used to perform right click on element
	 * @param element
	 * @param driver
	 */
	public static void rightClick(WebElement element,WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	public static void waitTillElementVisible(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}

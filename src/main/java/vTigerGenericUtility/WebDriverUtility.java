package vTigerGenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class consists of generic methods related to webDriver actions
 * @param element
 */

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for the page load
	 * @param driver
	 */
	 public void waitForPage(WebDriver driver)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 }
	 /**
	  * This method will wait until element becomes visible
	  * @param driver
	  * @param element
	  */
	 public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 /**
	  * this method will wait until element becomes clickable
	  * @param driver
	  * @param element
	  */
	 public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	 /**
	  * This method will perform dropdown handling based on index
	  * @param element
	  * @param index
	  */
	 public void dropdownHandling(WebElement element, int index)
	 {
		 Select sl = new Select(element);
		 sl.selectByIndex(index);
	 }
	 /**
	  * This method will perform dropdown handling based on value
	  * @param element
	  * @param value
	  */
	 public void dropdownHandling(WebElement element, String value)
	 {
		 Select sl = new Select(element);
		 sl.selectByValue(value);
	 }
	 /**
	  * This method will perform fropdown handling based on visible text
	  * @param text
	  * @param element
	  */
	 public void dropdownHandling(String text, WebElement element)
	 {
		 Select sl = new Select(element);
		 sl.selectByVisibleText(text);
	 }
	 /**
	  * This method will help to move the element to particular element
	  * @param driver
	  * @param element
	  */
	  public void moveToTheElement(WebDriver driver,WebElement element)
	  {
		  Actions act = new Actions(driver);
		  act.moveToElement(element).perform();
	  }
	  /**
	   * This method will perform right click operation on webpage
	   * @param driver
	   */
	  public void rightClickOpn(WebDriver driver)
	  {
		  Actions act = new Actions(driver);
		  act.contextClick().perform();
	  }
	  /**
	   * This method will perform right click operation on particular element
	   * @param driver
	   * @param element
	   */
	  public void rightClickOpn(WebDriver driver, WebElement element)
	  {
		  Actions act = new Actions(driver);
		  act.contextClick(element).perform();
	  }
	  /**
	   * This method will perform double click operation on webpage
	   * @param driver
	   */
	  public void doubelClickOpn(WebDriver driver)
	  {
		  Actions act = new Actions(driver);
		  act.doubleClick().perform();
	  }
	  /**
	   * This method will perform double click operation on particular webElement
	   * @param driver
	   * @param element
	   */
	  public void doubleClickOpn(WebDriver driver, WebElement element)
	  {
		  Actions act = new Actions(driver);
		  act.doubleClick(element).perform();
	  }
	  /**
	   * this method will help to drag and drop elements from one place to another place
	   * @param driver
	   * @param source
	   * @param dest
	   */
	  public void dragAndDropHandling(WebDriver driver, WebElement source, WebElement dest)
	  {
		  Actions act = new Actions(driver);
		  act.dragAndDrop(source, dest).perform();
	  }
	  /**
	   * This method will take care of slider handling
	   * @param driver
	   * @param element
	   * @param x
	   * @param y
	   */
	  public void sliderHandling(WebDriver driver, WebElement element, int x, int y)
	  {
		  Actions act = new Actions(driver);
		  act.dragAndDropBy(element, x, y).perform();
	  }
	  /**
	   * This method will accept the alert
	   * @param driver
	   */
	  public void acceptAlert(WebDriver driver)
	  {
		  driver.switchTo().alert().accept();
	  }
	  /**
	   * This method will dismiss the alert
	   * @param driver
	   */
	  public void dismissAlert(WebDriver driver)
	  {
		  driver.switchTo().alert().dismiss();
	  }
	  /**
	   * This method will give you the text in alert 
	   * @param driver
	   * @return
	   */
	  public String alertText(WebDriver driver)
	  {
		  return driver.switchTo().alert().getText();
	  }
	  /**
	   * This method will handle frame based on index
	   * @param driver
	   * @param index
	   */
	  public void handleFrame(WebDriver driver, int index)
	  {
		  driver.switchTo().frame(index);
	  }
	  /**
	   * This method will handle frame based on name or id
	   * @param driver
	   * @param nameorid
	   */
	  public void handleFrame(WebDriver driver, String nameorid)
	  {
		 driver.switchTo().frame(nameorid);
	  }
	  /**
	   * This method will handle frame based on web element
	   * @param driver
	   * @param element
	   */
	  public void handleFrame(WebDriver driver, WebElement element)
	  {
		  driver.switchTo().frame(element);
	  }
	  /**
	   * This method moves the frame to default frame
	   * @param driver
	   */
	  public void handleFrame(WebDriver driver)
	  {
		  driver.switchTo().defaultContent();
	  }
	  /**
	   * this method moves to immediate parent
	   * @param driver
	   */
	  public void handlFrameParent(WebDriver driver)
	  {
		  driver.switchTo().parentFrame();
	  }
	  /**
	   * This method will take screenshot and save in it folder
	   * @param driver
	   * @param ScreenshotName
	   * @return
	   * @throws IOException
	   */
	  public String takeScreenshot(WebDriver driver, String ScreenshotName) throws IOException
	  {
		  TakesScreenshot ts = (TakesScreenshot)driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File dest = new File(".\\Screenshots\\"+ScreenshotName+".png");
		  FileUtils.copyFile(src, dest);
		  
		  return dest.getAbsolutePath();  //used for extent reports
	  }
	  /**
	   * This method will switch the window based on partial window title
	   * @param driver
	   * @param PartialWinTitle
	   */
	  public void switchWindow(WebDriver driver, String PartialWinTitle)
	  {
		  //step 1: capture all window ids
		  Set<String> winIds = driver.getWindowHandles();
		  
		  //step 2: navigate to each window
		  for(String win:winIds)
		  {
			  //step 3: switch to window and capture the title
			 String winTitle = driver.switchTo().window(win).getTitle();
			 //step 4: compare the title with required partial title
			 if(winTitle.contains(PartialWinTitle))
			 {
				 break;
			 }
		  }
	  }
	  /**
	   * This method will perfom random scroll downwards vertically
	   * @param driver
	   */
	  public void scrollAction(WebDriver driver)
	  {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)", "");
	  }
	  /**
	   * This method will scroll until the element is identified in DOM
	   * @param driver
	   * @param element
	   */
	  public void scrollAction(WebDriver driver, WebElement element)
	  {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  int y = element.getLocation().getY();
		  js.executeScript("window.scrollBy(0,"+y+")", element);
	  }
	  /**
	   * This method will handle the keyboard strokes
	   * @throws AWTException
	   */
	  public void downKeyBoardStrokeHandling() throws AWTException
	  {
		  Robot r = new Robot();
		  for(int i=0;i<=4;i++) {
		  r.keyPress(KeyEvent.VK_DOWN);
		  r.keyRelease(KeyEvent.VK_DOWN);
		  }
		  r.keyPress(KeyEvent.VK_ENTER);
		  r.keyRelease(KeyEvent.VK_ENTER);
	  }
	  /**
	   * This method will handle scrolldown action
	   * @throws AWTException
	   */
	  public void scrollDownHandling() throws AWTException
	  {
		  Robot r = new Robot();
		  for(int i=0;i<=3;i++) {
		  r.keyPress(KeyEvent.VK_PAGE_DOWN);
		  r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		  }
	  }
	  /**
	   * This method will handle scroll up handling
	   * @throws AWTException
	   */
	  public void scrollUpHandling() throws AWTException
	  {
		  Robot r = new Robot();
		  for(int i=0;i<=3;i++)
		  {
			  r.keyPress(KeyEvent.VK_PAGE_UP);
			  r.keyRelease(KeyEvent.VK_PAGE_UP);
		  }
	  }  
	  
}

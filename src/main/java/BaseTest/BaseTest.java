package BaseTest;




import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.itextpdf.xmp.options.Options;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class BaseTest {

	public static WebDriver driver;
	public static String Path= System.getProperty("user.dir");
	public static String ScreenshotPath;
	static ExtentReports extent;
	static ExtentTest test;
	public static Properties prop;
//	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
	
	
	@BeforeSuite
	public static void StartReport() throws Exception {
		
		VideoRecorder_utlity.startRecord();
		String path= System.getProperty("user.dir");
		String methodName = "Report"+"_"+BaseTest.timestamp();
		extent = new ExtentReports(path+"\\Report"+File.separator+ methodName+".html", true);
		test =extent.startTest("Results");
		System.out.println("Report started");
		extent.loadConfig(new File(Path+"\\extent-config.xml"));
		test.setDescription("<a href='"+path+"\\"+prop.getProperty("release_version")+"\\"+"automationrecordings"+"'>Automation Recording</a>");

	}
	@AfterSuite
	public static void EndReport() throws Exception {
		VideoRecorder_utlity.stopRecord();
		extent.endTest(test);
		extent.close();
	}
	
	public static String timestamp() {

		return new SimpleDateFormat("yyyy-MM-dd HH-mm").format(new Date());

	}

	public static void deleteVideos(String path) {
		File directory = new File(path);
		File[] files = directory.listFiles();
		
		for (File file : files) {
			file.delete();
		}
		
	}
	//***************************************************************************************************************************************
		// properties class file	
	public BaseTest() {
		 prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					Path + "\\src\\test\\resources\\Propertiesfile\\Config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	
	public static void Browser(String Browser, String Url) 
	{
		//Condition for chrome browser
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			String downloadFilepath = null;
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions options = new ChromeOptions();
            //options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.setAcceptInsecureCerts(true);
//            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//            DesiredCapabilities cap = new DesiredCapabilities();
//            //DesiredCapabilities cap = DesiredCapabilities.chrome();
//            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            cap.setCapability(ChromeOptions.CAPABILITY, options);
//            options.merge(cap);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		//Condition for IE browser
		else if(Browser.equalsIgnoreCase("IE")) 
		{
			 String downloadFilepath = Path+"\\downloads";
				WebDriverManager.iedriver().setup();
				InternetExplorerOptions options = new InternetExplorerOptions();
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
				capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				capabilities.setCapability("requireWindowFocus", true);
				StringSelection stringSelection = new StringSelection(downloadFilepath);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, stringSelection);
				
			driver = new InternetExplorerDriver(options);
			driver.navigate().to(prop.getProperty("URL"));
			driver.manage().window().maximize();
			
		}
		
	}
//Capture Screenshot
	public static void capturescreenshot(WebDriver driver, String Text)
			throws IOException, InterruptedException {

		
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		 ScreenshotPath = Path+"\\Screenshot"+"Screenshot_"+ timestamp() + ".png";
		ImageIO.write(screenshot.getImage(), "png",
				new File(ScreenshotPath));
		test.log(LogStatus.PASS,  Text, "<a href='"+ScreenshotPath+"'>Screenshot</a>");	
	}

	
	 
	
	
}

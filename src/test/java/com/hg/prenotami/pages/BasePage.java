package com.hg.prenotami.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static final String SPACE = " ";
    public static final String BREADCRUM = ">>>";
    public static final String START = "START";
    public static final String END = "END";

    public static final Long WAITING_TIME = 15L;

    public static final String PARENT_FILE_DIR = "/Users/hernangirardi/Downloads/Develop/prenotami/";

    @Autowired
    public WebDriver Driver;

    public static final String LOG(final String _class, String action) {
        return _class.concat(SPACE).concat(BREADCRUM).concat(SPACE).concat(action);
    }

    @PostConstruct
    public void initDriver() {
       PageFactory.initElements(Driver, this);
    }

    public WebDriver getWebDriverInstace(){
        return this.Driver;
    }
    public void Navigate(String url) {
        this.Driver.navigate().to(url);
    }


    public void takeSnapShot(WebDriver webdriver, String fileNameWithExtension) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot) webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String fileWithPath = PARENT_FILE_DIR.concat(fileNameWithExtension);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public void removeAttr(WebDriver webdriver, WebElement ele) {
        JavascriptExecutor js = ((JavascriptExecutor) webdriver);
        js.executeScript("$(\"button[type=submit]\").removeClass(\"g-recaptcha\")", ele);
    }

}

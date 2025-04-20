package utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotsUtil {
    public static String takeScreenshot(WebDriver driver, String testname){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir")+"/test-output/screenshot/"+testname+"_"+timeStamp+".png";

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);

        try{
            FileHandler.copy(src,destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshotPath;
    }
}

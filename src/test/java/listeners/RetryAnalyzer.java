package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int retryCount = 1;
    final int MAX_RETRY_COUNT = 2;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < MAX_RETRY_COUNT){
            retryCount++;
            return true;
        }else{
            return false;
        }
    }
}

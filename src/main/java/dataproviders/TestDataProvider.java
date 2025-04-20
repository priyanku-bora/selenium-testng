package dataproviders;

import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

public class TestDataProvider {
    @DataProvider(name = "loginTestData")
    public Iterator<Object[]> getData() {
        List<Object[]> data = List.of(
                new Object[] { "admin@email.com", "admin123" },
                new Object[] { "invalid", "password456" }
        );
        return data.iterator(); // Return an iterator
    }
}

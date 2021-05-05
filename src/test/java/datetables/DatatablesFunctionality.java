package datetables;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.mdbootstrap.datepicker.Datepicker;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;

public class DatatablesFunctionality {

    @BeforeSuite
    public void setup() {
        Configuration.baseUrl = "https://mdbootstrap.com/";
        Configuration.startMaximized = true;
        Configuration.browser = Browsers.CHROME;
        Selenide.open("docs/standard/data/datatables/");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void datatablesTest() {

    }

}
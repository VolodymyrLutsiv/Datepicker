package datepicker;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.mdbootstrap.datepicker.Datepicker;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class DatepickerFunctionality {

    @BeforeSuite
    public void setup() {
        Configuration.baseUrl = "https://mdbootstrap.com/";
        Configuration.startMaximized = true;
        Configuration.browser = Browsers.CHROME;
        Selenide.open("docs/standard/forms/datepicker/");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void datepickerTest() {
        LocalDate date = LocalDate.of(2077,11,16);
        Datepicker page = new Datepicker();
        page.chooseDate(date);
    }
}
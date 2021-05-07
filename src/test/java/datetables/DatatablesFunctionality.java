package datetables;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.mdbootstrap.datatables.Columns;
import com.mdbootstrap.datatables.Datatables;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DatatablesFunctionality {

    @BeforeSuite
    public void setup() {
        Configuration.baseUrl = "https://mdbootstrap.com/";
        Configuration.startMaximized = true;
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 8000;
        Selenide.open("docs/standard/data/datatables/");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void datatablesTest() {
        Datatables page = new Datatables();
        Assert.assertTrue(page.findHuman(Columns.NAME.getValue() ,"Donna Snider"));
    }
}
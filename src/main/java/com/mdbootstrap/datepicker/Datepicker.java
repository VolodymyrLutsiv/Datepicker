package com.mdbootstrap.datepicker;import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Datepicker {

    public void chooseDate(LocalDate date) {
        openModalWindow();
        pressYearButton();
        chooseYear(String.valueOf(date.getYear()));
        chooseMonth(date.format(DateTimeFormatter.ofPattern("MMM")));
        chooseDay(String.valueOf(date.getDayOfMonth()),date.format(DateTimeFormatter.ofPattern("MMM")));
        pressOkButton();
        $x("//section[@id='section-basic-example']//input[@id='exampleDatepicker1']")
                .shouldHave(attribute("value", date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }


    private void openModalWindow() {
        SelenideElement btn = $x("//button[@data-mdb-toggle='datepicker']");
        btn.click();
    }

    private void pressYearButton() {
        SelenideElement yearBtn = $x("//button[@aria-label='Choose year and month']");
        yearBtn.click();
    }

    private void chooseYear(String year) {
        ElementsCollection years = $$x("//div[@class='datepicker-cell-content datepicker-large-cell-content']");

        boolean yearIsDisplayed = false;
        while (!yearIsDisplayed) {
            yearIsDisplayed = true;
            if (!years.texts().contains(year)) {
                int currentYear = Integer.parseInt(year);
                int lastYear = Integer.parseInt(years.texts().get(years.size() - 1));
                String button = currentYear > lastYear ? "next" : "previous";
                $x("//button[@class='datepicker-" + button + "-button']").click();
                yearIsDisplayed = false;
            }
        }
        years.find(Condition.text(year)).click();
    }

    private void chooseMonth(String month) {
        ElementsCollection months = $$x("//div[@class='datepicker-cell-content datepicker-large-cell-content']");
        months.find(Condition.text(month)).click();
    }

    private void chooseDay(String day, String month) {
        ElementsCollection days = $$x("//td[contains(@aria-label,'"+ month +"')]/div[@class='datepicker-cell-content datepicker-small-cell-content']");
        days.find(Condition.text(day)).click();
    }

    private void pressOkButton() {
        $x("//button[@class='datepicker-footer-btn datepicker-ok-btn']").click();
    }
}
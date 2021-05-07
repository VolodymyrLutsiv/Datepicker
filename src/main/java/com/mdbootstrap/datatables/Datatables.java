package com.mdbootstrap.datatables;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class Datatables {

    private int listRecordsCount;
    private int recordsInPage;
    private int pageCount;


    SelenideElement table = $("div[id='datatable-advanced-data-mdb-structure']");
    SelenideElement pagination = table.$("div[class='datatable-pagination']");
    SelenideElement nextButton = pagination.$("div[class='datatable-pagination-buttons']").$("button[class*='datatable-pagination-right']");
    SelenideElement noButton = $("body[class='mdb-skin-custom modal-open']").$("div[class='modal fade show']").$("button");
    ElementsCollection records = table.$("tbody").$$("tr");
    List<String> columns = table.$("thead").$$("th").texts();

    public Datatables() {
    }


    public boolean findHuman(String column, String value) {
        getListRecordsCount();
        closeModalWindow();
        int columnIndex = columns.indexOf(column);
        for (int i = 0; i < pageCount; i++) {
            for (SelenideElement record : records) {
                if (record.$$("td").get(columnIndex).text().contains(value)) return true;
            }
            nextButton.click();
        }
        return false;
    }

    private void getListRecordsCount() {
        String[] data = pagination.$("div[class='datatable-pagination-nav']").text().split("\\s");
        this.listRecordsCount = Integer.parseInt(data[data.length - 1]);
        this.recordsInPage = Integer.parseInt(data[2]);
        this.pageCount = (int) Math.ceil(listRecordsCount / (double) recordsInPage);
    }

    private void closeModalWindow() {
        noButton.click();
    }
}
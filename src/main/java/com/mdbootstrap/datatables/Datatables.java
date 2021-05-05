package com.mdbootstrap.datatables;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Datatables {

    SelenideElement table = $x("//div[@id='datatable-advanced-data-mdb-structure']");
    SelenideElement nameColum =table.$x(".//thead[@class='datatable-header']//i[@data-mdb-sort='name']");
    SelenideElement positionColum =table.$x(".//thead[@class='datatable-header']//i[@data-mdb-sort='position']");
    SelenideElement officeColum =table.$x(".//thead[@class='datatable-header']//i[@data-mdb-sort='office']");
//    SelenideElement nameColum =table.$x(".//thead[@class='datatable-header']//i[@data-mdb-sort='age']");
//    SelenideElement nameColum =table.$x(".//thead[@class='datatable-header']//i[@data-mdb-sort='name']");
//    SelenideElement nameColum =table.$x(".//thead[@class='datatable-header']//i[@data-mdb-sort='name']");
}

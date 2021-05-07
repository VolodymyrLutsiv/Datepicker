package com.mdbootstrap.datatables;

public enum Columns {
    NAME("Name"),
    POSITION("Position"),
    OFFICE("Office"),
    AGE("Age"),
    SALARY("Salary");


    private final String value;

    Columns(String value){this.value=value;}

    public String getValue() {
        return value;
    }
}

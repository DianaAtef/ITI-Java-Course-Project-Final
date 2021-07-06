package com.example.wuzzufjavatester;

public class JobsStructure {
    private String index;
    private String columnName;
    private String columnType;

    public JobsStructure(String index,String columnName, String columnType) {
        this.index = index;
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public String getIndex() {
        return index;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnType() {
        return columnType;
    }
}

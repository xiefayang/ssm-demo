package com.study.demo.utils;

public class ExcelHeadMapper {
    private String excelName;             //Excel名
    private String entityName;            //实体类属性名
    private boolean required=false;      //值必填

    public ExcelHeadMapper(){}

    public ExcelHeadMapper(String excelName, String entityName) {
        this.excelName = excelName;
        this.entityName = entityName;
    }

    public ExcelHeadMapper(String excelName, String entityName, boolean required) {
        this.excelName = excelName;
        this.entityName = entityName;
        this.required = required;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}

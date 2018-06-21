package com.nk.chenrg.chain;

/**
 * 参数
 *
 * @author chenrg
 */
public class Param {
    public static final String STRING = "string";
    public static final String INT = "int";
    public static final String DATE = "date";
    public static final String DOUBLE = "double";
    public static final String OBJECT = "object";

    protected String name; // 参数名称
    protected boolean required; // 是否必填
    protected String type; // 参数类型
    protected int length; // 长度

    public String getName() {
        return name;
    }

    public boolean isRequired() {
        return required;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}

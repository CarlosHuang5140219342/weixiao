package com.thesisdesign.weixiao.common.enums;

import java.util.Objects;

public enum InfoTypeEnum{
    UNDEFINED(0, "undefined"),
    NAMES(1, "names"),
    TELEPHONE(2, "phone"),
    LOCATION(3, "places"),
    EMAIL(4, "e_mail"),
    ID_NUMBER(5, "id"),
    PASSPORT(6, "passport"),
    CAR(7, "car"),
    DATE(8, "date");

    private Integer code;
    private String typeName;

    InfoTypeEnum(Integer code, String typeName) {
        this.code = code;
        this.typeName = typeName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public static InfoTypeEnum getEnumTypeByTypeName(String typeName){
        for (InfoTypeEnum type : InfoTypeEnum.values()) {
            if (type.getTypeName().equals(typeName)) {
                return type;
            }
        }
        return UNDEFINED;
    }

    public static InfoTypeEnum getEnumTypeByCode(Integer code){
        for (InfoTypeEnum type : InfoTypeEnum.values()) {
            if (Objects.equals(code, type.getCode())) {
                return type;
            }
        }
        return null;
    }
}

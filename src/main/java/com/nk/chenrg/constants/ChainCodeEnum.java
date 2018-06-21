package com.nk.chenrg.constants;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenrenguang on 2018/6/21.
 */
public enum ChainCodeEnum {
    SYSTEM_ERROR("10001", "系统错误!"),
    PARAM_STYLE_ERROR("20001", "参数[{0}]格式错误,应为[{1}]型"),
    PARAM_REQUIRED_ERROR("20002", "参数[{0}]不能为空"),
    PARAM_LENGTH_ERROR("20003", "参数[{0}]长度必须小于[{1}]"),
    UNKNOWN_ERROR("30001", "未知错误!"),
    DEFAULT_SUCCESS("90001", "操作成功!");

    ChainCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private static final Map<String, ChainCodeEnum> enumInsHolder;

    static {
        final ChainCodeEnum[] errorCodelEnums = ChainCodeEnum.values();
        enumInsHolder = new HashMap<String, ChainCodeEnum>();
        for (ChainCodeEnum errorCodeEnum : errorCodelEnums) {
            enumInsHolder.put(errorCodeEnum.code, errorCodeEnum);
        }
    }

    public static String getDescByCode(String code, Object... errorParams) {
        if (StringUtils.isNotBlank(code) && MapUtils.isNotEmpty(enumInsHolder) && enumInsHolder.get(code) != null) {
            String message = enumInsHolder.get(code).getDesc();
            if (errorParams != null && errorParams.length != 0) {
                message = MessageFormat.format(message, errorParams);
            }
            return message;
        }
        return "未知错误!";
    }
}

package com.nk.chenrg.chain;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * @author chenrg
 */
public class MessageContext {

    private static ResourceBundle messages = null;

//    static {
//        Locale locale = new Locale("zh", "CN");
//        messages = ResourceBundle.getBundle("open_message", locale);
//    }

    public static String getMessage(String code, Object... params) {
        String rs = messages.getString(code);
        if (rs == null) {
            throw new IllegalArgumentException(code + "编码在open_message_zh_CN.properties中未找到");
        }
        if (params != null && params.length != 0) {
            rs = MessageFormat.format(rs, params);
        }
        return rs;
    }

}

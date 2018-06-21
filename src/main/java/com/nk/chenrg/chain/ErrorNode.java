package com.nk.chenrg.chain;

import com.nk.chenrg.Result;
import com.nk.chenrg.constants.ChainCodeEnum;
import com.nk.chenrg.frame.impl.AbstractNode;
import com.nk.chenrg.frame.valueStack.ValueStack;
import org.apache.commons.lang3.StringUtils;


/**
 * @author chenrg
 */
public class ErrorNode extends AbstractNode {
    public static final String ERROR_CODE_KEY = "error_code_key";
    public static final String ERROR_MESSAGE_KEY = "error_message_key";

    public String doNode(ValueStack valueStack) throws Exception {
        String message = valueStack.getString(ERROR_MESSAGE_KEY);
        String code = valueStack.getString(ERROR_CODE_KEY);
        if (StringUtils.isEmpty(code)) {
            code = ChainCodeEnum.SYSTEM_ERROR.getCode();
        }
        if (StringUtils.isEmpty(message)) {
            message = ChainCodeEnum.getDescByCode(code);
        }
        Result result = new Result(Result.ERROR, message, null);
        result.setExceptionCode(code);
        valueStack.setValue(NodeConstants.RESULT_KEY, result);
        return null;
    }

}

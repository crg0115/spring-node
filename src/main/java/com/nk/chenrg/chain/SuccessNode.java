package com.nk.chenrg.chain;

import com.nk.chenrg.Result;
import com.nk.chenrg.constants.ChainCodeEnum;
import com.nk.chenrg.frame.impl.AbstractNode;
import com.nk.chenrg.frame.valueStack.ValueStack;
import org.apache.commons.lang3.StringUtils;

/**
 * @author chenrg
 */
public class SuccessNode extends AbstractNode {
    public static final String SUCCESS_MESSAGE_KEY = "success_message_key";
    public static final String RETURN_DATA_KEY = "return_data_key";

    public String doNode(ValueStack valueStack) throws Exception {
        String message = valueStack.getString(SUCCESS_MESSAGE_KEY);
        if (StringUtils.isEmpty(message)) {
            message = ChainCodeEnum.DEFAULT_SUCCESS.getDesc();
        }
        Object data = valueStack.getValue(RETURN_DATA_KEY);
        Result result = new Result(Result.SUCCESS, message, data);
        valueStack.setValue(NodeConstants.RESULT_KEY, result);
        return null;
    }

}

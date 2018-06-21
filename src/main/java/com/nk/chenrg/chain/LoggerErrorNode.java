package com.nk.chenrg.chain;

import com.nk.chenrg.Result;
import com.nk.chenrg.frame.valueStack.ValueStack;
import org.apache.log4j.Logger;

/**
 * @author chenrg
 */
public class LoggerErrorNode extends ErrorNode {

    private static final Logger LOGGER = Logger.getLogger(LoggerErrorNode.class);

    @Override
    public String doNode(ValueStack valueStack) throws Exception {
        super.doNode(valueStack);
        Result result = (Result) valueStack.getValue(NodeConstants.RESULT_KEY);
        LOGGER.error(Result.getStr(result));
        return null;
    }

}

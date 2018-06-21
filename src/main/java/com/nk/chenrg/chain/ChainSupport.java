package com.nk.chenrg.chain;

import com.nk.chenrg.Result;
import com.nk.chenrg.frame.valueStack.ValueStack;
import com.nk.chenrg.frame.valueStack.ValueStackContext;

/**
 * @author chenrg
 */
public class ChainSupport {

    public static final String RESULT_KEY = "RESULT_KEY";

    public ValueStack getValueStack() {
        ValueStack valueStack = ValueStackContext.getCurrent();
        valueStack.clear();
        return valueStack;
    }

    public Result getChainResult() {
        return ValueStackContext.getCurrent().getValue(RESULT_KEY, Result.class);
    }

}

package com.nk.chenrg.provider;

import com.nk.chenrg.Result;
import com.nk.chenrg.chain.ChainSupport;
import com.nk.chenrg.frame.chain.Chain;
import com.nk.chenrg.frame.valueStack.ValueStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chenrenguang on 2018/6/21.
 */
@Component
public class TestFlowImpl extends ChainSupport {
    @Autowired
    private Chain testChain;

    public Result validate() throws Exception {
        ValueStack valueStack = getValueStack();
        valueStack.setValue("origin", 1);
        valueStack.setValue("start_date", "123");
        testChain.doChain(valueStack);
        return getChainResult();
    }
}

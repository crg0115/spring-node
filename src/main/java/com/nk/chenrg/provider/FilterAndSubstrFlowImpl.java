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
public class FilterAndSubstrFlowImpl extends ChainSupport {
    @Autowired
    private Chain filterAndSubstrChain;

    private static final String content = "我们政府真的是太好了，尼玛，你妈，我擦。";

    public Result filterAndSubstr() throws Exception {
        ValueStack valueStack = getValueStack();
        valueStack.setValue("content", content);
        filterAndSubstrChain.doChain(valueStack);
        return getChainResult();
    }
}

package com.nk.chenrg.example;

import com.nk.chenrg.chain.SuccessNode;
import com.nk.chenrg.frame.impl.AbstractNode;
import com.nk.chenrg.frame.valueStack.ValueStack;

/**
 * Created by chenrenguang on 2018/6/20.
 */
public class TestNode2 extends AbstractNode {

    public String doNode(ValueStack valueStack) throws Exception {
        Object origin = valueStack.getValue("origin");
        System.out.println("TestNode2======" + origin.toString());

        Object testnode1 = valueStack.getValue("testnode1");
        System.out.println("TestNode2======" + testnode1.toString());

        valueStack.setValue("testnode2", "88888");

        valueStack.setValue(SuccessNode.RETURN_DATA_KEY, "1234567");
        return NEXT;
    }
}

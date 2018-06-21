package com.nk.chenrg.example;

import com.nk.chenrg.frame.impl.AbstractNode;
import com.nk.chenrg.frame.valueStack.ValueStack;

/**
 * Created by chenrenguang on 2018/6/20.
 */
public class TestNode1 extends AbstractNode {

    public String doNode(ValueStack valueStack) throws Exception {
        Object origin = valueStack.getValue("origin");
        System.out.println("TestNode1======" + origin.toString());

        valueStack.setValue("testnode1", 12345);
        return NEXT;
    }
}

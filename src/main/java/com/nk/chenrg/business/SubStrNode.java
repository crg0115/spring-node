package com.nk.chenrg.business;

import com.nk.chenrg.chain.SuccessNode;
import com.nk.chenrg.constants.ChainCodeEnum;
import com.nk.chenrg.frame.impl.AbstractNode;
import com.nk.chenrg.frame.valueStack.ValueStack;

/**
 * Created by chenrenguang on 2018/6/20.
 */
public class SubStrNode extends AbstractNode {

    public String doNode(ValueStack valueStack) throws Exception {
        String content = valueStack.getString("content");
        if (content != null && !content.equals("")) {
            if (content.length() > 10) {
                System.out.println("SubStrNode前:" + content);
                String new_content = content.substring(0, 10);
                valueStack.setValue(SuccessNode.RETURN_DATA_KEY, new_content);
                valueStack.setValue(SuccessNode.SUCCESS_MESSAGE_KEY, ChainCodeEnum.DEFAULT_SUCCESS.getDesc());
                System.out.println("SubStrNode后:" + new_content);
            }
        }
        return NEXT;
    }
}

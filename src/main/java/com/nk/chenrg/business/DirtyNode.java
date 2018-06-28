package com.nk.chenrg.business;

import com.nk.chenrg.frame.impl.AbstractNode;
import com.nk.chenrg.frame.valueStack.ValueStack;

/**
 * Created by chenrenguang on 2018/6/20.
 */
public class DirtyNode extends AbstractNode {

    public String doNode(ValueStack valueStack) throws Exception {
        String content = valueStack.getString("content");
        if (content != null && !content.equals("")) {
            System.out.println("DirtyNode前:" + content);
            String new_content = content.replace("尼玛", "*").replace("你妈", "*").replace("我擦", "*");
            valueStack.setValue("content", new_content);
            System.out.println("DirtyNode后:" + new_content);
        }
        return NEXT;
    }
}

package com.nk.chenrg.frame.chain;

import com.nk.chenrg.frame.valueStack.ValueStack;

import java.util.Map;

/**
 * 责任链节点
 *
 * @author chenrg
 */
public interface Node {
    public String getName(); // 名称

    public void setName(String name);

    public String doNode(ValueStack valueStack) throws Exception;

    public Map<String, String> getForwards(); // 流向

    public void setForwards(Map<String, String> forwards);
}

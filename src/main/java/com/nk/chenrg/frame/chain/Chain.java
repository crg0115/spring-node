package com.nk.chenrg.frame.chain;


import com.nk.chenrg.frame.valueStack.ValueStack;

import java.util.Collection;

/**
 * 责任链
 *
 * @author chenrg
 */
public interface Chain {

    public void doChain(ValueStack valueStack) throws Exception;

    /**
     * 获取责任链的第一个节点
     *
     * @return
     */
    public String getFirst();

    public void setFirst(String first);

    public Collection<Node> getNodes();

    public void setNodes(Collection<Node> nodes);

}

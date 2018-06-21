package com.nk.chenrg.frame.impl;

import com.nk.chenrg.frame.chain.Chain;
import com.nk.chenrg.frame.chain.Node;
import com.nk.chenrg.frame.valueStack.ValueStack;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenrg
 */
public class DefaultChain implements Chain {
    private Collection<Node> nodes;
    private String first;
    private Map<String, Node> nodesMap;


    public void doChain(ValueStack valueStack) throws Exception {
        if (nodesMap == null) {
            initNodesMap();
        }
        Node node = nodesMap.get(getFirst());
        if (node == null) {
            throw new IllegalArgumentException("首节点(first)未找到");
        }
        while (node != null) {
            String r = node.doNode(valueStack);
            if (r == null) {
                return;
            }
            Map<String, String> fwds = node.getForwards();
            if (fwds == null) {
                break;
            }
            String fwd = fwds.get(r);
            if (fwd == null) {
                throw new IllegalArgumentException("流向(" + r + ")未找到");
            }
            node = nodesMap.get(fwd);
        }
    }

    private void initNodesMap() {
        nodesMap = new HashMap<String, Node>();
        for (Node node : nodes) {
            if (nodesMap.containsKey(node.getName())) {
                throw new IllegalArgumentException("节点(" + node.getName() + ")重复");
            }
            nodesMap.put(node.getName(), node);
        }
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Collection<Node> nodes) {
        this.nodes = nodes;
    }
}

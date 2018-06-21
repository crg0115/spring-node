package com.nk.chenrg.chain;

import com.nk.chenrg.constants.ChainCodeEnum;
import com.nk.chenrg.frame.impl.AbstractNode;
import com.nk.chenrg.frame.valueStack.ValueStack;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author chenrg
 */

public abstract class AbstractMessageNode extends AbstractNode {

    public AbstractMessageNode() {
        super();
    }

    protected String toError(ValueStack valueStack, String errorCode, Object... errorParams) {
        valueStack.setValue(ErrorNode.ERROR_CODE_KEY, errorCode);
        String message = null;
        if (ArrayUtils.isNotEmpty(errorParams)) {
            message = ChainCodeEnum.getDescByCode(errorCode, errorParams);
        }
        valueStack.setValue(ErrorNode.ERROR_MESSAGE_KEY, message);
        return ERROR;
    }

}

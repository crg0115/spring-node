package com.nk.chenrg.chain;

import com.nk.chenrg.constants.ChainCodeEnum;
import com.nk.chenrg.frame.valueStack.ValueStack;
import com.nk.chenrg.util.RoofDateUtils;
import com.nk.chenrg.frame.impl.AbstractNode;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

/**
 * 验证并加载参数
 *
 * @author chenrg
 */
public class ParamValidateNode extends AbstractMessageNode {

    protected List<Param> parameters; // 参数列表

    public String doNode(ValueStack valueStack) throws Exception {
        for (Param param : parameters) {
            Object val = null;
            val = valueStack.getValue(param.getName());
            if (val == null) {
                if (param.isRequired()) {
                    return toError(valueStack, ChainCodeEnum.PARAM_REQUIRED_ERROR.getCode(), param.getName());
                } else {
                    continue;
                }
            }
            // 字符串
            if (StringUtils.equals(Param.STRING, param.getType())) {
                val = ObjectUtils.toString(val);
            }
            // 数字
            if (StringUtils.equals(Param.INT, param.getType()) || StringUtils.equals(Param.DOUBLE, param.getType())) {
                String str = ObjectUtils.toString(val);
                if (!NumberUtils.isNumber(str)) {
                    return toError(valueStack, ChainCodeEnum.PARAM_STYLE_ERROR.getCode(), param.getName(), param.getType());
                }
                if (StringUtils.equals(Param.INT, param.getType())) {
                    val = NumberUtils.toInt(str);
                }
                if (StringUtils.equals(Param.DOUBLE, param.getType())) {
                    val = NumberUtils.toDouble(str);
                }
            }
            // 日期
            if (StringUtils.equals(Param.DATE, param.getType())) {
                String str = ObjectUtils.toString(val);
                try {
                    val = RoofDateUtils.stringToDate(str, "yyyy-MM-dd HH:mm:ss");
                } catch (Exception e) {
                    return toError(valueStack, ChainCodeEnum.PARAM_STYLE_ERROR.getCode(), param.getName(), param.getType() + " yyyy-MM-dd HH:mm:ss");
                }
            }
            valueStack.setValue(param.getName(), val);
        }
        return AbstractNode.NEXT;
    }

    public List<Param> getParameters() {
        return parameters;
    }

    public void setParameters(List<Param> parameters) {
        this.parameters = parameters;
    }

}

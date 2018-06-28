package com.nk.chenrg.chain;

import com.nk.chenrg.Result;
import com.nk.chenrg.base.BaseTest;
import com.nk.chenrg.provider.FilterAndSubstrFlowImpl;
import com.nk.chenrg.provider.TestFlowImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by chenrenguang on 2018/6/20.
 */
public class ChainTest extends BaseTest {
    @Autowired
    private TestFlowImpl testFlowImpl;

    @Autowired
    private FilterAndSubstrFlowImpl filterAndSubstrFlow;

    private static final String content = "我们政府真的是太好了，尼玛，你妈，我擦。";

    @Test
    public void testValidate() throws Exception {
        Result result = testFlowImpl.validate();
        System.out.println(result.getData());
    }

    @Test
    public void testNormal() throws Exception {
        System.out.println("转换前:" + content);
        String new_content = content.replace("尼玛", "*").replace("你妈", "*").replace("我擦", "*").replace("政府", "gov");
        System.out.println("转换后:" + new_content);

        if (new_content.length() > 10) {
            System.out.println("截取后:" + new_content.substring(0, 10));
        }
    }

    @Test
    public void testFilter() throws Exception {
        Result result = filterAndSubstrFlow.filterAndSubstr();
        System.out.println("最终输出:" + result.getData());
    }
}

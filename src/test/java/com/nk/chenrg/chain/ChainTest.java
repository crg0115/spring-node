package com.nk.chenrg.chain;

import com.nk.chenrg.Result;
import com.nk.chenrg.base.BaseTest;
import com.nk.chenrg.provider.TestFlowImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenrenguang on 2018/6/20.
 */
public class ChainTest extends BaseTest {
    @Autowired
    private TestFlowImpl testFlowImpl;

    @Test
    public void test() throws Exception {
        Result result = testFlowImpl.validate();
        System.out.println(result.getData());
    }
}

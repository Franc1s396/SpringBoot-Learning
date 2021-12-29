package org.francis.springbootspringbatch.config.errorHandling.listener;

import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

/**
 * @author Franc1s
 * @date 2021/12/29
 * @apiNote
 */
@Component
public class SkipDemoListener implements SkipListener<String,String> {
    @Override
    public void onSkipInRead(Throwable t) {

    }

    @Override
    public void onSkipInWrite(String item, Throwable t) {

    }

    @Override
    public void onSkipInProcess(String item, Throwable t) {

    }
}

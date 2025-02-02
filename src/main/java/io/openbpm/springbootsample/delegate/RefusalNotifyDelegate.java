package io.openbpm.springbootsample.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.openbpm.springbootsample.variable.VariableConstants.EMAIL;

public class RefusalNotifyDelegate implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(RefusalNotifyDelegate.class);

    @Override
    public void execute(DelegateExecution execution) throws InterruptedException {
        // 15-second delay
        Thread.sleep(10000);

        String email = (String) execution.getVariable(EMAIL);
        String processInstanceId = execution.getProcessInstanceId();

        log.info("Rejection email for {} sent to {}", processInstanceId, email);
    }
}
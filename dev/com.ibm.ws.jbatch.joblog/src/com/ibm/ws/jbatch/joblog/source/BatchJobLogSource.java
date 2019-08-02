/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.jbatch.joblog.source;

import java.util.Map;
import java.util.logging.LogRecord;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import com.ibm.websphere.ras.Tr;
import com.ibm.websphere.ras.TraceComponent;
import com.ibm.ws.jbatch.joblog.internal.impl.JobLogFormatter;
import com.ibm.ws.logging.data.BatchJobLogData;
import com.ibm.ws.logging.utils.LogFormatUtils;
import com.ibm.wsspi.collector.manager.BufferManager;
import com.ibm.wsspi.collector.manager.Source;

/**
 *
 */
@Component(property = { "service.vendor=IBM" },
           configurationPolicy = ConfigurationPolicy.IGNORE)
public class BatchJobLogSource implements Source {

    private static final TraceComponent tc = Tr.register(BatchJobLogSource.class);

    private final String sourceName = "com.ibm.ws.jbatch.joblog.source.batchjoblog";
    private final String location = "memory";
    private static String USER_AGENT_HEADER = "User-Agent";
    private final String SYSOUT = "SystemOut";
    private final String SYSERR = "SystemErr";

    private BufferManager bufferMgr = null;

    @Activate
    protected synchronized void activate(Map<String, Object> configuration) {
        if (TraceComponent.isAnyTracingEnabled() && tc.isEventEnabled()) {
            Tr.event(tc, "Activating " + this);
        }
    }

    @Deactivate
    protected void deactivate(int reason) {
        if (TraceComponent.isAnyTracingEnabled() && tc.isEventEnabled()) {
            Tr.event(tc, "Deactivating " + this, "reason = " + reason);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String getSourceName() {
        return sourceName;
    }

    /** {@inheritDoc} */
    @Override
    public String getLocation() {
        return location;
    }

    /** {@inheritDoc} */
    @Override
    @Reference(target = "(source=com.ibm.ws.jbatch.joblog.source.batchjoblog)",
               policy = ReferencePolicy.DYNAMIC,
               policyOption = ReferencePolicyOption.GREEDY)
    public void setBufferManager(BufferManager bufferMgr) {
        if (TraceComponent.isAnyTracingEnabled() && tc.isEventEnabled()) {
            Tr.event(tc, "Setting buffer manager " + this);
        }
        this.bufferMgr = bufferMgr;
    }

    /** {@inheritDoc} */
    @Override
    public void unsetBufferManager(BufferManager bufferMgr) {
        if (TraceComponent.isAnyTracingEnabled() && tc.isEventEnabled()) {
            Tr.event(tc, "Un-setting buffer manager " + this);
        }
        this.bufferMgr = null;
    }

    /**
     * requires that bufferMgr is non-null
     *
     * @param record
     */
    public void process(LogRecord record, String jobName, long instanceId, long executionId,
                        String partitionStep, int partitionNumber, String splitName, String flowName) {
        BatchJobLogData batchJobLogData = new BatchJobLogData();

        batchJobLogData.setThreadId(record.getThreadID());
        batchJobLogData.setJobName(jobName);
        batchJobLogData.setInstanceId(instanceId);
        batchJobLogData.setExecutionId(executionId);

        String msg = new JobLogFormatter().format(record);
        batchJobLogData.setMessage(msg);
        batchJobLogData.setDatetime(record.getMillis());
        batchJobLogData.setModule(record.getLoggerName());
        batchJobLogData.setSeverity(LogFormatUtils.mapLevelToType(record));
        batchJobLogData.setLoglevel(LogFormatUtils.mapLevelToRawType(record));

        if (record.getLoggerName() != null && (record.getLoggerName().equals(SYSOUT) ||
                                               record.getLoggerName().equals(SYSERR))) {
            batchJobLogData.setMethodName("");
            batchJobLogData.setClassName("");
        } else {
            batchJobLogData.setMethodName(record.getSourceMethodName());
            batchJobLogData.setClassName(record.getSourceClassName());
        }

        if (record.getParameters() != null) {
            batchJobLogData.setJobParameters(record.getParameters().toString());
        } else {
            batchJobLogData.setJobParameters(null);
        }
        batchJobLogData.setLevelValue(record.getLevel().intValue());

        //possibly null
        batchJobLogData.setPartitionStep(partitionStep);
        batchJobLogData.setPartitionNumber(partitionNumber);
        batchJobLogData.setSplitName(splitName);
        batchJobLogData.setFlowName(flowName);

        batchJobLogData.setSourceName(sourceName);

        bufferMgr.add(batchJobLogData);

        if (TraceComponent.isAnyTracingEnabled() && tc.isDebugEnabled()) {
            Tr.debug(tc, "Added a event to buffer " + batchJobLogData);
        }

    }
}

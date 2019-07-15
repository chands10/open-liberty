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
package com.ibm.ws.logging.data;

import com.ibm.ws.logging.collector.LogFieldConstants;

/**
 *
 */
public class BatchJobLogData extends GenericData {
    //TODO change fields

    private final static String[] NAMES1_1 = {
                                               LogFieldConstants.IBM_THREADID,
                                               LogFieldConstants.IBM_JOBNAME,
                                               LogFieldConstants.IBM_INSTANCEID,
                                               LogFieldConstants.IBM_EXECUTIONID,
                                               LogFieldConstants.MESSAGE,
                                               LogFieldConstants.IBM_DATETIME,
                                               LogFieldConstants.MODULE,
                                               LogFieldConstants.SEVERITY,
                                               LogFieldConstants.LOGLEVEL,
                                               LogFieldConstants.IBM_METHODNAME,
                                               LogFieldConstants.IBM_CLASSNAME,
                                               LogFieldConstants.IBM_JOBPARAMETERS,
                                               LogFieldConstants.LEVELVALUE,
                                               LogFieldConstants.IBM_PARTITIONSTEP,
                                               LogFieldConstants.IBM_PARTITIONNUMBER,
                                               LogFieldConstants.IBM_SPLITNAME,
                                               LogFieldConstants.IBM_FLOWNAME
    };

    private final static String[] NAMES = {
                                            LogFieldConstants.THREADID,
                                            LogFieldConstants.JOBNAME,
                                            LogFieldConstants.INSTANCEID,
                                            LogFieldConstants.EXECUTIONID,
                                            LogFieldConstants.MESSAGE,
                                            LogFieldConstants.DATETIME,
                                            LogFieldConstants.LOGGERNAME,
                                            LogFieldConstants.SEVERITY,
                                            LogFieldConstants.LOGLEVEL,
                                            LogFieldConstants.METHODNAME,
                                            LogFieldConstants.CLASSNAME,
                                            LogFieldConstants.JOBPARAMETERS,
                                            LogFieldConstants.LEVELVALUE,
                                            LogFieldConstants.PARTITIONSTEP,
                                            LogFieldConstants.PARTITIONNUMBER,
                                            LogFieldConstants.SPLITNAME,
                                            LogFieldConstants.FLOWNAME

    };

    public BatchJobLogData() {
        super(14);
    }

    private void setPair(int index, String s) {
        setPair(index, NAMES1_1[index], s);
    }

    private void setPair(int index, int i) {
        setPair(index, NAMES1_1[index], i);
    }

    private void setPair(int index, long l) {
        setPair(index, NAMES1_1[index], l);
    }

    public void setThreadId(int i) {
        setPair(0, i);
    }

    public void setJobName(String s) {
        setPair(1, s);
    }

    public void setInstanceId(long l) {
        setPair(2, l);
    }

    public void setExecutionId(long l) {
        setPair(3, l);
    }

    public void setMessage(String s) {
        setPair(4, s);
    }

    public void setDatetime(long l) {
        setPair(5, l);
    }

    public void setModule(String s) {
        setPair(6, s);
    }

    public void setSeverity(String s) {
        setPair(7, s);
    }

    public void setLoglevel(String s) {
        setPair(8, s);
    }

    public void setMethodName(String s) {
        setPair(9, s);
    }

    public void setClassName(String s) {
        setPair(10, s);
    }

    public void setJobParameters(String s) {
        setPair(11, s);
    }

    public void setLevelValue(int i) {
        setPair(12, i);
    }

    public void setPartitionStep(String s) {
        setPair(13, s);
    }

    public void setPartitionNumber(int i) {
        setPair(14, i);
    }

    public void setSplitName(String s) {
        setPair(15, s);
    }

    public void setFlowName(String s) {
        setPair(16, s);
    }

    public int getThreadId() {
        return getIntValue(0);
    }

    public String getJobName() {
        return getStringValue(1);
    }

    public long getInstanceId() {
        return getLongValue(2);
    }

    public long getExecutionId() {
        return getLongValue(3);
    }

    public String getMessage() {
        return getStringValue(4);
    }

    public long getDatetime() {
        return getLongValue(5);
    }

    public String getModule() {
        return getStringValue(6);
    }

    public String getSeverity() {
        return getStringValue(7);
    }

    public String getLoglevel() {
        return getStringValue(8);
    }

    public String getMethodName() {
        return getStringValue(9);
    }

    public String getClassName() {
        return getStringValue(10);
    }

    public String getJobParameters() {
        return getStringValue(11);
    }

    public int getLevelValue() {
        return getIntValue(12);
    }

    public String getPartitionStep() {
        return getStringValue(13);
    }

    public int getPartitionNumber() {
        return getIntValue(14);
    }

    public String getSplitName() {
        return getStringValue(15);
    }

    public String getFlowName() {
        return getStringValue(16);
    }

    public String getThreadIdKey() {
        return NAMES[0];
    }

    public String getJobNameKey() {
        return NAMES[1];
    }

    public String getInstanceIdKey() {
        return NAMES[2];
    }

    public String getExecutionIdKey() {
        return NAMES[3];
    }

    public String getMessageKey() {
        return NAMES[4];
    }

    public String getDatetimeKey() {
        return NAMES[5];
    }

    public String getModuleKey() {
        return NAMES[6];
    }

    public String getSeverityKey() {
        return NAMES[7];
    }

    public String getLoglevelKey() {
        return NAMES[8];
    }

    public String getMethodNameKey() {
        return NAMES[9];
    }

    public String getClassNameKey() {
        return NAMES[10];
    }

    public String getJobParametersKey() {
        return NAMES[11];
    }

    public String getLevelValueKey() {
        return NAMES[12];
    }

    public String getPartitionStepKey() {
        return NAMES[13];
    }

    public String getPartitionNumberKey() {
        return NAMES[14];
    }

    public String getSplitNameKey() {
        return NAMES[15];
    }

    public String getFlowNameKey() {
        return NAMES[16];
    }

    public String getThreadIdKey1_1() {
        return NAMES1_1[0];
    }

    public String getJobNameKey1_1() {
        return NAMES1_1[1];
    }

    public String getInstanceIdKey1_1() {
        return NAMES1_1[2];
    }

    public String getExecutionIdKey1_1() {
        return NAMES1_1[3];
    }

    public String getMessageKey1_1() {
        return NAMES1_1[4];
    }

    public String getDatetimeKey1_1() {
        return NAMES1_1[5];
    }

    public String getModuleKey1_1() {
        return NAMES1_1[6];
    }

    public String getSeverityKey1_1() {
        return NAMES1_1[7];
    }

    public String getLoglevelKey1_1() {
        return NAMES1_1[8];
    }

    public String getMethodNameKey1_1() {
        return NAMES1_1[9];
    }

    public String getClassNameKey1_1() {
        return NAMES1_1[10];
    }

    public String getJobParametersKey1_1() {
        return NAMES1_1[11];
    }

    public String getLevelValueKey1_1() {
        return NAMES1_1[12];
    }

    public String getPartitionStepKey1_1() {
        return NAMES1_1[13];
    }

    public String getPartitionNumberKey1_1() {
        return NAMES1_1[14];
    }

    public String getSplitNameKey1_1() {
        return NAMES1_1[15];
    }

    public String getFlowNameKey1_1() {
        return NAMES1_1[16];
    }

}

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
                                               LogFieldConstants.IBM_BATCHMESSAGE,
                                               LogFieldConstants.IBM_DATETIME
    };

    private final static String[] NAMES = {
                                            LogFieldConstants.THREADID,
                                            LogFieldConstants.BATCHMESSAGE,
                                            LogFieldConstants.DATETIME
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

    public void setThreadID(int i) {
        setPair(0, i);
    }

    public void setBatchMessage(String s) {
        setPair(1, s);
    }

    public void setDatetime(long l) {
        setPair(2, l);
    }

    public long getThreadID() {
        return getIntValue(0);
    }

    public String getBatchMessage() {
        return getStringValue(1);
    }

    public long getDatetime() {
        return getLongValue(2);
    }

    public String getThreadIDKey() {
        return NAMES[0];
    }

    public String getBatchMessageKey() {
        return NAMES[1];
    }

    public String getDatetimeKey() {
        return NAMES[2];
    }

    public String getThreadIDKey1_1() {
        return NAMES1_1[0];
    }

    public String getBatchMessageKey1_1() {
        return NAMES1_1[1];
    }

    public String getDatetimeKey1_1() {
        return NAMES1_1[2];
    }

}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.metrics.core.metric;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InvocationMetric {
  private final String operationName;

  @JsonIgnore
  private final String prefix;

  private final long waitInQueue;

  public String getOperationName() {
    return operationName;
  }

  public String getPrefix() {
    return prefix;
  }

  public long getWaitInQueue() {
    return waitInQueue;
  }

  public InvocationMetric(String operationName, String prefix, long waitInQueue) {
    this.operationName = operationName;
    this.prefix = prefix;
    this.waitInQueue = waitInQueue;
  }
}
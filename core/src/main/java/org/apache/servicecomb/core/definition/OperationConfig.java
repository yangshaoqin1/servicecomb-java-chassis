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
package org.apache.servicecomb.core.definition;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.servicecomb.config.inject.InjectProperties;
import org.apache.servicecomb.config.inject.InjectProperty;

@InjectProperties(prefix = "servicecomb")
public class OperationConfig {
  public static final List<String> CONSUMER_OP_ANY_PRIORITY = Arrays.asList(
      "${service}.${schema}.${operation}",
      "${service}.${schema}",
      "${service}");

  public static final List<String> PRODUCER_OP_ANY_PRIORITY = Arrays.asList(
      "${schema}.${operation}",
      "${schema}");

  public static final List<String> CONSUMER_OP_PRIORITY = Arrays.asList(
      ".${service}.${schema}.${operation}",
      ".${service}.${schema}",
      ".${service}",
      "");

  public static final List<String> PRODUCER_OP_PRIORITY = Arrays.asList(
      ".${schema}.${operation}",
      ".${schema}",
      "");

  @InjectProperty(keys = "${consumer-producer}.invocation.slow.enabled${op-priority}", defaultValue = "false")
  private boolean slowInvocationEnabled;

  @InjectProperty(keys = {"${consumer-producer}.invocation.slow.msTime${op-priority}"}, defaultValue = "1000")
  private long msSlowInvocation;

  private long nanoSlowInvocation;

  public boolean isSlowInvocationEnabled() {
    return slowInvocationEnabled;
  }

  public void setSlowInvocationEnabled(boolean slowInvocationEnabled) {
    this.slowInvocationEnabled = slowInvocationEnabled;
  }

  public long getMsSlowInvocation() {
    return msSlowInvocation;
  }

  public void setMsSlowInvocation(long msSlowInvocation) {
    this.msSlowInvocation = msSlowInvocation;
    this.nanoSlowInvocation = TimeUnit.MILLISECONDS.toNanos(msSlowInvocation);
  }

  public long getNanoSlowInvocation() {
    return nanoSlowInvocation;
  }
}

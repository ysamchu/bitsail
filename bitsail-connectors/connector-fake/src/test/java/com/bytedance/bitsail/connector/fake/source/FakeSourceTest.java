/*
 * Copyright 2022-2023 Bytedance Ltd. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytedance.bitsail.connector.fake.source;

import com.bytedance.bitsail.common.configuration.BitSailConfiguration;
import com.bytedance.bitsail.connector.fake.option.FakeReaderOptions;
import com.bytedance.bitsail.test.connector.test.EmbeddedFlinkCluster;
import com.bytedance.bitsail.test.connector.test.utils.JobConfUtils;

import org.junit.Test;

public class FakeSourceTest {

  @Test
  public void testUnifiedFakeSource() throws Exception {
    BitSailConfiguration jobConf = JobConfUtils.fromClasspath("bitsail_connector_unified_conf.json");
    jobConf.set(FakeReaderOptions.TOTAL_COUNT, 10);
    jobConf.set(FakeReaderOptions.RATE, 1000);
    EmbeddedFlinkCluster.submitJob(jobConf);
  }
}
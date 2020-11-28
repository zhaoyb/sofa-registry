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
package com.alipay.sofa.registry.common.model.metaserver.inter.communicate;

import com.alipay.sofa.registry.common.model.metaserver.nodes.MetaNode;
import com.alipay.sofa.registry.common.model.metaserver.nodes.SessionNode;
import com.alipay.sofa.registry.common.model.slot.SlotTable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen.zhu
 * <p>
 * Nov 27, 2020
 */
public class DataHeartBeatResponse extends BaseHeartBeatResponse {

    private final List<SessionNode> sessionNodes;

    public DataHeartBeatResponse(long metaServerEpoch, SlotTable slotTable,
                                 List<MetaNode> metaNodes, List<SessionNode> sessionNodes) {
        super(metaServerEpoch, slotTable, metaNodes);
        this.sessionNodes = Collections.unmodifiableList(sessionNodes);
    }

    public List<SessionNode> getSessionNodes() {
        return sessionNodes;
    }

    public Map<String, SessionNode> getSessionNodesMap() {
        final Map<String, SessionNode> m = new HashMap<>(sessionNodes.size());
        sessionNodes.forEach(s -> m.put(s.getIp(), s));
        return m;
    }
}

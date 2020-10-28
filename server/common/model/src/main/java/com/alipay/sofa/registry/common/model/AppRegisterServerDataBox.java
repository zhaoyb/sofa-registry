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
package com.alipay.sofa.registry.common.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sofa.registry.common.model.store.WordCache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaojian.xj
 * @version $Id: AppRegisterServerDataBox.java, v 0.1 2020年11月12日 11:14 xiaojian.xj Exp $
 */
public class AppRegisterServerDataBox implements Serializable {
    private static final long      serialVersionUID = -3615677271684611262L;

    /** revision */
    private String                 revision;

    /** ip:port */
    private String                 url;

    /** baseParams */
    private List<ParamInfo>        baseParams;

    /** */
    private List<ServiceParamInfo> serviceParams;

    public String extract() {
        //todo
        return "";
    }

    /**
     * Getter method for property <tt>revision</tt>.
     *
     * @return property value of revision
     */
    public String getRevision() {
        return revision;
    }

    /**
     * Setter method for property <tt>revision</tt>.
     *
     * @param revision value to be assigned to property revision
     */
    public void setRevision(String revision) {
        this.revision = WordCache.getInstance().getWordCache(revision);
    }

    /**
     * Getter method for property <tt>url</tt>.
     *
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     *
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter method for property <tt>baseParams</tt>.
     *
     * @return property value of baseParams
     */
    public List<ParamInfo> getBaseParams() {
        return baseParams;
    }

    /**
     * Setter method for property <tt>baseParams</tt>.
     *
     * @param baseParams value to be assigned to property baseParams
     */
    public void setBaseParams(String baseParams) {
        JSONObject baseParam = JSON.parseObject(baseParams);
        List<ParamInfo> paramInfos = new ArrayList<>();
        for (String key : baseParam.keySet()) {
            ParamInfo param = new ParamInfo();
            param.setKey(key);
            param.setValue(baseParam.getString(key));
            paramInfos.add(param);
        }
        this.baseParams = paramInfos;
    }

    /**
     * Getter method for property <tt>serviceParams</tt>.
     *
     * @return property value of serviceParams
     */
    public List<ServiceParamInfo> getServiceParams() {
        return serviceParams;
    }

    /**
     * Setter method for property <tt>serviceParams</tt>.
     *
     * @param serviceParams value to be assigned to property serviceParams
     */
    public void setServiceParams(String serviceParams) {
        JSONObject serviceParam = JSON.parseObject(serviceParams);
        List<ServiceParamInfo> paramInfos = new ArrayList<>();
        for (String key : serviceParam.keySet()) {
            ServiceParamInfo param = new ServiceParamInfo();
            param.setKey(key);
            param.setValue(serviceParam.getString(key));
            paramInfos.add(param);
        }

        this.serviceParams = paramInfos;
    }

    public class ServiceParamInfo {

        private String serviceName;

        private String key;

        private String value;

        /**
         * Getter method for property <tt>serviceName</tt>.
         *
         * @return property value of serviceName
         */
        public String getServiceName() {
            return serviceName;
        }

        /**
         * Setter method for property <tt>serviceName</tt>.
         *
         * @param serviceName value to be assigned to property serviceName
         */
        public void setServiceName(String serviceName) {
            this.serviceName = WordCache.getInstance().getWordCache(serviceName);
        }

        /**
         * Getter method for property <tt>key</tt>.
         *
         * @return property value of key
         */
        public String getKey() {
            return key;
        }

        /**
         * Setter method for property <tt>key</tt>.
         *
         * @param key value to be assigned to property key
         */
        public void setKey(String key) {
            this.key = WordCache.getInstance().getWordCache(key);
        }

        /**
         * Getter method for property <tt>value</tt>.
         *
         * @return property value of value
         */
        public String getValue() {
            return value;
        }

        /**
         * Setter method for property <tt>value</tt>.
         *
         * @param value value to be assigned to property value
         */
        public void setValue(String value) {
            this.value = WordCache.getInstance().getWordCache(value);
        }
    }

    public class ParamInfo {

        private String key;

        private String value;

        /**
         * Getter method for property <tt>key</tt>.
         *
         * @return property value of key
         */
        public String getKey() {
            return key;
        }

        /**
         * Setter method for property <tt>key</tt>.
         *
         * @param key value to be assigned to property key
         */
        public void setKey(String key) {
            this.key = WordCache.getInstance().getWordCache(key);
        }

        /**
         * Getter method for property <tt>value</tt>.
         *
         * @return property value of value
         */
        public String getValue() {
            return value;
        }

        /**
         * Setter method for property <tt>value</tt>.
         *
         * @param value value to be assigned to property value
         */
        public void setValue(String value) {
            this.value = WordCache.getInstance().getWordCache(value);
        }
    }

}
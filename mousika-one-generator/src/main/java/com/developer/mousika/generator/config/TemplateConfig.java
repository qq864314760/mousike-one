/*
 * Copyright (c) 2011-2019, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.developer.mousika.generator.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 模板路径配置项
 *
 * @author tzg hubin
 * @since 2017-06-17
 */
@Data
@Accessors(chain = true)
public class TemplateConfig {

    @Getter(AccessLevel.NONE)
    private String entity = ConstVal.TEMPLATE_ENTITY_JAVA;

    private String entityKt = ConstVal.TEMPLATE_ENTITY_KT;

    private String service = ConstVal.TEMPLATE_SERVICE;

    private String serviceImpl = ConstVal.TEMPLATE_SERVICE_IMPL;

    private String mapper = ConstVal.TEMPLATE_MAPPER;

    private String xml = ConstVal.TEMPLATE_XML;

    private String controller = ConstVal.TEMPLATE_CONTROLLER;

    public String getEntity(boolean kotlin) {
        return kotlin ? entityKt : entity;
    }

    /**+S+新增++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    private String dto = ConstVal.TEMPLATE_DTO_JAVA;
    private String mapStruct = ConstVal.TEMPLATE_MAP_STRUCT_JAVA;
    private String resource = ConstVal.TEMPLATE_RESOURCE_JAVA;

    private String angluarEntity = ConstVal.TEMPLATE_ANGLUAR_ENTITY_TS;
    private String angluarHttpService = ConstVal.TEMPLATE_ANGLUAR_HTTP_SERVICE_TS;
    /**+E+新增++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}

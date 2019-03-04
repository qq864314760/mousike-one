/*
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.developer.mousike.config;

import com.baomidou.mybatisplus.generator.config.TemplateConfig;

/**
 * <p>
 * 模板路径配置项
 * </p>
 *
 * @author tzg hubin
 * @since 2017-06-17
 */
public class TemplateConfigs extends TemplateConfig {

    private String dto = ConstVals.TEMPLATE_DTO_JAVA;

    private String mapStruct = ConstVals.TEMPLATE_MAP_STRUCT_JAVA;

    public String getDto() {
        return dto;
    }

    public TemplateConfigs setDto(String dto) {
        this.dto = dto;
        return this;
    }

    public String getMapStruct() {
        return mapStruct;
    }

    public TemplateConfigs setMapStruct(String mapStruct) {
        this.mapStruct = mapStruct;
        return this;
    }
}

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
package com.developer.mousika.config;


import com.baomidou.mybatisplus.generator.config.PackageConfig;

/**
 * <p>
 * 跟包相关的配置项
 *
 * @author YangHu, tangguo, hubin
 * @since 2016-08-30
 */

public class PackageConfigs extends PackageConfig {

    /**
     * DTO包名
     */
    private String dto = "dto";
    /**
     * mapStruct包名
     */
    private String mapStruct = "mapstruct";
    /**
     * 生成rest资源
     */
    private String resource = "resource";

    public String getDto() {
        return dto;
    }

    public PackageConfigs setDto(String dto) {
        this.dto = dto;
        return this;
    }

    public String getMapStruct() {
        return mapStruct;
    }

    public PackageConfigs setMapStruct(String mapStruct) {
        this.mapStruct = mapStruct;
        return this;
    }

    public String getResource() {
        return resource;
    }

    public PackageConfigs setResource(String resource) {
        this.resource = resource;
        return this;
    }
}

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

import com.baomidou.mybatisplus.generator.config.StrategyConfig;

/**
 * <p>
 * 策略配置项
 * </p>
 *
 * @author YangHu, tangguo, hubin
 * @since 2016/8/30
 */
public class StrategyConfigs extends StrategyConfig {
    /**
     * 资源访问名
     */
    private String resource;

    /**
     * 自定义继承的DTO类全称，带包名
     */
    private String superDtoClass;
    /**
     * 自定义继承的MapStruct类全称，带包名
     */
    private String superMapStructClass;

    public String getResource() {
        return resource;
    }

    public StrategyConfigs setResource(String resource) {
        this.resource = resource;
        return this;
    }

    public String getSuperDtoClass() {
        return superDtoClass;
    }

    public StrategyConfigs setSuperDtoClass(String superDtoClass) {
        this.superDtoClass = superDtoClass;
        return this;
    }

    public String getSuperMapStructClass() {
        return superMapStructClass;
    }

    public StrategyConfigs setSuperMapStructClass(String superMapStructClass) {
        this.superMapStructClass = superMapStructClass;
        return this;
    }
}

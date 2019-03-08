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

import com.baomidou.mybatisplus.generator.config.ConstVal;

/**
 * <p>
 * 定义常量
 * </p>
 *
 * @author YangHu, tangguo, hubin
 * @since 2016-08-31
 */
public interface ConstVals extends ConstVal {
    String TEMPLATE_DTO_JAVA = "/templates/dto.java";
    String TEMPLATE_MAP_STRUCT_JAVA = "/templates/mapStruct.java";

    String TEMPLATE_ANGLUAR_ENTITY_TS = "/templates/entity.ts";
    String TEMPLATE_ANGLUAR_HTTP_SERVICE_TS = "/templates/httpService.ts";
}

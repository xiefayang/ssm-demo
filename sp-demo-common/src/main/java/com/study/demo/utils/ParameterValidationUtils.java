/*
 * *************************************************************************************
 *
 *   Project:        ZXQ
 *
 *   Copyright ©     2014-2017 Banma Technologies Co.,Ltd
 *                   All rights reserved.
 *
 *   This software is supplied only under the terms of a license agreement,
 *   nondisclosure agreement or other written agreement with Banma Technologies
 *   Co.,Ltd. Use, redistribution or other disclosure of any parts of this
 *   software is prohibited except in accordance with the terms of such written
 *   agreement with Banma Technologies Co.,Ltd. This software is confidential
 *   and proprietary information of Banma Technologies Co.,Ltd.
 *
 * *************************************************************************************
 *
 *   Class Name: com.zxq.iov.cloud.sp.uom.common.util.ParameterValidationUtils
 *
 *   General Description:
 *
 *   Revision History:
 *                            Modification
 *    Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 *    *********************   ************    **********     *****************************
 *    chm141593@alibaba-inc.com                   2017-11-30
 *
 * **************************************************************************************
 */

package com.study.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * 参数校验工具类
 *
 * @author chm141593@alibaba-inc.com
 * @date 2017-06-30 14:23
 */

/**
 * List<ImmutablePair<String, Object>> paramPairs = Arrays.asList(
 new ImmutablePair<String, Object>("businessTitle", preUOParam.getBusinessTitle()),
 new ImmutablePair<String, Object>("buyerId", preUOParam.getBuyerId()),
 new ImmutablePair<String, Object>("statusId", preUOParam.getStatusId()),
 new ImmutablePair<String, Object>("businessCatId", preUOParam.getBusinessCatId()));
 ParameterValidationUtils.checkEmptyParams(paramPairs);
 */
public class ParameterValidationUtils {
    public static void checkEmptyParam(ImmutablePair<String, Object> paramPair) throws
            ApiException {
        String paramName = paramPair.getKey();
        Object paramValue = paramPair.getValue();
        if (paramValue == null) {
            throw new ApiException(PARAMS_NOT_EXIST.getCode(), paramName + PARAMS_NOT_EXIST.getMessage());
        } else if (paramValue instanceof String) {
            if (StringUtils.isBlank((String) paramValue)) {
                throw new ApiException(PARAMS_NOT_EXIST.getCode(), paramName + PARAMS_NOT_EXIST.getMessage());
            }
        } else if (paramValue.getClass().isArray()) {
            if (Array.getLength(paramValue) == 0) {
                throw new ApiException(PARAMS_NOT_EXIST.getCode(), paramName + PARAMS_NOT_EXIST.getMessage());
            }
        } else if (paramValue instanceof Collection) {
            Collection collectionValue = (Collection) paramValue;
            if (collectionValue.isEmpty()) {
                throw new ApiException(PARAMS_NOT_EXIST.getCode(), paramName + PARAMS_NOT_EXIST.getMessage());
            }
        } else if (paramValue instanceof Map) {
            Map mapValue = (Map) paramValue;
            if (mapValue.isEmpty()) {
                throw new ApiException(PARAMS_NOT_EXIST.getCode(), paramName + PARAMS_NOT_EXIST.getMessage());
            }
        }
    }

    public static void checkEmptyParams(List<ImmutablePair<String, Object>> paramPairs) throws
            ApiException {
        if (paramPairs != null && !paramPairs.isEmpty()) {
            for (ImmutablePair<String, Object> paramPair : paramPairs) {
                checkEmptyParam(paramPair);
            }
        }
    }

}

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
 *   Class Name: com.zxq.iov.cloud.sp.uom.common.constant.NullSpecKeyEnum
 *
 *   General Description:
 *
 *   Revision History:
 *                            Modification
 *    Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 *    *********************   ************    **********     *****************************
 *    ChenHuiMin@saicmotor.com                   2017-05-25
 *
 * **************************************************************************************
 */

package com.zxq.iov.cloud.sp.uom.common.constant;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by ChenHuiMin@saicmotor.com on 2017/2/3.
 */
public enum NullSpecKeyEnum {
    //餐饮订单不返回规格名称定义
    CATERING_RESERVE_SP_BRAND("1401000", "SP品牌信息", "140000001"),
    CATERING_QUEUE_SP_BRAND("1402000", "SP品牌信息", "140000001");

    private final String busineesCatId;
    private final String specName;
    private final String specCode;

    NullSpecKeyEnum(String busineesCatId, String specName, String specCode) {
        this.busineesCatId = busineesCatId;
        this.specName = specName;
        this.specCode = specCode;
    }

    public static NullSpecKeyEnum fromBusineesCatIdAndSpecCode(String busineesCatId, String specCode) {
        NullSpecKeyEnum result = null;
        if (StringUtils.isNotBlank(busineesCatId) && StringUtils.isNotBlank(specCode)) {
            for (NullSpecKeyEnum nullSpecKeyEnum : values()) {
                if (busineesCatId.equals(nullSpecKeyEnum.busineesCatId) && specCode.equals(nullSpecKeyEnum
                        .specCode)) {
                    result = nullSpecKeyEnum;
                    break;
                }
            }
        }
        return result;
    }

    public static NullSpecKeyEnum fromBusineesCatIdAndSpecName(String busineesCatId, String specName) {
        NullSpecKeyEnum result = null;
        if (StringUtils.isNotBlank(busineesCatId) && StringUtils.isNotBlank(specName)) {
            for (NullSpecKeyEnum nullSpecKeyEnum : values()) {
                if (busineesCatId.equals(nullSpecKeyEnum.busineesCatId) && specName.equals(nullSpecKeyEnum
                        .specName)) {
                    result = nullSpecKeyEnum;
                    break;
                }
            }
        }
        return result;
    }

    public String getBusineesCatId() {
        return this.busineesCatId;
    }

    public String getSpecName() {
        return this.specName;
    }

    public String getSpecCode() {
        return this.specCode;
    }
}

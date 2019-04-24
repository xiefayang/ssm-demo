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
 *   Class Name: com.zxq.iov.cloud.sp.uom.api.constant.BusinessCategory
 *
 *   General Description:
 *
 *   Revision History:
 *                            Modification
 *    Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 *    *********************   ************    **********     *****************************
 *    ChenHuiMin@saicmotor.com                   2017-02-06
 *
 * **************************************************************************************
 */

package com.study.demo.utils;

/**
 * @author chenhuimin
 */
public enum BusinessCategory {
    PARKING_ETCP("0510000"),
    PARKING_RESERVATION("0500000"),
    PETROL_OIL("1110000"),
    PETROL_NON_OIL("1111000"),
    INSURANCE_ANT_FINANCIAL("1010000"),
    INSURANCE_SAICMOTOR("1011000"),
    CATERING_PARENT("14"),
    CATERING_RESERVE("1401000"),
    CATERING_QUEUE("1402000"),
    POWER_PARENT("13"),
    //安悦充电类型
    POWER_ANYUE("1301000"),
    //森通充电类型
    POWER_SENTONG("1302000"),
    //星星充电类型
    POWER_XINGXING("1303000"),
    //特来电充电类型
    POWER_TELAIDIAN("1304000"),
    //依威充电充电类型
    POWER_YIWEI("1305000"),
    //救援类型
    RESCUE("0300000"),
    //维保类型
    AS("0600000"),
    //个人中心流量类型
    DATAFLOW_PERSONALCENTER("01"),
    //车钱包流量类型
    DATAFLOW_CARWALLET("12");

    private final String cateId;

    BusinessCategory(String cateId) {
        this.cateId = cateId;
    }

    public static BusinessCategory fromBusineesCatId(String busineesCatId) {
        BusinessCategory result = null;
        for (BusinessCategory businessCategory : values()) {
            if (busineesCatId.equals(businessCategory.getCateId())) {
                result = businessCategory;
                break;
            }
        }
        return result;
    }

    public String getCateId() {
        return cateId;
    }
}

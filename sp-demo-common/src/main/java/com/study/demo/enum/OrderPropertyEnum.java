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
 *   Class Name: com.zxq.iov.cloud.sp.uom.common.constant.OrderPropertyEnum
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

/**
 * Created by ChenHuiMin@saicmotor.com on 2017/2/3.
 */
public enum OrderPropertyEnum {
    //餐饮订单不返回规格名称定义
    ORDER_SHOW(1, "订单显示"),
    ORDER_NOT_SHOW(0, "订单不显示"),
    ORDER_FREE(1, "订单免费"),
    ORDER_NOT_FREE(0, "订单付费");


    private final Integer value;
    private final String name;

    OrderPropertyEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

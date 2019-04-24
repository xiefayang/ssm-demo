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
 *   Class Name: com.zxq.iov.cloud.sp.uom.common.constant.MapOrderTypeEnum
 *
 *   General Description:
 *
 *   Revision History:
 *                            Modification
 *    Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 *    *********************   ************    **********     *****************************
 *    chm141593@alibaba-inc.com                   2017-10-20
 *
 * **************************************************************************************
 */

package com.zxq.iov.cloud.sp.uom.common.constant;

/**
 * 地图订单类型枚举
 *
 * @author ChenHuiMin@saicmotor.com
 * @date 2017-05-26 17:53
 */

public enum MapOrderTypeEnum {
    OTHER(0, "其他"),
    HOME(1, "回家"),
    OFFICE(2, "上班"),
    FREQUENT_PLACE(3, "到常去地点"),
    ZEBRA_ORDER(4, "斑马订单"),
    ZEBRA_ACTIVITY(5, "斑马活动"),
    MOVIE(6, "看电影"),
    AIR_PORT(7, "去机场"),
    KTV(8, "KTV"),
    TRAVEL(9, "TRAVEL"),
    PARKING(10, "停车"),
    REPIAR(11, "维保"),
    RESTAURANT(12, "餐饮");
    /**
     * 类型编码
     */
    private final int code;
    /**
     * 类型名称
     */
    private final String name;


    private MapOrderTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}

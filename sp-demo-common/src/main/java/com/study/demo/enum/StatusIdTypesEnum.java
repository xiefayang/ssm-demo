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
 *   Class Name: com.zxq.iov.cloud.sp.uom.common.constants.StatusIdTypesEnum
 *
 *   General Description:
 *
 *   Revision History:
 *                            Modification
 *    Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 *    *********************   *************    ***********     ******************************
 *    wanyang                  2017-01-12
 *
 * **************************************************************************************
 */

package com.zxq.iov.cloud.sp.uom.common.constant;

public enum StatusIdTypesEnum {

    /**
     * 待确认 to be confirm
     */
    TBC("1001"),

    /**
     * 已预约
     */
    RESERVED("1002"),

    /**
     * 处理中
     */
    PROCESS("1003"),

    /**
     * 待支付 to be pay
     */
    TBP("1004"),

    /**
     * 已完成
     */
    FINISH("1005"),

    /**
     * 订单关闭
     */
    ERRORCLOSED("1006"),

    /**
     * 未完成，包含1001,1002,1003,1004
     */
    TBF("1010");

    private String code;

    private StatusIdTypesEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static boolean isSatusIdValid(String code) {
        for (StatusIdTypesEnum type : StatusIdTypesEnum.values()) {
            if (type.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}

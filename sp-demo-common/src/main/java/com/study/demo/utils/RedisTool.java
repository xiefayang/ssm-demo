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
 *   Class Name: com.zxq.iov.cloud.sp.uom.common.util.RedisTool
 *
 *   General Description:
 *
 *   Revision History:
 *                            Modification
 *    Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 *    *********************   ************    **********     *****************************
 *    chm141593@alibaba-inc.com                   2017-12-05
 *
 * **************************************************************************************
 */

package com.study.demo.utils;

import com.saicmotor.telematics.framework.core.redis.JedisClusterUtils;

import java.util.Collections;

/**
 * Redis工具类
 *
 * @author chm141593@alibaba-inc.com
 * @date 2017-12-05 9:56
 */

public class RedisTool {
    private static final String LOCK_SUCCESS = "OK";
    /**
     * NX|XX, NX -- Only set the key if it does not already exist.
     * XX Only set the key if it already exist.
     */
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * EX|PX, expire time units: EX = seconds; PX = milliseconds
     */
    private static final String SET_WITH_EXPIRE_TIME = "EX";

    private static final Long RELEASE_SUCCESS = 1L;


    /**
     * 尝试获取分布式锁
     *
     * @param jedis      Redis客户端
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(JedisClusterUtils jedis, String lockKey, String requestId, long
            expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     *
     * @param jedis     Redis客户端
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(JedisClusterUtils jedis, String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return " +
                "0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}

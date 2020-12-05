//package com.midea.ccs.core.context;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.midea.ccs.core.dto.request.InvRedisRequest;
//
///**
// *@author ex_ludz1
// *描述：redis操作ccs销售层锁定库存时的，回滚对象   ==========redis
// *
//public class RedisLockInvOperationHolder {
//    private static final Logger logger = LoggerFactory.getLogger(RedisLockInvOperationHolder.class.getName());
//    private static final ThreadLocal<List<InvRedisRequest>> redisOperationHolder = new ThreadLocal<>();
//    private static final ThreadLocal<Boolean> limitControl = new ThreadLocal<>();
//    private RedisLockInvOperationHolder() {logger.debug("RedisLockInvOperationHolder class"); }
//
//    /**
//     * 操作锁定库存成功后，把对应的operation添加到list，以便回滚操作
//     */
//    public static void putRedisOperation(InvRedisRequest areaReq) {
//        if (redisOperationHolder.get() == null) {
//            redisOperationHolder.set(new ArrayList<InvRedisRequest>());
//        }
//        redisOperationHolder.get().add(areaReq);
//    }
//
//    /**
//     * 获取逆向operation list用于回滚操作
//     * 可能返回空值
//     */
//    public static List<InvRedisRequest> getReverseOperationList() {
//        List<InvRedisRequest> newList = null;
//        List<InvRedisRequest> list = redisOperationHolder.get();
//        if(list != null) {
//            newList =new ArrayList<>(list);
//            Collections.reverse(newList);
//        }
//        return newList;
//    }
//
//    /**
//     * 清空threadlocal
//     */
//    public static void clearRedisOperation() {
//        if (redisOperationHolder.get() != null) {
//            redisOperationHolder.get().clear();
//            redisOperationHolder.remove();// remove之后会重新初始化
//            logger.debug("已清除 ThreadLocal RedisLockInvOperationHolder");
//        }
//        if (limitControl != null) {
//            limitControl.remove();
//            logger.debug("已清除 ThreadLocal RedisLockInvOperationHolder");
//        }
//    }
//    public static Boolean getLimitControl() {
//        return limitControl.get();
//    }
//
//    public static void setLimitControl(Boolean value) {
//        limitControl.set(value);
//    }
//
//
//
//
//
//}

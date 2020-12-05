/**
 * @Author ex_lianggang
 * @Date 2020/9/14 18:54
 * @Version 1.0
 */
public class Thread1 {
    //线程循环
//    for (int cnt=1; cnt<=MAX_CNT; cnt++) {
//        try {
//            lockRecord = applicationLockMapper.acquireLockWait(serviceId, lockKey);
//            break; // 如果获取成功马上退出循环(观察到transaction restart之后才有可能重试可以获取锁成功)
//        } catch (Exception ex) {
//            logger.debug("重新获取锁失败(" + cnt + "次)：" + serviceId + '-' + lockKey + ", Msg=" + ex.getMessage());
//
//            if (cnt == MAX_CNT) {
//                logger.error("重新获取锁失败(" + cnt + "次)：" + serviceId + '-' + lockKey, ex);
//                throw new ApplicationException("获取锁失败(" + cnt + "次)：" + serviceId + '-' + lockKey + ". " + ex.getMessage(), ex);
//            } else {
//                try {
//                    Thread.sleep(WAIT_TIME);;
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    throw new ApplicationException(e);
//                } //3秒后重试
//            }
//        }
//    }
}

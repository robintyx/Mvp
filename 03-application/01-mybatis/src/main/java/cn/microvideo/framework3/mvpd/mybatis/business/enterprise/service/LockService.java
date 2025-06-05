package cn.microvideo.framework3.mvpd.mybatis.business.enterprise.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**    
 * 南京感动科技有限公司.
 * @title: IDbmBaseEnterpriseServiceImpl.java
 * @description: 企业信息表
 * @author microvideo
 * @version V3.0.0-RELEASES
 */
@Slf4j
@Service
public class LockService {
    public static Integer value = 100;

//    @MicrovideoDistributeLock(prefix="microvideo:redkey:", type="ningcw",  parts="0,1", waittime = 10000L,leasetime = 1000L)
    public void test(String id, String name){
        log.info("VALUE={}", value--);
    }
}

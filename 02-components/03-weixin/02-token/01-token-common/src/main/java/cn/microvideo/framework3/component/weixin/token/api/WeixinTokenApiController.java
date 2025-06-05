package cn.microvideo.framework3.component.weixin.token.api;

import cn.microvideo.framework3.component.weixin.token.service.WeixinTokenThirdService;
import cn.microvideo.framework3.component.weixin.token.service.WeixinTokenWxService;
import cn.microvideo.framework3.core.initialization.handler.MicrovideoAbstractHandlers;
import cn.microvideo.framework3.core.initialization.http.MicroviceoHttpRsp;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhangh
 * @description wx token相关接口
 * @date 2022/10/21 9:44
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class WeixinTokenApiController extends MicrovideoAbstractHandlers {

    @Autowired
    private WeixinTokenWxService wxService;
    @Autowired
    private WeixinTokenThirdService thirdService;


    /**
     * 定时获取accessToken存入redis
     *
     * @param
     * @return void
     * @author zhangh
     * @date 2022/10/21
     */
    @RequestMapping("/reloadAccessTokenSetRedis")
    public MicroviceoHttpRsp reloadAccessTokenSetRedis() {
        try {
            log.info("获取accessToken存入redis");
            wxService.addTokenToRedis();
            return success("获取accessToken存入redis成功！！！", true);
        } catch (Exception e) {
            log.error("获取accessToken存入redis失败了!!!", e);
            throw e;
        }
    }

    /**
     * 获取accessToken
     *
     * @param
     * @return void
     * @author zhangh
     * @date 2022/10/21
     */
    @RequestMapping("/getAccessToken")
    public MicroviceoHttpRsp getAccessToken() {
        try {
            log.info("获取全量token");
            return success("获取accessToken成功！！！", wxService.getWxTokenRedis());
        } catch (Exception e) {
            log.error("获取accessToken失败了!!!", e);
            throw e;
        }
    }

    /**
     * 从第三方定时获取accessToken存入redis
     *
     * @param
     * @return void
     * @author zhangh
     * @date 2022/10/21
     */
    @RequestMapping("/getAccessTokenSetRedis")
    public MicroviceoHttpRsp getAccessTokenSetRedis() {
        try {
            log.info("获取accessToken存入redis");
            thirdService.addTokenToRedis();
            return success("获取accessToken存入redis成功！！！", true);
        } catch (Exception e) {
            log.error("获取accessToken存入redis失败了!!!", e);
            throw e;
        }
    }

    @Override
    public Logger getLog() {
        return log;
    }
}

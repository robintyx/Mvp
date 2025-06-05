package cn.microvideo.framework3.component.web.portlet.app.api;

import cn.microvideo.framework3.core.configuration.MicrovideoConfigurationProperties;
import cn.microvideo.framework3.core.initialization.http.MicroviceoHttpRsp;
import cn.microvideo.framework3.support.cas.handler.MicrovideoCasHandlers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author wangyazhou
 * @description 登录控制类
 * @date 2020/11/26 9:44
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController extends MicrovideoCasHandlers {
    @Autowired
    private MicrovideoConfigurationProperties config;

    @Resource(name = "PortletRestTemplate")
    private RestTemplate restTemplate;

    /**获取token*/
    @Operation(summary = "获取token", description = "获取token")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping("/getToken")
    public MicroviceoHttpRsp getToken(HttpServletRequest request)  {
        try{
            return success("获取token成功", refreshToken(request));
        }catch (Exception e){
            return fail(1101);
        }
    }

    @Override
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Override
    public MicrovideoConfigurationProperties getConfig() {
        return config;
    }

    @Override
    public Logger getPortletLog() {
        return log;
    }
}


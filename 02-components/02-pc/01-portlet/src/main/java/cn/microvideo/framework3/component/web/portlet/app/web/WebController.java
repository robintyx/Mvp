package cn.microvideo.framework3.component.web.portlet.app.web;

import cn.microvideo.framework3.core.configuration.MicrovideoConfigurationProperties;
import cn.microvideo.framework3.core.util.hutool.MicrovideoBase64Util;
import cn.microvideo.framework3.support.cas.constant.MicrovideoCasConstant;
import cn.microvideo.framework3.support.cas.handler.MicrovideoCasHandlers;
import cn.microvideo.framework3.support.cas.session.MicrovideoCasSessionUser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author wangyazhou
 * @description 登录控制类
 * @date 2020/11/26 9:44
 */
@Controller
@Slf4j
public class WebController extends MicrovideoCasHandlers {
    @Autowired
    private MicrovideoConfigurationProperties config;

    @Resource(name = "PortletRestTemplate")
    private RestTemplate restTemplate;

    @Value("${web.index.url}")
    private String webIndexUrl;

    @Value("${web.index.deployowner}")
    private String deployOwner;

    @Value("${web.index.deployversion}")
    private String deployVersion;

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @description 登录控制
     * @Params [request]
     * @author wangyazhou
     * @date 2020/11/26 10:56
     */
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        refreshToken(request);
        view.setViewName(deployOwner+"/"+deployVersion+"/index");
        MicrovideoCasSessionUser user = (MicrovideoCasSessionUser) request.getSession().getAttribute(MicrovideoCasConstant.ACCOUNT);
        if(user==null|| StringUtils.isBlank(user.getToken())){
            view.setViewName("error/error-not-user");
            return view;
        }
        view.getModelMap().addAttribute(MicrovideoCasConstant.ACCOUNT, user);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("parentId");
        filter.getExcludes().add("appid");
        filter.getExcludes().add("id");
        view.getModelMap().addAttribute(MicrovideoCasConstant.AUTHS, JSON.toJSONString(getAuthModes(user.getUid()),filter,SerializerFeature.WriteMapNullValue));
        view.getModelMap().addAttribute(MicrovideoCasConstant.ORGS, JSON.toJSONString(getOrgs(user.getUid()),filter,SerializerFeature.WriteMapNullValue));
        view.getModelMap().addAttribute(MicrovideoCasConstant.USER_INFO, JSON.toJSONString(user,filter,SerializerFeature.WriteMapNullValue));
        view.getModelMap().addAttribute(MicrovideoCasConstant.WEB_INDEX_URL,webIndexUrl);
        return view;
    }

    @RequestMapping("/preview/{reqUrl}")
    public ModelAndView preview(@PathVariable String reqUrl, HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        refreshToken(request);
        view.setViewName(deployOwner+"/"+deployVersion+"/preview");
        MicrovideoCasSessionUser user = (MicrovideoCasSessionUser) request.getSession().getAttribute(MicrovideoCasConstant.ACCOUNT);
        if(user==null|| StringUtils.isBlank(user.getToken())){
            view.setViewName("error/error-not-user");
            return view;
        }
        view.getModelMap().addAttribute(MicrovideoCasConstant.ACCOUNT, user);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("parentId");
        filter.getExcludes().add("appid");
        filter.getExcludes().add("id");
        view.getModelMap().addAttribute(MicrovideoCasConstant.AUTHS, JSON.toJSONString(getAuthModes(user.getUid()), filter, SerializerFeature.WriteMapNullValue));
        view.getModelMap().addAttribute(MicrovideoCasConstant.ORGS, JSON.toJSONString(getOrgs(user.getUid()), filter, SerializerFeature.WriteMapNullValue));
        view.getModelMap().addAttribute(MicrovideoCasConstant.USER_INFO, JSON.toJSONString(user, filter, SerializerFeature.WriteMapNullValue));
        view.getModelMap().addAttribute(MicrovideoCasConstant.WEB_INDEX_URL,webIndexUrl);
        view.getModelMap().addAttribute(MicrovideoCasConstant.DEPLOY_PATH, new String(MicrovideoBase64Util.decode(MicrovideoBase64Util.decode(reqUrl))));
        return view;
    }

    /**
     * @return java.lang.String
     * @description 登出cas
     * @Params [token]
     * @author wangyazhou
     * @date 2020/12/9 14:28
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        //注销token
        revokeToken(request);
        request.getSession().invalidate();
        // 退出登录后，跳转到退出成功的页面，不走默认页面
        log.info("redirect:" + config.getCas().getServerLogoutUrl() + "?service=" + config.getCas().getClientHostIndexUrl());
        return "redirect:" + config.getCas().getServerLogoutUrl() + "?service=" + config.getCas().getClientHostIndexUrl();
    }


    @Override
    public Logger getLog() {
        return log;
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

package cn.microvideo.framework3.component.weixin.qy.portlet.web;

import cn.microvideo.framework3.support.wx.qy.portlet.constant.MicrovideoWxqySessionConstant;
import cn.microvideo.framework3.support.wx.qy.portlet.handler.MicrovideoWxqyBasicController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangyazhou
 * @description 登录控制类
 * @date 2020/11/26 9:44
 */
@Controller
@Slf4j
public class WebController extends MicrovideoWxqyBasicController {
    @Value("${microvideo.deploy.version}")
    private String version;

    @Value("${microvideo.filter.domain}")
    private String domain;


    @RequestMapping("/view/{reqUrl}/index")
    public ModelAndView login(@PathVariable String reqUrl, HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("view/"+version+"/index");
        init(view, request,getReqUrl(request,"https://"+domain+request.getContextPath()+"/view/"+version+"/index"));
        view.getModelMap().addAttribute(MicrovideoWxqySessionConstant.DEPLOY_VERSION, version);
        view.getModelMap().addAttribute(MicrovideoWxqySessionConstant.DEPLOY_PATH, reqUrl);
        view.getModelMap().addAttribute(MicrovideoWxqySessionConstant.DEPLOY_DOMAIN, domain);
        return view;
    }

    @Override
    public Logger getLog() {
        return log;
    }
}


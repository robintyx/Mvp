package cn.microvideo.framework3.component.weixin.gzh.portlet.business.mod2;

import cn.microvideo.framework3.support.wx.gzh.portlet.constant.WeixinGzhConstant;
import cn.microvideo.framework3.support.wx.gzh.portlet.handler.WeixinGzhHandler;
import cn.microvideo.framework3.support.wx.gzh.portlet.util.WeixinGzhBeanUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author ningchuanwei
 * @description 公众号
 * @date 2020/11/26 9:44
 */
@Controller
@Slf4j
public class Mod2Controller extends WeixinGzhHandler {
    @Value("${microvideo.deploy.version}")
    private String version;
    @Value("${microvideo.filter.domain}")
    private String domain;

    @RequestMapping("/bus/{reqUrl}/index")
    public ModelAndView index(@PathVariable String reqUrl, HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("bus/"+version+"/index");
        init(view,request);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_VERSION, version);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_PATH, reqUrl);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_DOMAIN, domain);
        return view;
    }

    @RequestMapping("/bus/preview/{reqUrl}/{reqRoute}")
    public ModelAndView preview(@PathVariable String reqUrl,@PathVariable String reqRoute,  HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("bus/"+version+"/preview");
        init(view,request);
        String queryString=request.getQueryString();
        if(StringUtils.isBlank(queryString)){
            queryString="none";
        }
        log.info("queryString:[{]]",queryString);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_VERSION, version);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_PATH, reqUrl);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_ROUTE, reqRoute);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_QUERY, queryString);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_DOMAIN, domain);
        return view;
    }

    @RequestMapping("/bus/record/one/{reqUrl}/{reqRoute}/{rid}")
    public ModelAndView previewRecordOne(@PathVariable String reqUrl,@PathVariable String reqRoute, @PathVariable String rid,  HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("bus/"+version+"/record");
        init(view,request);

        String decryptRid=null;
        try {
            decryptRid  = WeixinGzhBeanUtil.getAes().decryptStr(rid);
        } catch (Exception e) {
            log.error("rid 解密失败，请传入正确的密文",e);
        }
        if(StringUtils.isBlank(decryptRid)){
            view.setViewName("error/invalid_operation");
            return view;
        }
        log.info("rid:[{}] decryptRid:[{}]",rid,decryptRid);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_VERSION, version);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_PATH, reqUrl);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_ROUTE, reqRoute);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_DOMAIN, domain);
        view.getModelMap().addAttribute(WeixinGzhConstant.DEPLOY_RID, rid);
        return view;
    }

    @Override
    public Logger getLog() {
        return log;
    }
}

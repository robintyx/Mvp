//PortletUtil
var PortletUtil = PortletUtil || {};
PortletUtil.wx=new function(){
    var self = this;
    self.createJsAPISignature=function(openid,param){
        // return PortletUtil.common.ajax("https://jsgswxgzhapi.jchc.cn/gateway/api/jsgs/wcp/createJsAPISignature",openid,param);
        return PortletUtil.common.ajax("https://wxgzhapics.jchc.cn/gateway/api/jsgs/wcp/createJsAPISignature",openid,param);
        // return PortletUtil.common.ajax("https://qhglapi-test.gandongyun.cn/gateway/api/qh/wcp/createJsAPISignature",openid,param);
    };
    self.sendBinding=function(openid){
        // return PortletUtil.common.ajaxGet("https://jsgswxgzhapi.jchc.cn/gateway/api/jsgs/user/sendBinding",openid);
        return PortletUtil.common.ajaxGet("https://wxgzhapics.jchc.cn/gateway/api/jsgs/user/sendBinding",openid);
        // return PortletUtil.common.ajaxGet("https://qhglapi-test.gandongyun.cn/gateway/api/qh/user/sendBinding",openid);
    };
    self.getJsAPISignature = function (url, openid, param) {
        return PortletUtil.common.ajax(url, openid, param);
    };
};

PortletUtil.common=new function(){
    var self = this;
    self.ajax=function(url,openid,param){
        var data;
        $.ajax({
            async:false,
            type: "POST",
            url: url,
            data:param,
            dataType: 'json',
            contentType: 'application/json',
            beforeSend: function (request) {
                request.setRequestHeader("openid", openid);
            },
            success: function (result) {
                console.log("ajax"+JSON.stringify(result));
                data=result.data;
            }
        });
        return data;
    };
    self.ajaxGet=function(url,openid){
        $.ajax({
            async:false,
            type: "GET",
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            beforeSend: function (request) {
                request.setRequestHeader("openid", openid);
            },
            success: function (result) {
                console.log("ajaxGet"+JSON.stringify(result));
            }
        });
    };
};

PortletUtil.text=new function(){
    var self = this;
    self.trim=function(str){
        if(str==null||str=="null")
            return "";
        return str.replace(/^\s+|\s+$/g,"");
    };

};
PortletUtil.cookie=new function(){
    var self = this;
    self.set=function(name,value)
    {
        var Days = 1;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days*24*60*60*1000);
        document.cookie = name + "="+ value + ";expires=" + exp.toGMTString()+ ";path=/";
    };
    self.get=function(name)
    {
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
        if(arr=document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    };
    self.remove=function(name)
    {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval=PortletUtil.cookie.get(name);
        if(cval!=null)
            document.cookie= name + "="+cval+";expires="+exp.toGMTString();
    };
}




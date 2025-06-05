//PortletUtil
var PortletUtil = PortletUtil || {};
PortletUtil.notice=new function(){
    var self = this;
    self.refresh=function(callback){
        try {
            $.ajax({
                type: "POST",
                async: false,
                url: path + "/notice/list",
                beforeSend: function (request) {
                    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
                },
                success: function (res) {
                    callback(JSONUtil.toJson(res));
                }
            });
        } catch (e) {
        }
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




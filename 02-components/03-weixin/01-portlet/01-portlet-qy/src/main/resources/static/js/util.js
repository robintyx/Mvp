//PortletUtil
var PortletUtil = PortletUtil || {};

PortletUtil.wx = new function () {
    var self = this;
    self.getJsAPISignature = function (url, token, param) {
        return PortletUtil.common.ajax(url, token, param);
    };
};

PortletUtil.user = new function () {
    var self = this;
    self.submitSwitchOrg = function (param, callback) {
        console.log(param);
        var url= ctxPath+"system/switch/org";
        $.ajax({
            async: false,
            type: "POST",
            url: url,
            data:param,
            dataType: 'json',
            contentType: 'application/json',
            beforeSend: function (request) {
            },
            success: function (result) {
                callback(result);
            }
        });
    };
};

PortletUtil.common = new function () {
    var self = this;
    self.ajax = function (url, token, param) {
        var data;
        $.ajax({
            async: false,
            type: "POST",
            url: url,
            data: param,
            dataType: 'json',
            contentType: 'application/json',
            beforeSend: function (request) {
            },
            success: function (result) {
                console.log("ajax" + JSON.stringify(result));
                data = result.data;
            }
        });
        return data;
    };

    self.ajax2 = function (url, param) {
        var data;
        $.ajax({
            async: false,
            type: "POST",
            url: url,
            data: param,
            dataType: 'json',
            contentType: 'application/json',
            beforeSend: function (request) {
            },
            success: function (result) {
                console.log("ajax" + JSON.stringify(result));
                data = result.data;
            }
        });
        return data;
    };
};


PortletUtil.text = new function () {
    var self = this;
    self.trim = function (str) {
        if (str == null || str == "null")
            return "";
        return str.replace(/^\s+|\s+$/g, "");
    };

};

PortletUtil.cookie = new function () {
    var self = this;
    self.set = function (name, value) {
        var Days = 1;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + value + ";expires=" + exp.toGMTString() + ";path=/";
    };
    self.get = function (name) {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    };
    self.remove = function (name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = PortletUtil.cookie.get(name);
        if (cval != null)
            document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    };
}




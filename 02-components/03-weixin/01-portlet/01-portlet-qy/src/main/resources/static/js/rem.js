/**
 * @author  陈佳宁(cjnbabao@163.com)
 * @date  2021/9/8 下午4:49
 * @version 1.0
 */

//  配置rem
(function (doc, win) {
    let docEle = doc.documentElement, // 获取html元素
        event = 'orientationchange' in window ? 'orientationchange' : 'resize', // 判断是屏幕旋转还是resize;
        fn = function () {
            let width = docEle.clientWidth;
            width && (docEle.style.fontSize = 100 * (width / 1920) + 'px')// 设置html的fontSize，随着event的改变而改变。
        };
    win.addEventListener(event, fn, false);
    doc.addEventListener('DOMContentLoaded', fn, false)
}(document, window));

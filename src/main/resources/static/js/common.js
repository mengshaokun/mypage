/*
    通用css文件
*/
/*设置页面icon*/
document.write('<link rel="shortcut icon" href="../img/mypage_title_icon.png" type="text/css">');
/*
/!*新 Bootstrap4 核心 CSS 文件*!/
document.write('<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css" type="text/css">');


/!*
    通用js文件
*!/
/!*jQuery文件。务必在bootstrap.min.js 之前引入*!/
document.write('<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>');
/!*popper.min.js 用于弹窗、提示、下拉菜单*!/
document.write('<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js" type="text/javascript"></script>');
/!*最新的 Bootstrap4 核心 JavaScript 文件*!/
document.write('<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js" type="text/javascript"></script>');
/!*jquery表单校验插件*!/
document.write('<script src="https://cdn.staticfile.org/jquery-validate/1.19.1/jquery.validate.min.js" type="text/javascript"></script>');
*/
/*
自定义信息提示框样式
toastr.options = {
    "closeButton":true,//显示关闭按钮 可选true或false，决定在每个消息右上角是否显示关闭按钮
    "debug":false,//启用debug
    "positionClass":"toast-top-right",//弹出的位置 分成toast-(bottom|top)-(left|right|center)的组合，指出了消息可以出现的几个位置
    "showDuration":"300",//显示的时间 单位毫秒
    "hideDuration":"500",//消失的时间 单位毫秒
    "timeOut":"2000",//停留的时间 单位毫秒
    "extendedTimeOut":"1000",//控制时间 单位毫秒
    "showEasing":"swing",//显示时的动画缓冲方式
    "hideEasing":"linear",//消失时的动画缓冲方式
    "showMethod":"fadeIn",//显示时的动画方式 默认是fadeIn和fadeOut，用于设置消息出现和消失的动画的
    "hideMethod":"fadeOut",//消失时的动画方式 默认是fadeIn和fadeOut，用于设置消息出现和消失的动画的
    "progressBar":true//设置true或false，在消息窗口下面添加一个进度条，进度条走完时消息自动消失

};*/

function isDelete() {
    confirm("确定要删除吗？");
    /*if (confirm("确定要删除吗？")) {
        return true;
    } else {
        return false;
    }*/
}
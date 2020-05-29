$("#main").hover(function(){
    $("#mainInfo").toggle();
});

/**
 * 查询天气信息
 */
function getWeatherInfo() {
    $("#flushImg").attr("src", "/img/mypage_loading.gif");
    $.post("/util/weather", {}, function (data) {
        if (data.code == 200) {
            var weatherInfo = data.data;
            $("#weatherInfo").text(weatherInfo.city + "/" + weatherInfo.weather + "/" + weatherInfo.temperature + "℃");
            $("#flushImg").attr("src", "/img/mypage_flush_weather.png");
        } else {
            $("#flushImg").attr("src", "/img/mypage_flush_weather.png");
        }
    }, "json");
}

/**
 * 设置显示翻译框
 * @param button
 */
function showTranslate(button) {
    $("#transQuery").val("");
    $("#transResult").val("");
    var onoff = $(button).attr("onoff");
    if (onoff == "off") {
        $("#translate").show();
        $(button).attr("onoff", "on");
    } else {
        $("#translate").hide();
        $(button).attr("onoff", "off");
    }
}

/**
 * 翻译
 */
function trans() {
    var transQuery = $("#transQuery").val();//需要翻译的内容
    var transTo = $("#transTo").val();//翻译语言

    if (transQuery == null || transQuery == "") {
        toastr.error("翻译内容不能为空！");
        return ;
    }

    $("#transBtn").text("翻译ing").attr("disabled", true);
    $.post("/util/translate", {
        "query": transQuery,
        "to": transTo
    }, function (resp) {
        if (resp.code == 200) {
            var result = resp.data;
            var transResult = "";
            for (var i = 0; i < result.length; i++) {
                transResult = transResult + result[i].dst + "\n";
                $("#transResult").val(transResult);
            }
        } else {
            $("#transResult").val("");
            toastr.error(resp.data);
        }
        $("#transBtn").text("翻译").attr("disabled", false);
    }, "json");
}


getWeatherInfo();
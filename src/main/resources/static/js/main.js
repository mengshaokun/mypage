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

getWeatherInfo();

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
        // toastr.error("翻译内容不能为空！");
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

/**
 * 校验需要翻译的语言
 * 方式：校验是否包含中文，如果包含中文，则认定需要翻译的语言为中文，翻译的目标语言为英文
 */
function checkLanguage() {
    var query = $("#transQuery").val();
    if (query != null && "" != query) {
        var reg = /[\u4e00-\u9fa5]/;
        if (reg.test(query)) {
            //校验包含中文，设置目标语言为英文，否则为中文
            $("#transTo").val("en");
        } else {
            $("#transTo").val("zh");
        }
    }
    // trans();
    // setTimeout(trans(), 1500);
}
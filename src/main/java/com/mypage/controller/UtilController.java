package com.mypage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mypage.common.CommonContent;
import com.mypage.common.Response;
import com.mypage.model.request.TranslateReq;
import com.mypage.model.response.WeatherInfoResp;
import com.mypage.utils.HttpClientUtils;
import com.mypage.utils.IpUtils;
import com.mypage.utils.ListUtils;
import com.mypage.utils.baidutranslate.TransApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mengsk
 * @date 2020/5/27
 */
@Controller
@RequestMapping("/util")
@Slf4j
public class UtilController {

    private static final String OUT_PUT = "JSON";
    private static final String DEFAULT_IP = "111.196.30.202";
    private static final String TRANS_DEFAULT_FROM = "auto";

    @Resource
    private HttpClientUtils httpUtils;

    @Value("${system.flag}")
    private String systemFlag;
    @Value("${ibs.map.ip.url}")
    private String ibsMapIpUrl;
    @Value("${ibs.map.key}")
    private String ibsMapKey;
    @Value("${ibs.map.weather.url}")
    private String ibsMapWeatherUrl;
    @Value("${baidu.trans.host}")
    private String baiduTransHost;
    @Value("${baidu.trans.app-id}")
    private String baiduTransAppId;
    @Value("${baidu.trans.security-key}")
    private String baiduTransSecurityKey;


    /**
     * 获取天气信息
     * @param request
     * @return
     */
    @RequestMapping("/weather")
    @ResponseBody
    public Response getWeatherInfo(HttpServletRequest request) {
        //获取ip地址
        String ipAddress = IpUtils.getIpAddress(request);
        if (systemFlag.equals("test")) {
            ipAddress = DEFAULT_IP;
        }
        Map<String, String> params = new HashMap<>();
        params.put("ip", ipAddress);
        params.put("output", OUT_PUT);
        params.put("key", ibsMapKey);
        //根据ip地址获取地理位置信息
        String positionStr = httpUtils.doGet(ibsMapIpUrl, params);
        if (positionStr == null) {
            return Response.FAIL();
        }
        JSONObject positionObject = JSON.parseObject(positionStr);
        String status = positionObject.getString("status");
        if ("0".equals(status)) {
            log.error(CommonContent.GET_POSITION_ERROR, positionStr);
            return Response.FAIL();
        }
        //城市的adcode编码
        String adCode = positionObject.getString("adcode");
        //根据adCode获取天气信息
        Map<String, String> weatherMap = new HashMap<>();
        weatherMap.put("city", adCode);
        weatherMap.put("key", ibsMapKey);
        String weatherStr = httpUtils.doGet(ibsMapWeatherUrl, weatherMap);
        if (weatherStr == null) {
            return Response.FAIL();
        }
        JSONObject weatherObject = JSON.parseObject(weatherStr);
        String weatherStatus = weatherObject.getString("status");
        if ("0".equals(weatherStatus)) {
            log.error(CommonContent.GET_WEATHER_ERROR, weatherStr);
            return Response.FAIL();
        }
        WeatherInfoResp weatherInfoResp = new WeatherInfoResp();
        JSONArray lives = weatherObject.getJSONArray("lives");
        if (ListUtils.isNotNull(lives)) {
            JSONObject weatherInfo = lives.getJSONObject(0);
            weatherInfoResp.setCity(weatherInfo.getString("city"));
            weatherInfoResp.setWeather(weatherInfo.getString("weather"));
            weatherInfoResp.setTemperature(weatherInfo.getString("temperature"));
            weatherInfoResp.setReporttime(weatherInfo.getString("reporttime"));
        }
        return Response.SUCCESS(weatherInfoResp);
    }


    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    @ResponseBody
    public Response translate(TranslateReq translateReq) {
        TransApi transApi = new TransApi(baiduTransHost, baiduTransAppId, baiduTransSecurityKey);
        String transResult = transApi.getTransResult(translateReq.getQuery(), TRANS_DEFAULT_FROM, translateReq.getTo());
        JSONObject jsonObject = JSON.parseObject(transResult);
        if (jsonObject.containsKey("error_code")) {
            return Response.FAIL(CommonContent.TRANS_ERROR);
        }
        JSONArray transResultList = jsonObject.getJSONArray("trans_result");
        return Response.SUCCESS(transResultList);
    }
}

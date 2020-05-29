package com.mypage.model.response;

import lombok.Data;

/**
 * @author mengsk
 * @date 2020/5/27
 */
@Data
public class WeatherInfoResp {

    private String city;//城市

    private String weather;//天气

    private String temperature;//实时气温，单位：摄氏度

    private String reporttime;//数据发布的时间

}

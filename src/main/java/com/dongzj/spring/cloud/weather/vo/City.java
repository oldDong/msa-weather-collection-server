package com.dongzj.spring.cloud.weather.vo;

import lombok.Data;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/8/30
 * Time: 14:07
 */
@Data
public class City {

    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;
}

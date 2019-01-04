package com.dongzj.spring.cloud.weather.service;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/8/31
 * Time: 10:43
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气数据
     *
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}

package com.dongzj.spring.cloud.weather.service;

import com.dongzj.spring.cloud.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 访问城市信息的客户端
 *
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/8/31
 * Time: 17:47
 */
@FeignClient("msa-weather-city-server") //需要访问应用的名称
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}

package com.dongzj.spring.cloud.weather.job;

import com.dongzj.spring.cloud.weather.service.CityClient;
import com.dongzj.spring.cloud.weather.service.WeatherDataCollectionService;
import com.dongzj.spring.cloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * 同步天气数据
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/8/29
 * Time: 20:23
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        logger.info("天气数据同步任务 start");

        //由城市数据API微服务来提供数据
        List<City> cityList = null;
        try {
            //  调用城市数据API
            cityList = cityClient.listCity();
        } catch (Exception e) {
            logger.error("获取城市信息异常！", e);
            throw new RuntimeException("获取城市信息异常！", e);
        }

        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("天气数据同步任务中,-cityId:{}", cityId);

            //根据城市ID同步天气数据
            weatherDataCollectionService.syncDataByCityId(cityId);
        }

        logger.info("天气数据同步任务 end");
    }
}

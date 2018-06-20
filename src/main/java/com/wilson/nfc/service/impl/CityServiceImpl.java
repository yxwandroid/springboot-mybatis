package com.wilson.nfc.service.impl;

import com.wilson.nfc.mapper.CityDao;
import com.wilson.nfc.model.City;
import com.wilson.nfc.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

}

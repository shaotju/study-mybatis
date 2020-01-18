package canger.study.service.impl;

import canger.study.mapper.CityMapper;
import canger.study.model.City;
import canger.study.service.CityService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl  implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public City findCityById(Integer id) {
        return cityMapper.selectCityById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addCity(List<City> cityList) {
        for (int i = 0; i < cityList.size(); i++) {
            cityMapper.insertCity(cityList.get(i));
        }
        System.out.println("finish");
    }
}

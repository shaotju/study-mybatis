package canger.study;

import canger.study.mapper.CityMapper;
import canger.study.model.City;
import canger.study.service.CityService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpringXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        CityMapper cityMapper = applicationContext.getBean(CityMapper.class);
        CityService cityService = applicationContext.getBean(CityService.class);

        List<City> cityList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            City city = new City();
            city.setDistrict("HeBei");
            city.setName("XingTai"+i);
            city.setPopulation(1000000);

            cityList.add(city);
        }

        cityService.addCity(cityList);
    }
}

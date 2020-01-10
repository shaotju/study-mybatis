package canger.study;

import canger.study.mapper.CityMapper;
import canger.study.model.City;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        CityMapper cityMapper = applicationContext.getBean(CityMapper.class);

        City city = cityMapper.selectCityById(1001);
        System.out.println(city);
    }
}

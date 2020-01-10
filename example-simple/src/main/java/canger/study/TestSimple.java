package canger.study;

import canger.study.mapper.CityMapper;
import canger.study.model.City;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;

public class TestSimple {
    public static void main(String[] args) {
        SqlSessionFactory sessionFactory = null;
        try(InputStream resourceAsStream = TestSimple.class.getClassLoader().getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = sessionFactory.openSession(ExecutorType.BATCH,true);
        CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
//        List<City> de = cityMapper.selectCityByName("de", new RowBounds(5, 10));
//        System.out.println(de);
        //City city = cityMapper.selectCityById(10);
       // city = cityMapper.selectCityByIdAndTableName(10,"city");

        City city = new City();
        city.setDistrict("HeBei");

        city.setPopulation(1000000);
        for (int i=0; i<5; i++){
            city.setName("XingTai"+i);
            cityMapper.insertCity(city);
        }

        sqlSession.commit();

        for (int i=0; i<5; i++){
            city.setName("XingTai"+i);
            cityMapper.insertCity(city);
        }
        sqlSession.commit();

        sqlSession.close();
    }
}

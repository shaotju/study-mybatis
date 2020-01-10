package canger.study.mapper;

import canger.study.model.City;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CityMapper {
    City selectCityById(Integer id);
    List<City> selectCityByName(@Param("name") String name, RowBounds rowBounds);
    City selectCityByIdAndTableName(@Param("id") Integer id, @Param("table") String table);
    int insertCity(City city);
}

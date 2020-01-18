package canger.study.service;

import canger.study.model.City;

import java.util.List;

public interface CityService {
    City findCityById(Integer id);
    void addCity(List<City> cityList);
}

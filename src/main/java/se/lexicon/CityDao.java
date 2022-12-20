package se.lexicon;

import java.util.List;

public interface CityDao {

    City findById(Integer ID);
    List <City> findByCode(String code);
    List <City> findByName(String name);
    List<City> findAll();
    City  add(City city);
    void update (City city);
    int delete (Integer ID);

}

package ru.itpark.service;

import ru.itpark.model.House;
import ru.itpark.service.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HouseService {

    public List<House> houses() throws SQLException {
        return JdbcTemplate.executeQuery(
                "jdbc:sqlite:C:\\Users\\Григорий\\IdeaProjects\\AvitoSQL\\dbHouses",
                "SELECT id, price, rooms, district, underground FROM houses",
                resultSet -> new House(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        resultSet.getInt("rooms"),
                        resultSet.getString("district"),
                        resultSet.getString("underground")
                ));
    }

    public List<House> searchByUnderground(String underground) throws SQLException {
        List<House> houses = houses();
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (house.getUnderground().contains(underground)) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> searchByDistrict(String district) throws SQLException {
        List<House> houses = houses();
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (house.getDistrict().contains(district)) {
                result.add(house);
            }
        }
        return result;
    }
    public List<House> sort(Comparator<House> comparator) throws SQLException {
        List<House> result = houses();
        result.sort(comparator);
        return result;
    }


}

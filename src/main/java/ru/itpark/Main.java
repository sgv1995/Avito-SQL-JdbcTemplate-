package ru.itpark;

import ru.itpark.model.House;
import ru.itpark.service.HouseService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        HouseService service = new HouseService();
        List<House> houses;
        houses = service.houses();
        System.out.println(houses);
        System.out.println(service.searchByUnderground("Проспект Победы"));
        System.out.println(service.searchByDistrict("Авиастороительный"));
        List<House> housesByPriceAsc = service.sort((o1, o2) -> -(o2.getPrice() - o1.getPrice()));
        System.out.println(housesByPriceAsc);
        List<House> housesByPriceDesc = service.sort((o1, o2) -> o2.getPrice() - o1.getPrice());
        System.out.println(housesByPriceDesc);
    }
}
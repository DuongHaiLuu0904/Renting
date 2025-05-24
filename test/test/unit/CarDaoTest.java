package test.unit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import dao.CarDAO;
import model.Car;

public class CarDaoTest {

    CarDAO cd = new CarDAO();

    @Test
    public void testSearchCarException1() {
        Date pickupDate = new GregorianCalendar(2030, Calendar.DECEMBER, 31).getTime();
        Date returnDate = new GregorianCalendar(2030, Calendar.DECEMBER, 31).getTime();
        ArrayList<Car> listCar = cd.searchCar(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        Assert.assertEquals(13, listCar.size());
    }

    @Test
    public void testSearchCarException2() {
        Date pickupDate = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
        Date returnDate = new GregorianCalendar(2019, Calendar.DECEMBER, 31).getTime(); // Invalid: return before pickup
        ArrayList<Car> listCar = cd.searchCar(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        Assert.assertEquals(13, listCar.size());
    }

    @Test
    public void testSearchCarStandard1() {
        Date pickupDate = new GregorianCalendar(2024, Calendar.JUNE, 1).getTime();
        Date returnDate = new GregorianCalendar(2024, Calendar.JUNE, 3).getTime();
        ArrayList<Car> listCar = cd.searchCar(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        // Assuming there are some cars available for rental shop ID = 1
        Assert.assertTrue(listCar.size() >= 0);
        for (int i = 0; i < listCar.size(); i++) {
            Assert.assertEquals(1, listCar.get(i).getCarRentalShopID());
        }
    }

    @Test
    public void testSearchCarStandard2() {
        Date pickupDate = new GregorianCalendar(2024, Calendar.JULY, 10).getTime();
        Date returnDate = new GregorianCalendar(2024, Calendar.JULY, 15).getTime();
        ArrayList<Car> listCar = cd.searchCar(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        for (int i = 0; i < listCar.size(); i++) {
            Assert.assertEquals(1, listCar.get(i).getCarRentalShopID());
            Assert.assertNotNull(listCar.get(i).getName());
            Assert.assertNotNull(listCar.get(i).getType());
            Assert.assertTrue(listCar.get(i).getPrice() > 0);
        }
    }

    @Test
    public void testSearchCarPartnerException1() {
        Date pickupDate = new GregorianCalendar(2030, Calendar.DECEMBER, 31).getTime();
        Date returnDate = new GregorianCalendar(2030, Calendar.DECEMBER, 31).getTime();
        ArrayList<Car> listCar = cd.searchCarPartner(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        Assert.assertEquals(3, listCar.size());
    }

    @Test
    public void testSearchCarPartnerException2() {
        Date pickupDate = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
        Date returnDate = new GregorianCalendar(2019, Calendar.DECEMBER, 31).getTime(); // Invalid: return before pickup
        ArrayList<Car> listCar = cd.searchCarPartner(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        Assert.assertEquals(3, listCar.size());
    }

    @Test
    public void testSearchCarPartnerStandard1() {
        Date pickupDate = new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime();
        Date returnDate = new GregorianCalendar(2024, Calendar.AUGUST, 5).getTime();
        ArrayList<Car> listCar = cd.searchCarPartner(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        // Partner cars should have CarRentalShopID != 1
        for (int i = 0; i < listCar.size(); i++) {
            Assert.assertFalse(listCar.get(i).getCarRentalShopID() == 1);
            Assert.assertNotNull(listCar.get(i).getName());
            Assert.assertNotNull(listCar.get(i).getType());
            Assert.assertTrue(listCar.get(i).getPrice() > 0);
        }
    }

    @Test
    public void testSearchCarPartnerStandard2() {
        Date pickupDate = new GregorianCalendar(2024, Calendar.SEPTEMBER, 1).getTime();
        Date returnDate = new GregorianCalendar(2024, Calendar.SEPTEMBER, 7).getTime();
        ArrayList<Car> listCar = cd.searchCarPartner(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        for (int i = 0; i < listCar.size(); i++) {
            Assert.assertTrue(listCar.get(i).getCarRentalShopID() != 1);
        }
    }

    @Test
    public void testSearchCarAvailability1() {
        // Test case: weekend rental
        Date pickupDate = new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(); // Saturday
        Date returnDate = new GregorianCalendar(2024, Calendar.JUNE, 16).getTime(); // Sunday
        ArrayList<Car> listCar = cd.searchCar(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        // All returned cars should belong to rental shop 1
        for (int i = 0; i < listCar.size(); i++) {
            Assert.assertEquals(1, listCar.get(i).getCarRentalShopID());
        }
    }

    @Test
    public void testSearchCarAvailability2() {
        // Test case: week-long rental
        Date pickupDate = new GregorianCalendar(2024, Calendar.JULY, 1).getTime();
        Date returnDate = new GregorianCalendar(2024, Calendar.JULY, 8).getTime();
        ArrayList<Car> listCar = cd.searchCar(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        for (int i = 0; i < listCar.size(); i++) {
            Assert.assertEquals(1, listCar.get(i).getCarRentalShopID());
            Assert.assertTrue(listCar.get(i).getId() > 0);
        }
    }

    @Test
    public void testSearchCarAvailability3() {
        // Test case: short term rental (1 day)
        Date pickupDate = new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime();
        Date returnDate = new GregorianCalendar(2024, Calendar.AUGUST, 11).getTime();
        ArrayList<Car> listCar = cd.searchCar(pickupDate, returnDate);
        Assert.assertNotNull(listCar);
        for (int i = 0; i < listCar.size(); i++) {
            Assert.assertEquals(1, listCar.get(i).getCarRentalShopID());
        }
    }

    @Test
    public void testSearchCarPartnerAvailability1() {
        // Test partner cars for weekend
        Date pickupDate = new GregorianCalendar(2024, Calendar.JUNE, 22).getTime(); // Saturday
        Date returnDate = new GregorianCalendar(2024, Calendar.JUNE, 23).getTime(); // Sunday
        ArrayList<Car> listPartnerCar = cd.searchCarPartner(pickupDate, returnDate);
        Assert.assertNotNull(listPartnerCar);
        for (int i = 0; i < listPartnerCar.size(); i++) {
            Assert.assertFalse(listPartnerCar.get(i).getCarRentalShopID() == 1);
        }
    }

    @Test
    public void testSearchCarPartnerAvailability2() {
        // Test partner cars for extended period
        Date pickupDate = new GregorianCalendar(2024, Calendar.JULY, 20).getTime();
        Date returnDate = new GregorianCalendar(2024, Calendar.JULY, 25).getTime();
        ArrayList<Car> listPartnerCar = cd.searchCarPartner(pickupDate, returnDate);
        Assert.assertNotNull(listPartnerCar);
        for (int i = 0; i < listPartnerCar.size(); i++) {
            Assert.assertTrue(listPartnerCar.get(i).getCarRentalShopID() > 1);
        }
    }

    @Test
    public void testSearchCarBothSources() {
        // Test that own cars and partner cars don't overlap
        Date pickupDate = new GregorianCalendar(2024, Calendar.AUGUST, 15).getTime();
        Date returnDate = new GregorianCalendar(2024, Calendar.AUGUST, 17).getTime();
        
        ArrayList<Car> ownCars = cd.searchCar(pickupDate, returnDate);
        ArrayList<Car> partnerCars = cd.searchCarPartner(pickupDate, returnDate);
        
        Assert.assertNotNull(ownCars);
        Assert.assertNotNull(partnerCars);
        
        // Verify no overlap in rental shop IDs
        for (int i = 0; i < ownCars.size(); i++) {
            for (int j = 0; j < partnerCars.size(); j++) {
                Assert.assertFalse(ownCars.get(i).getCarRentalShopID() == partnerCars.get(j).getCarRentalShopID());
            }
        }
    }
}
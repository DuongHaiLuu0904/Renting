package test.unit;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import dao.DAO;
import dao.RentingDAO;
import model.RentedCar;
import model.Renting;

public class RentingDAOTest {

    private RentingDAO rentingDAO;
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        rentingDAO = new RentingDAO();
        connection = new DAO().getConnection();
        connection.setAutoCommit(false);
    }

    @After
    public void tearDown() {
        try {
            if (connection != null) {
                connection.rollback();
                connection.setAutoCommit(true);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddRentingSuccess() {
        try {
            // Tạo dữ liệu test
            Renting renting = new Renting();
            renting.setPromotion("Test Promotion");
            renting.setTotalAmount(1000.0f);
            renting.setDeposit(200.0f);
            renting.setClientID(1);
            renting.setRentalAgentID(1);
            
            // Tạo danh sách xe thuê
            ArrayList<RentedCar> rentedCars = new ArrayList<>();
            RentedCar rentedCar = new RentedCar();
            rentedCar.setCarID(1);
            rentedCar.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.JUNE, 1).getTimeInMillis()));
            rentedCar.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.JUNE, 5).getTimeInMillis()));
            rentedCar.setAmount(500.0f);
            rentedCars.add(rentedCar);
            
            renting.setRentedCars(rentedCars);
            
            // Test thêm renting
            boolean result = rentingDAO.addRenting(renting);
            Assert.assertTrue("Should successfully add renting", result);
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test
    public void testAddRentingWithMultipleCars() {
        try {
            // Tạo dữ liệu test với nhiều xe
            Renting renting = new Renting();
            renting.setPromotion("Multi Car Promotion");
            renting.setTotalAmount(2000.0f);
            renting.setDeposit(400.0f);
            renting.setClientID(2);
            renting.setRentalAgentID(1);
            
            // Tạo danh sách nhiều xe thuê
            ArrayList<RentedCar> rentedCars = new ArrayList<>();
            
            RentedCar car1 = new RentedCar();
            car1.setCarID(2);
            car1.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.JULY, 1).getTimeInMillis()));
            car1.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.JULY, 5).getTimeInMillis()));
            car1.setAmount(800.0f);
            rentedCars.add(car1);
            
            RentedCar car2 = new RentedCar();
            car2.setCarID(3);
            car2.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.JULY, 1).getTimeInMillis()));
            car2.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.JULY, 5).getTimeInMillis()));
            car2.setAmount(1200.0f);
            rentedCars.add(car2);
            
            renting.setRentedCars(rentedCars);
            
            // Test thêm renting với nhiều xe
            boolean result = rentingDAO.addRenting(renting);
            Assert.assertTrue("Should successfully add renting with multiple cars", result);
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test
    public void testAddRentingConflictingDates() {
        try {
            // Thêm renting đầu tiên
            Renting renting1 = new Renting();
            renting1.setPromotion("First Renting");
            renting1.setTotalAmount(1000.0f);
            renting1.setDeposit(200.0f);
            renting1.setClientID(1);
            renting1.setRentalAgentID(1);
            
            ArrayList<RentedCar> cars1 = new ArrayList<>();
            RentedCar car1 = new RentedCar();
            car1.setCarID(4);
            car1.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.AUGUST, 1).getTimeInMillis()));
            car1.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.AUGUST, 5).getTimeInMillis()));
            car1.setAmount(1000.0f);
            cars1.add(car1);
            renting1.setRentedCars(cars1);
            
            boolean result1 = rentingDAO.addRenting(renting1);
            Assert.assertTrue("First renting should be added successfully", result1);
            
            // Commit để tạo dữ liệu conflict
            connection.commit();
            
            // Thêm renting thứ hai với xe trùng lịch
            Renting renting2 = new Renting();
            renting2.setPromotion("Conflicting Renting");
            renting2.setTotalAmount(800.0f);
            renting2.setDeposit(160.0f);
            renting2.setClientID(2);
            renting2.setRentalAgentID(1);
            
            ArrayList<RentedCar> cars2 = new ArrayList<>();
            RentedCar car2 = new RentedCar();
            car2.setCarID(4); // Same car ID
            car2.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.AUGUST, 3).getTimeInMillis()));
            car2.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.AUGUST, 7).getTimeInMillis()));
            car2.setAmount(800.0f);
            cars2.add(car2);
            renting2.setRentedCars(cars2);
            
            // Test thêm renting với xe đã được thuê
            boolean result2 = rentingDAO.addRenting(renting2);
            Assert.assertFalse("Should fail to add conflicting renting", result2);
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test
    public void testAddRentingEmptyCarList() {
        try {
            // Tạo renting với danh sách xe rỗng
            Renting renting = new Renting();
            renting.setPromotion("Empty Car List");
            renting.setTotalAmount(0.0f);
            renting.setDeposit(0.0f);
            renting.setClientID(1);
            renting.setRentalAgentID(1);
            renting.setRentedCars(new ArrayList<>());
            
            // Test thêm renting với danh sách xe rỗng
            boolean result = rentingDAO.addRenting(renting);
            Assert.assertTrue("Should successfully add renting with empty car list", result);
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test
    public void testAddRentingNullPromotion() {
        try {
            // Tạo renting với promotion null
            Renting renting = new Renting();
            renting.setPromotion(null);
            renting.setTotalAmount(500.0f);
            renting.setDeposit(100.0f);
            renting.setClientID(1);
            renting.setRentalAgentID(1);
            
            ArrayList<RentedCar> rentedCars = new ArrayList<>();
            RentedCar rentedCar = new RentedCar();
            rentedCar.setCarID(5);
            rentedCar.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.SEPTEMBER, 1).getTimeInMillis()));
            rentedCar.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.SEPTEMBER, 5).getTimeInMillis()));
            rentedCar.setAmount(500.0f);
            rentedCars.add(rentedCar);
            
            renting.setRentedCars(rentedCars);
            
            // Test thêm renting với promotion null
            boolean result = rentingDAO.addRenting(renting);
            Assert.assertTrue("Should successfully add renting with null promotion", result);
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test
    public void testAddRentingBoundaryDates() {
        try {
            // Thêm renting đầu tiên
            Renting renting1 = new Renting();
            renting1.setPromotion("Boundary Test 1");
            renting1.setTotalAmount(1000.0f);
            renting1.setDeposit(200.0f);
            renting1.setClientID(1);
            renting1.setRentalAgentID(1);
            
            ArrayList<RentedCar> cars1 = new ArrayList<>();
            RentedCar car1 = new RentedCar();
            car1.setCarID(6);
            car1.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTimeInMillis()));
            car1.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.OCTOBER, 5).getTimeInMillis()));
            car1.setAmount(1000.0f);
            cars1.add(car1);
            renting1.setRentedCars(cars1);
            
            boolean result1 = rentingDAO.addRenting(renting1);
            Assert.assertTrue("First boundary renting should be added successfully", result1);
            
            connection.commit();
            
            // Thêm renting thứ hai với ngày pickup = ngày return của renting đầu
            Renting renting2 = new Renting();
            renting2.setPromotion("Boundary Test 2");
            renting2.setTotalAmount(800.0f);
            renting2.setDeposit(160.0f);
            renting2.setClientID(2);
            renting2.setRentalAgentID(1);
            
            ArrayList<RentedCar> cars2 = new ArrayList<>();
            RentedCar car2 = new RentedCar();
            car2.setCarID(6); // Same car ID
            car2.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.OCTOBER, 5).getTimeInMillis()));
            car2.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.OCTOBER, 10).getTimeInMillis()));
            car2.setAmount(800.0f);
            cars2.add(car2);
            renting2.setRentedCars(cars2);
            
            // Test boundary case
            boolean result2 = rentingDAO.addRenting(renting2);
            Assert.assertTrue("Should successfully add renting on boundary date", result2);
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test
    public void testAddRentingInvalidClientID() {
        try {
            // Tạo renting với ClientID không tồn tại
            Renting renting = new Renting();
            renting.setPromotion("Invalid Client Test");
            renting.setTotalAmount(500.0f);
            renting.setDeposit(100.0f);
            renting.setClientID(9999); // Invalid Client ID
            renting.setRentalAgentID(1);
            
            ArrayList<RentedCar> rentedCars = new ArrayList<>();
            RentedCar rentedCar = new RentedCar();
            rentedCar.setCarID(7);
            rentedCar.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.NOVEMBER, 1).getTimeInMillis()));
            rentedCar.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.NOVEMBER, 5).getTimeInMillis()));
            rentedCar.setAmount(500.0f);
            rentedCars.add(rentedCar);
            
            renting.setRentedCars(rentedCars);
            
            // Test thêm renting với ClientID không hợp lệ
            boolean result = rentingDAO.addRenting(renting);
            Assert.assertFalse("Should fail to add renting with invalid ClientID", result);
            
        } catch (Exception e) {
            // Expected to catch exception due to foreign key constraint
            Assert.assertTrue("Should catch exception for invalid ClientID", true);
        }
    }

    @Test
    public void testAddRentingInvalidCarID() {
        try {
            // Tạo renting với CarID không tồn tại
            Renting renting = new Renting();
            renting.setPromotion("Invalid Car Test");
            renting.setTotalAmount(500.0f);
            renting.setDeposit(100.0f);
            renting.setClientID(1);
            renting.setRentalAgentID(1);
            
            ArrayList<RentedCar> rentedCars = new ArrayList<>();
            RentedCar rentedCar = new RentedCar();
            rentedCar.setCarID(9999); // Invalid Car ID
            rentedCar.setCarPickupDate(new Date(new GregorianCalendar(2024, Calendar.DECEMBER, 1).getTimeInMillis()));
            rentedCar.setCarReturnDate(new Date(new GregorianCalendar(2024, Calendar.DECEMBER, 5).getTimeInMillis()));
            rentedCar.setAmount(500.0f);
            rentedCars.add(rentedCar);
            
            renting.setRentedCars(rentedCars);
            
            // Test thêm renting với CarID không hợp lệ
            boolean result = rentingDAO.addRenting(renting);
            Assert.assertFalse("Should fail to add renting with invalid CarID", result);
            
        } catch (Exception e) {
            // Expected to catch exception due to foreign key constraint
            Assert.assertTrue("Should catch exception for invalid CarID", true);
        }
    }

    @Test
    public void testAddRentingZeroAmounts() {
        try {
            // Tạo renting với các giá trị amount = 0
            Renting renting = new Renting();
            renting.setPromotion("Zero Amount Test");
            renting.setTotalAmount(0.0f);
            renting.setDeposit(0.0f);
            renting.setClientID(1);
            renting.setRentalAgentID(1);
            
            ArrayList<RentedCar> rentedCars = new ArrayList<>();
            RentedCar rentedCar = new RentedCar();
            rentedCar.setCarID(8);
            rentedCar.setCarPickupDate(new Date(new GregorianCalendar(2025, Calendar.JANUARY, 1).getTimeInMillis()));
            rentedCar.setCarReturnDate(new Date(new GregorianCalendar(2025, Calendar.JANUARY, 5).getTimeInMillis()));
            rentedCar.setAmount(0.0f);
            rentedCars.add(rentedCar);
            
            renting.setRentedCars(rentedCars);
            
            // Test thêm renting với amounts = 0
            boolean result = rentingDAO.addRenting(renting);
            Assert.assertTrue("Should successfully add renting with zero amounts", result);
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }
}

//testAddRentingSuccess: Test trường hợp thêm renting thành công với 1 xe
//testAddRentingWithMultipleCars: Test thêm renting với nhiều xe cùng lúc
//testAddRentingConflictingDates: Test trường hợp xe đã được thuê trong khoảng thời gian trùng lặp
//testAddRentingEmptyCarList: Test thêm renting với danh sách xe trống
//testAddRentingNullPromotion: Test thêm renting với promotion null
//testAddRentingBoundaryDates: Test trường hợp boundary (ngày pickup = ngày return của booking trước)
//testAddRentingInvalidClientID: Test thêm renting với ClientID không tồn tại
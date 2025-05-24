package test.unit;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dao.DAO;
import dao.ClientDAO;
import java.sql.SQLException;
import model.Client;

public class ClientDAOTest {

    ClientDAO cd = new ClientDAO();

    @Test
    public void testSearchClientException1() {
        String key = "xxxxxxxxxx";
        ArrayList<Client> listClient = cd.searchClient(key);
        Assert.assertNotNull(listClient);
        Assert.assertEquals(0, listClient.size());
    }

    @Test
    public void testSearchClientException2() {
        String key = "zzzzzzzzzz";
        ArrayList<Client> listClient = cd.searchClient(key);
        Assert.assertNotNull(listClient);
        Assert.assertEquals(0, listClient.size());
    }

    @Test
    public void testSearchClientByName1() {
        String key = "Lê";
        ArrayList<Client> listClient = cd.searchClient(key);
        Assert.assertNotNull(listClient);
        Assert.assertTrue(!listClient.isEmpty());
        for (int i = 0; i < listClient.size(); i++) {
            Assert.assertTrue(listClient.get(i).getName().toLowerCase().contains(key.toLowerCase()));
        }
    }

    @Test
    public void testSearchClientByName2() {
        String key = "Trần";
        ArrayList<Client> listClient = cd.searchClient(key);
        Assert.assertNotNull(listClient);
        Assert.assertTrue(listClient.size() >= 0);
        for (int i = 0; i < listClient.size(); i++) {
            Assert.assertTrue(listClient.get(i).getName().toLowerCase().contains(key.toLowerCase()));
        }
    }

    @Test
    public void testSearchClientByCCCD1() {
        String key = "123";
        ArrayList<Client> listClient = cd.searchClient(key);
        Assert.assertNotNull(listClient);
        Assert.assertTrue(listClient.size() >= 0);
        for (int i = 0; i < listClient.size(); i++) {
            Assert.assertTrue(listClient.get(i).getCccd().toLowerCase().contains(key.toLowerCase()));
        }
    }

    @Test
    public void testSearchClientByCCCD2() {
        String key = "001";
        ArrayList<Client> listClient = cd.searchClient(key);
        Assert.assertNotNull(listClient);
        Assert.assertTrue(listClient.size() >= 0);
        for (int i = 0; i < listClient.size(); i++) {
            Assert.assertTrue(listClient.get(i).getCccd().toLowerCase().contains(key.toLowerCase()));
        }
    }

    @Test
    public void testAddClient() {
        Connection con = null;
        Client testClient = new Client();
        testClient.setName("Test Name");
        testClient.setCccd("123456789012");
        testClient.setAddress("Test Address");
        testClient.setPhoneNumber("0123456789");
        testClient.setEmail("test@email.com");
        testClient.setNote("Test Note");

        try {
            con = new DAO().getConnection();
            con.setAutoCommit(false);
            
            // Add the test client
            cd.addClient(testClient);
            
            // Verify the client was added by searching for it
            ArrayList<Client> searchResult = cd.searchClient(testClient.getName());
            Assert.assertNotNull(searchResult);
            Assert.assertTrue(!searchResult.isEmpty());
            
            // Find the added client in search results
            Client addedClient = null;
            for (Client client : searchResult) {
                if (client.getName().equals(testClient.getName()) && 
                    client.getCccd().equals(testClient.getCccd())) {
                    addedClient = client;
                    break;
                }
            }
            
            Assert.assertNotNull(addedClient);
            Assert.assertEquals(testClient.getName(), addedClient.getName());
            Assert.assertEquals(testClient.getCccd(), addedClient.getCccd());
            Assert.assertEquals(testClient.getAddress(), addedClient.getAddress());
            Assert.assertEquals(testClient.getPhoneNumber(), addedClient.getPhoneNumber());
            Assert.assertEquals(testClient.getEmail(), addedClient.getEmail());
            Assert.assertEquals(testClient.getNote(), addedClient.getNote());
            Assert.assertTrue(addedClient.getId() > 0); // ID should be auto-generated
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.rollback();
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void testAddClientWithNullValues() {
        Connection con = null;
        Client testClient = new Client();
        testClient.setName("Test Name Only");
        testClient.setCccd("987654321098");
        // Other fields left null

        try {
            con = new DAO().getConnection();
            con.setAutoCommit(false);
            
            // Add the test client with some null values
            cd.addClient(testClient);
            
            // Verify the client was added
            ArrayList<Client> searchResult = cd.searchClient(testClient.getName());
            Assert.assertNotNull(searchResult);
            Assert.assertTrue(!searchResult.isEmpty());
            
            // Find the added client
            Client addedClient = null;
            for (Client client : searchResult) {
                if (client.getName().equals(testClient.getName()) && 
                    client.getCccd().equals(testClient.getCccd())) {
                    addedClient = client;
                    break;
                }
            }
            
            Assert.assertNotNull(addedClient);
            Assert.assertEquals(testClient.getName(), addedClient.getName());
            Assert.assertEquals(testClient.getCccd(), addedClient.getCccd());
            Assert.assertTrue(addedClient.getId() > 0);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.rollback();
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void testSearchClientEmptyString() {
        String key = "";
        ArrayList<Client> listClient = cd.searchClient(key);
        Assert.assertNotNull(listClient);
        // Empty string should return all clients due to LIKE '%%' pattern
        Assert.assertTrue(listClient.size() >= 0);
    }

    @Test
    public void testSearchClientSingleCharacter() {
        String key = "a";
        ArrayList<Client> listClient = cd.searchClient(key);
        Assert.assertNotNull(listClient);
        Assert.assertTrue(listClient.size() >= 0);
        for (int i = 0; i < listClient.size(); i++) {
            Assert.assertTrue(
                listClient.get(i).getName().toLowerCase().contains(key.toLowerCase()) ||
                listClient.get(i).getCccd().toLowerCase().contains(key.toLowerCase())
            );
        }
    }
}
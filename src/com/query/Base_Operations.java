package com.query;

import com.database.Database;
import com.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base_Operations {

    private Connection con = null;

    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public boolean login(String username, String password) {
        String query = "Select * From admins where username = ? and password = ?";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Base_Operations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<Product> productsView() {
        ArrayList<Product> out = new ArrayList<>();

        try {
            statement = con.createStatement();
            String query = "Select * From products";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String count = rs.getString("count");
                String price = rs.getString("price");
                String category = rs.getString("category");
                String barcode = rs.getString("barcode");
                String description = rs.getString("description");

                out.add(new Product(id, name, count, price, category, barcode, description));

            }
            return out;

        } catch (SQLException ex) {
            Logger.getLogger(Base_Operations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void productsAdd(String name, String count, String price, String category, String barcode, String description) {

        try {
            if ((name.trim().equals("Product's name")) || (count.trim().equals("Product's count")) || (price.trim().equals("Product's price")
                    || (barcode.trim().equals("Product's barcode")))
                    || (name.isEmpty()) || (count.isEmpty()) || (price.isEmpty()) || (barcode.isEmpty())) {

            } else {
                String query = "Insert Into products (name,count,price,category,barcode,description) VALUES (?,?,?,?,?,?)";
                preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, count);
                preparedStatement.setString(3, price + " AZN");
                preparedStatement.setString(4, category);
                preparedStatement.setString(5, barcode);
                preparedStatement.setString(6, description);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Base_Operations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteProduct(int id) {

        try {
            String query = "Delete from products where id = ?";
            preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Base_Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void productsUpdate(String name, String count, String price, String category, String barcode, String description, int id) {
        try {
            if ((name.trim().equals("Product's name")) || (count.trim().equals("Product's count")) || (price.trim().equals("Product's price")
                    || (barcode.trim().equals("Product's barcode")))
                    || (name.isEmpty()) || (count.isEmpty()) || (price.isEmpty()) || (barcode.isEmpty())) {

            } else {
                String query = "Update products set name = ? , count = ? ,  price = ? , category = ? , barcode = ?, description = ? where id = ?";

                preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, count);
                preparedStatement.setString(3, price);
                preparedStatement.setString(4, category);
                preparedStatement.setString(5, barcode);
                preparedStatement.setString(6, description);
                preparedStatement.setInt(7, id);
                preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(Base_Operations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public HashMap<String, String> productsCount(String barcode) {
        String query = "Select name,count From products where barcode=?";//daxil olan barcode varsa sadece name,count alinir

        HashMap<String, String> hashMap = new HashMap<>();

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, barcode);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);//name column melumati yazilir 
                String count = rs.getString(2);//count column melumati yazilir

                hashMap.put(count, name);//hashMap key(count), value(name) elave edilir

                return hashMap;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Base_Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<Product> productsSearch(String cat) {

        String query = "Select * From products where category = ?";
        ArrayList<Product> result = new ArrayList<>();

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, cat);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String count = rs.getString("count");
                String price = rs.getString("price");
                String category = rs.getString("category");
                String barcode = rs.getString("barcode");
                String description = rs.getString("description");
                result.add(new Product(id, name, count, price, category, barcode, description));

            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Base_Operations.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public Base_Operations() {

        //jdbc:mysql://localhost:3306/test
      //  String url = "jdbc:mysql://" + Database.HOST + ":" + Database.PORT + "/" + Database.DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
        }

        try {
            con = DriverManager.getConnection(Database.DB_URL, Database.DB_USERNAME, Database.DB_PASSWORD);
            System.out.println("Connection successful");
        } catch (SQLException ex) {
            System.out.println("Connection failed");
        }
    }

}

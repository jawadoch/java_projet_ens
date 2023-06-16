/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ens";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0651139203";

    private Connection connection;

    public void connect() {
        try {
            // Chargement du driver JDBC
            Class.forName(JDBC_DRIVER);

            // Établissement de la connexion à la base de données
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            System.out.println("Connecté à la base de données MySQL.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Déconnecté de la base de données MySQL.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Autres méthodes pour exécuter des requêtes et interagir avec la base de données

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
        // Appeler d'autres méthodes pour interagir avec la base de données
       
    }
}

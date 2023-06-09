/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author jawad
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Établir la connexion
            connection = getConnection();

            // Vérifier si la connexion a réussi
            if (connection != null) {
                System.out.println("Connexion à la base de données réussie !");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        } finally {
            // Fermer la connexion
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ens";
        String username = "root";
        String password = "0651139203";
        return DriverManager.getConnection(url, username, password);
    }
}

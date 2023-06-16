/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enscrud;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jawad
 */
public class FXMLDocumentController implements Initializable {

    
    @FXML
    private TextField tfcne;
    @FXML
    private TextField tffid;
    @FXML
    private TextField tfdid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tft;
    @FXML
    private TableView<Etudiant> tvetudiants;
    @FXML
    private TableColumn<Etudiant, Integer> colcne;
    @FXML
    private TableColumn<Etudiant, String> colprenom;
    @FXML
    private TableColumn<Etudiant, String> colnom;
    @FXML
    private TableColumn<Etudiant, Integer> coldi;
    @FXML
    private TableColumn<Etudiant, Integer> colfi;
    @FXML
    private TableColumn<Etudiant, String> coltele;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnrechercher;
    @FXML
    private Button bntsupprimer;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showEtudiants();
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnajouter){
            insertRecord();
        }
        else if (event.getSource() == bntsupprimer)
        {
            deleteRecord();
        }
        else if (event.getSource() == btnrechercher)
        {
            searchRecord();
        }
           
    }
    
    public Connection getConnection(){
        Connection conn;
        try{
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                String DB_URL = "jdbc:mysql://localhost:3306/ens";
                String USERNAME = "root";
                String PASSWORD = "0651139203";
                conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                return conn;

        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
             return null;
            
        }
       
    }
    


    
    public ObservableList<Etudiant> getEtudiantsList(){
        ObservableList<Etudiant> etudiantList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM ens.etudiant";
        Statement st;
        ResultSet rs;
        try{
            st= conn.createStatement();
            rs=st.executeQuery(query);
            Etudiant etudiant;
            while(rs.next()){
                etudiant = new Etudiant(rs.getInt("CNE"), rs.getString("nom"), rs.getString("prénom"), rs.getInt("filiere_id"), rs.getInt("departement_id"), rs.getString("telephone"));
                etudiantList.add(etudiant);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return etudiantList;
    } 
    
    public void showEtudiants(){
         ObservableList<Etudiant> list = getEtudiantsList();
         colcne.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("cne"));
         colprenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nom"));
         colnom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("prenom"));
         coldi.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("filiere_id"));
         colfi.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("dep_id"));
         coltele.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("tel"));
        
         tvetudiants.setItems(list);
        
    }
    private void insertRecord(){
    
      //String query = "INSERT INTO ens.Etudiant VALUES (" + tfcne.getText() + "," + tfnom.getText() + "," tfprenom.getText() + "," + tffid.getText() + "," + tfdid.getText() + "," + tft.getText() + ")";
      String query = "INSERT INTO ens.Etudiant VALUES (" + tfcne.getText() + ", '" + tfnom.getText() + "', '" + tfprenom.getText() + "', " + tffid.getText() + "," + tfdid.getText() + ", '" + tft.getText() + "')";
      executeQuery(query);
       showEtudiants();

    }
    
    
    private void deleteRecord(){
        String query = "DELETE FROM ens.Etudiant where CNE=" + tfcne.getText()+"";
        executeQuery(query);
        showEtudiants();
    }
    
  private void searchRecord(){
        String str = tfcne.getText();
        int num = Integer.parseInt(str);
        String query = "SELECT * FROM ens.etudiant where CNE=" + num +"";
        executeQuery(query);
        showEtudiants();
    }
   
  
    
    
 
  private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
  


    @FXML
    private void handleMouseAction(javafx.scene.input.MouseEvent event) {
        
         Etudiant etudiant = tvetudiants.getSelectionModel().getSelectedItem();
   tfcne.setText(""+etudiant.getCne());
   tfprenom.setText(etudiant.getPrenom());
   tfnom.setText(etudiant.getNom());
   tfdid.setText(""+etudiant.getDep_id());
   tffid.setText(""+etudiant.getFiliere_id());
   tft.setText(etudiant.getTel());
        
    }
  

    

    
 
    
}

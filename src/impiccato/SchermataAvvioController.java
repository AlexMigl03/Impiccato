/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impiccato;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alessandro
 */
public class SchermataAvvioController implements Initializable {

    @FXML
    private Button startButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void startBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("impiccato.fxml"));

        Stage primaryStage = (Stage) startButton.getScene().getWindow();
        
        primaryStage.setScene(new Scene(root));        
        primaryStage.setTitle("Impiccato");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}

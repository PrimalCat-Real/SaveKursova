/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.components.Servers;

import deumworld.components.Card.CardController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author PrimalCat
 */
public class ServerController implements Initializable{

    
    
    @FXML private Label startText;
    @FXML private HBox serverList;
    @FXML private BorderPane cardBack;
    private static BorderPane card;
    static CardController myControllerHandle;
    private static List<BorderPane> cards = new ArrayList<BorderPane>();
    public static BorderPane getCard() {
        return card;
    }

    public static void setCard(BorderPane card) {
            cards.add(card);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/deumworld/components/Card/Card.fxml"));
            
            card = loader.load();
            setCard(card);
            myControllerHandle = (CardController)loader.getController();
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (BorderPane bp: cards){
            serverList.getChildren().add(bp);
        }
        
        myControllerHandle.makePlayButton();
    }
    
    
}

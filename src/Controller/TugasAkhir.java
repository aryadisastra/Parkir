/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

/**
 *
 * @author aryz
 */
public class TugasAkhir extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Masuk.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
      //  stage.fullScreenExitKeyProperty();
    //  stage.getFullScreenExitHint();
   //     stage.setFullScreen(true);
    //    stage.setFullScreenExitHint("Layar Anda Otomatis Penuh ");
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

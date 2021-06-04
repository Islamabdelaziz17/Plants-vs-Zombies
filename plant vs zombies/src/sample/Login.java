package sample;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import java.io.*;


public class Login extends Application  {
    
    private Scene scene;
    private  Parent root;
    Stage window;
    Level l;
    
     
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	 Pane root1 = new Pane();
    	 Button b=new Button("New Game");
    	 b.setId("b1");
    	 Button b3=new Button("Exit");
    	 b3.setId("b1");
    	 b.setLayoutX(410); b.setLayoutY(230);
         b3.setLayoutX(435); b3.setLayoutY(290);
    	 root1.getChildren().addAll(b);
    	 root1.getChildren().addAll(b3);
    	 root1.setId("pane");
        
         Scene scene1 = new Scene(root1, 950, 600);
         scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         primaryStage.setResizable(false);
         primaryStage.setScene(scene1);
         primaryStage.setTitle("Plants vs Zombies");
         primaryStage.show();
        
         
         //new game
         EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
             public void handle(ActionEvent e) 
             { 
            	FXMLLoader s = new FXMLLoader(getClass().getResource("Game.fxml"));
             	
                 try {
					root= s.load();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                l=s.getController();
                l.set_window(window);
                l.set_level(1);
                l.set_root(root);
                 TranslateTransition translate = new TranslateTransition();
                 translate.setByX(-340);
                 translate.setDuration(Duration.seconds(2));
                 translate.setCycleCount(2);
                 translate.setAutoReverse(true);
                 translate.setNode(root);
                 translate.play(); 
                 l.prepare_lawnmowers();
                 l.gameloop(primaryStage);
                 
                 scene=new Scene(root,950,600);
             	
                
                 primaryStage.setTitle("Plants vs Zombies  level "+Level.level_number);
                 primaryStage.setResizable(false);
                 primaryStage.setScene(scene);
                 primaryStage.show();
                  
             } 
         }; 
       b.setOnAction(event); 
       
       
       EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() { 
           public void handle(ActionEvent e) 
           { 
          	
               primaryStage.close();
                
           } 
       }; 
     b3.setOnAction(event2); 
 
        
    }

   
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
        Application.launch(Login.class, args);
    }


}
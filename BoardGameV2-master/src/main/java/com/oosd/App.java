package com.oosd;

import com.oosd.observables.MoveReceiverObservable;
import com.oosd.observers.MoveObserver;
import com.oosd.util.Constants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
* 
* 
* @author  Nidhi Chawla
* @version 1.0
* @superclass Application
* @classDescription Main class 
* 					The App Class program Launches the Warrior Combat game  
* 					with Splash screen
* 
*/
public class App extends Application
{

	public static Stage window;
	public static Stage splashStage;
	public static boolean isSplashLoaded = false;
    public static void main( String[] args )
    {
     //Launching JavaFX Application
     	launch(args);
    }
	@Override
	public void start(Stage primaryStage) throws Exception {
		splashStage = primaryStage;
		//Setting up initial scene.
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(Constants.SPLASH_SCREEN));
		Scene scene = new Scene(root);// Create the Scene
		primaryStage.initStyle(StageStyle.UNDECORATED);// Set the style of stage
		primaryStage.setTitle(Constants.APPLICATION_TITLE);//Set the Game Title to the Stage.
		
		primaryStage.setScene(scene);// Set the Main Scene to the stage.
		primaryStage.show();// Display the stage
		
		MoveObserver observer = new MoveObserver(MoveReceiverObservable.getInstance());//create Observers 
		MoveReceiverObservable.getInstance().register(observer);//Register observers
		
	}
}

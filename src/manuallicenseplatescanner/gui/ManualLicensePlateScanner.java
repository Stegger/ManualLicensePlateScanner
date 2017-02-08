/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manuallicenseplatescanner.gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pgn
 */
public class ManualLicensePlateScanner extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("view/LicensePlateScanner.fxml"));

        Scene scene = new Scene(root);
        System.out.println("Method start - THREAD: " + Thread.currentThread().getName());
//        scene.addEventFilter(EventType.ROOT, new EventHandler<Event>() {
//            @Override
//            public void handle(Event event)
//            {
//                System.out.println(event.getEventType().getName() + " - " + event.getClass().getName() + " - " + event.getTarget().getClass().getName());
//            }
//        });

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Method main - THREAD: " + Thread.currentThread().getName());
        launch(args);
        System.out.println("Method main 2 - THREAD: " + Thread.currentThread().getName());
        //Let's do something that takes a while...
        Thread.sleep(10000);
        System.out.println("Method main 3 - THREAD: " + Thread.currentThread().getName());
    }

}

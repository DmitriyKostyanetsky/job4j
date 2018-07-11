package ru.job4j.treads.piangpong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PingPong extends Application{
    private static final String JOB4J = "ping pong";

    @Override
    public void start(Stage primaryStage) throws Exception {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(50, 100, 10, 10);
        group.getChildren().add(rect);
        new Thread(new RectangleMove(rect)).start();
        primaryStage.setScene(new Scene(group, limitX, limitY));
        primaryStage.setTitle(JOB4J);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(
                event -> System.exit(1)
        );
    }
}
package com.example.coinspin;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CoinSpin extends Application
{
    @Override
    public void start(Stage theStage)
    {
        theStage.setTitle("Coin Spin");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(512,512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image space = new Image("space.png");

        AnimatedImage coin = new AnimatedImage();
        Image[] imageArray = new Image[8];
        for (int i = 0; i < 8; i++)
        {
            imageArray[i] = new Image("coin_" + i + ".png");
        }

        coin.frames = imageArray;
        coin.duration = 0.175;

        final long startNanoTime = System.nanoTime();

        new AnimationTimer(){
            public void handle(long currentNanoTime){
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                gc.drawImage(space, 0,0);

                gc.drawImage(coin.getFrame(t), 125,125);
            }
        }.start();
        theStage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
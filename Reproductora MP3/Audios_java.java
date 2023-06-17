package JavaFx.Audios;

import javafx.animation.KeyFrame;

import javafx.animation.Timeline;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;

import javafx.scene.control.Slider;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.TilePane;

import javafx.scene.layout.VBox;

import javafx.scene.media.*;

import javafx.stage.Stage;

import javafx.util.Duration;

import java.io.File;

public class Audios_java extends Application {
    private MediaPlayer Audio;
    private Duration pausa;
    private Runnable Hilo = null;

    private Timeline timeline;
    private File file;
    private Thread hilo = null;

    private boolean isPlaying = false;

    public static void main (String [] args){launch(args);}
    @Override
    public void start(Stage stage) throws Exception {


        VBox Lista_canciones = new VBox(10);

        ListView list_canciones = new ListView();

        Lista_canciones.setPadding(new Insets(20));

        list_canciones.setPrefWidth(100);

        list_canciones.setPrefHeight(100);

        list_canciones.getItems().addAll("What is Love", "Industry baby", "I am blue Eiffel 65", "Madonna  Hung Up Official Video HD"
        , "Bonnie Tyler  Holding Out For A Hero Official HD Video");

        stage.setTitle("Audio");

        Label LblCanciones = new Label("Lista de reproducción");

        Label LbReproduccion = new Label("En reproduccion");

        Label LblVolumen = new Label("Volumen");

        Button BtnPlay = new Button("Play");

        Button BtnPause = new Button("Pause");

        Button BtnReload = new Button("Reload");

        Button BtnStop = new Button("Stop");

        BtnPlay.setPrefSize(150,20);

        BtnStop.setPrefSize(150,20);

        BtnReload.setPrefSize(150,20);

        BtnPause.setPrefSize(150,20);

        BorderPane pane_principal = new BorderPane();

        TilePane pane = new TilePane();

        pane.setPadding(new Insets(10));

        pane.setAlignment(Pos.CENTER);

        pane.setHgap(10.0);

        pane.setVgap(10.0);

        pane_principal.setBottom(pane);

        Lista_canciones.getChildren().addAll(LblCanciones,list_canciones);

        VBox sliders_box = new VBox(10);

        Slider slider = new Slider();

        Slider slider_Volumen = new Slider();

        sliders_box.getChildren().addAll(LblVolumen,slider_Volumen,LbReproduccion, slider);

        sliders_box.setAlignment(Pos.CENTER);

        pane_principal.setTop(sliders_box);

        pane_principal.setCenter(Lista_canciones);

        BorderPane.setMargin(pane_principal, new Insets(10));

        pane.getChildren().addAll(BtnPause,BtnPlay, BtnReload, BtnStop);

        file = new File("src/Resources/y2mate.com - la canción de los memes con mike ohearn  Haddaway  What Is Love Sub Español.mp3");

        Media media = new Media(file.toURI().toString());

        Audio = new MediaPlayer(media);

        list_canciones.setOnMouseClicked(e->{

           if(list_canciones.getSelectionModel().getSelectedItem() != null){

               String item = (String) list_canciones.getSelectionModel().getSelectedItem();
               switch (item){

                   case "What is Love":

                       if(!(Audio.getStatus() == MediaPlayer.Status.PLAYING)) {


                           file = new File("src/Resources/y2mate.com - la canción de los memes con mike ohearn  Haddaway  What Is Love Sub Español.mp3");

                           Media media2 = new Media(file.toURI().toString());

                           Audio = new MediaPlayer(media2);

                           Hilo = new ThreadSlider(Audio, slider, timeline);

                           hilo = new Thread(Hilo);

                           slider_Volumen.valueProperty().addListener(e1 -> Audio.setVolume(slider_Volumen.getValue()));
                       }
                       break;
                   case "Industry baby":

                       if(!(Audio.getStatus() == MediaPlayer.Status.PLAYING)) {
                           file = new File("src/Resources/y2mate.com - lil nas x  industry baby slowed  reverb.mp3");

                           Media media2 = new Media(file.toURI().toString());

                           Audio = new MediaPlayer(media2);

                           Hilo = new ThreadSlider(Audio, slider, timeline);

                           hilo = new Thread(Hilo);

                           slider_Volumen.valueProperty().addListener(e2 -> Audio.setVolume(slider_Volumen.getValue()));
                       }
                       break;

                   case "I am blue Eiffel 65":
                       if(!(Audio.getStatus() == MediaPlayer.Status.PLAYING)) {

                           file = new File("src/Resources/y2mate.com - Eiffel 65  Blue Da Ba Dee  Sub Español.mp3");

                           Media media2 = new Media(file.toURI().toString());

                           Audio = new MediaPlayer(media2);

                           Hilo = new ThreadSlider(Audio, slider, timeline);

                           hilo = new Thread(Hilo);

                           slider_Volumen.valueProperty().addListener(e3 -> Audio.setVolume(slider_Volumen.getValue()));
                       }
                       break;
                   case "Madonna  Hung Up Official Video HD":
                       if(!(Audio.getStatus() == MediaPlayer.Status.PLAYING)) {

                           file = new File("src/Resources/y2mate.com - Madonna  Hung Up Official Video HD.mp3");

                           Media media2 = new Media(file.toURI().toString());

                           Audio = new MediaPlayer(media2);

                           Hilo = new ThreadSlider(Audio, slider, timeline);

                           hilo = new Thread(Hilo);

                           slider_Volumen.valueProperty().addListener(e3 -> Audio.setVolume(slider_Volumen.getValue()));
                       }
                       break;
                   case "Bonnie Tyler  Holding Out For A Hero Official HD Video":
                       if(!(Audio.getStatus() == MediaPlayer.Status.PLAYING)) {

                           file = new File("src/Resources/Bonnie Tyler  Holding Out For A Hero Official HD Video.mp3");

                           Media media2 = new Media(file.toURI().toString());

                           Audio = new MediaPlayer(media2);

                           Hilo = new ThreadSlider(Audio, slider, timeline);

                           hilo = new Thread(Hilo);

                           slider_Volumen.valueProperty().addListener(e3 -> Audio.setVolume(slider_Volumen.getValue()));
                       }
                       break;
               }
           }

        });

        /*file = new File("src/y2mate.com - la canción de los memes con mike ohearn  Haddaway  What Is Love Sub Español.mp3");

        Media media = new Media(file.toURI().toString());

        Audio = new MediaPlayer(media);*/

        slider_Volumen.setMin(0);

        slider_Volumen.setMax(100.0);

        slider.valueProperty().addListener(e->{

          Audio.setVolume(slider.getValue());

        });
        int i = 0;
        BtnPlay.setOnAction(e->{

            if(Audio!=null){

                Audio.play();

                hilo.run();
            }
            isPlaying = true;
        });

        BtnStop.setOnAction(e->Audio.stop());

        BtnPause.setOnAction(e-> {

            pausa = Audio.getCurrentTime();

            Audio.pause();

            isPlaying = false;
        });

        BtnReload.setOnAction(e->{

            Audio.setStartTime(pausa);

            Audio.play();

        });

        Scene scene = new Scene(pane_principal,450,350);

        stage.setScene(scene);

        stage.show();

    }
}
class ThreadSlider implements  Runnable{
    MediaPlayer audio = null;

    Slider slider = null;

    Timeline time2;

    public ThreadSlider(MediaPlayer audio, Slider slider, Timeline time){
        this.audio = audio;
        this.slider = slider;
        time2 = time;
    }
    double value = 0.0;
    @Override
    public void run() {
         time2 = new Timeline(new KeyFrame(Duration.seconds(1), event -> {

            MediaPlayer.Status status = audio.getStatus();

            slider.setMax(audio.getTotalDuration().toSeconds());

            if (status == MediaPlayer.Status.PLAYING) {

                System.out.println("Audio en reproducción");

                slider.adjustValue(audio.getCurrentTime().toSeconds()+value);

            } else if (status == MediaPlayer.Status.PAUSED) {
                // El audio está en pausa
                System.out.println("Audio en pausa");
                time2.stop();

            } else if (status == MediaPlayer.Status.STOPPED) {
                // El audio se ha detenido
                event.consume();
            }
        }));

        time2.setCycleCount(Timeline.INDEFINITE);

        time2.play();
    }
}

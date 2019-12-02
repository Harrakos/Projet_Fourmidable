package jeu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Model model = new Model();
        View view = new View(model);
        new Controller(view,model).start();
        primaryStage.setTitle("Fourmidable");
        primaryStage.setScene(view.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();

        exitApplication(primaryStage);

    }

    private void exitApplication(Stage primaryStage) {

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.exit(0);
            }
        });
    }



}

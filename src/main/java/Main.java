import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        LabyrintheView labyrinthe = new LabyrintheView(10, 10);
        PaletteView palette = new PaletteView();

        BorderPane root = new BorderPane();
        root.setCenter(labyrinthe.getRoot());
        root.setLeft(palette.getRoot());

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Labyrinthe - Drag & Drop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class PaletteView {
    private final VBox root;
    private final String[] elements = {"mouton", "loup", "herbe", "cactus", "marguerite","rocher", "sortie"};

    public PaletteView() {
        root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        for (String type : elements) {
            ImageView image = new ImageView(new Image("Images/" + type + ".png"));
            image.setFitWidth(40);
            image.setFitHeight(40);

            image.setOnDragDetected(event -> {
                Dragboard db = image.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putString(type);
                db.setContent(content);
                event.consume();
            });

            root.getChildren().add(image);
        }
    }

    public VBox getRoot() {
        return root;
    }
}
